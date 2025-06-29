package net.demo.services.impl;

import net.demo.entities.Booking;
import net.demo.entities.Room;
import net.demo.entities.User;
import net.demo.exceptions.ResourceNotFoundException;
import net.demo.services.BookingService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static java.lang.String.format;

public class BookingServiceImpl implements BookingService {
    private final List<Booking> bookings = new ArrayList<>();
    private final List<Room> rooms;
    private final List<User> users;

    public BookingServiceImpl(List<Room> rooms, List<User> users) {
        this.rooms = rooms;
        this.users = users;
    }

    @Override
    public void bookRoom(int userId, int roomNumber, LocalDate checkIn, LocalDate checkOut) {
        // check if the room exists or not
        var room = rooms.stream()
                .filter(rm -> rm.getRoomNumber() == roomNumber)
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException(format("Room identified by %s not found", roomNumber)));

        // check if the user exists, if not the user will be created
        var user = users.stream()
                .filter(user1 -> user1.getUserId() == userId)
                .findFirst()
                .orElseGet(() -> {
                    var newUser = new User(userId,500.0,LocalDate.now());
                    users.add(newUser);
                    return newUser;
                });

        var booking = new Booking(generateBookingNumber(),room,checkIn,checkOut,LocalDate.now(),user);
        checkBooking(booking);

        if (!roomIsAvailable(booking)) {
            throw new ResourceNotFoundException(format("Room number %s is not available for the give date",booking.getRoom().getRoomNumber()));
        } else {
            double bookingTotal = bookingTotalAmount(booking);
            booking.setTotalPrice(bookingTotal);
            bookings.add(booking);

            // update user balance after the booking is successful
            double updatedBalance = calculateBookingTotal(booking);
            user.setBalance(updatedBalance);
        }
    }

    @Override
    public void printAll() {
        bookings.stream()
                .sorted(Comparator.comparing(Booking::getBookingDate).reversed())
                .forEach(System.out::println);
    }

    private void checkBooking(Booking booking) {
        if (booking.getCheckOutDate().isBefore(booking.getCheckInDate()) || booking.getCheckOutDate().equals(booking.getCheckInDate()))
            throw new ResourceNotFoundException("CheckOut Date cannot be after or equals to the CheckIn Date");
        if (booking.getCheckInDate().isBefore(LocalDate.now()))
            throw new ResourceNotFoundException("CheckIn Date is invalid");
    }

    private boolean roomIsAvailable(Booking booking) {
        return bookings.stream()
                .filter(b -> b.getRoom().getRoomNumber() == booking.getRoom().getRoomNumber())
                .noneMatch(b -> datesConflict(booking.getCheckInDate(), booking.getCheckOutDate(), b.getCheckInDate(), b.getCheckOutDate()));
    }

    private boolean datesConflict(LocalDate start1, LocalDate end1, LocalDate start2, LocalDate end2) {
        return !end1.isBefore(start2) && !start1.isAfter(end2);
    }

    private double calculateBookingTotal(Booking booking) {
        // Get the nbr of the nights requested by the user
        long nbrNights = ChronoUnit.DAYS.between(booking.getCheckInDate(), booking.getCheckOutDate());
        double totalPrice = nbrNights * booking.getRoom().getPricePerNight();
        double userInitialBalance = booking.getUser().getBalance();

        if (userInitialBalance < totalPrice){
            throw new ResourceNotFoundException("User Balance Not Enough to book this room for the given period");
        } else {
            return userInitialBalance - totalPrice;
        }
    }

    private double bookingTotalAmount(Booking booking) {
        // Get the nbr of the nights requested by the user then calculate the total amount based on it
        long nbrNights = ChronoUnit.DAYS.between(booking.getCheckInDate(), booking.getCheckOutDate());
        return nbrNights * booking.getRoom().getPricePerNight();
    }

    private int generateBookingNumber() {
        Random random = new Random();
        return random.nextInt(100_000,999_999);
    }
}
