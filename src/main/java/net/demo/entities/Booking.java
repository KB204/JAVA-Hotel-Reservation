package net.demo.entities;

import java.time.LocalDate;
import java.util.Objects;

public class Booking {
    private int bookingID;
    private Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private LocalDate bookingDate;
    private double totalPrice;
    private User user;

    public Booking(int bookingID, Room room, LocalDate checkInDate, LocalDate checkOutDate, LocalDate bookingDate, User user) {
        this.bookingID = bookingID;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.bookingDate = bookingDate;
        this.user = user;
    }


    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public Room getRoom() {
        return room;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Booking booking)) return false;
        return bookingID == booking.bookingID && Double.compare(totalPrice, booking.totalPrice) == 0 && Objects.equals(room, booking.room) && Objects.equals(checkInDate, booking.checkInDate) && Objects.equals(checkOutDate, booking.checkOutDate) && Objects.equals(bookingDate, booking.bookingDate) && Objects.equals(user, booking.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingID, room, checkInDate, checkOutDate, bookingDate, totalPrice, user);
    }

    @Override
    public String toString() {
        return "\nBooking{" +
                "\n  bookingID=" + bookingID +
                ",\n  checkInDate=" + checkInDate +
                ",\n  checkOutDate=" + checkOutDate +
                ",\n  bookingDate=" + bookingDate +
                ",\n  totalPrice=" + totalPrice +
                ",\n  room=" + room +
                ",\n  user=" + user +
                "\n}";
    }
}
