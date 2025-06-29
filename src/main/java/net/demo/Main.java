package net.demo;

import net.demo.entities.Room;
import net.demo.entities.User;
import net.demo.enums.RoomType;
import net.demo.services.BookingService;
import net.demo.services.RoomService;
import net.demo.services.UserService;
import net.demo.services.impl.BookingServiceImpl;
import net.demo.services.impl.RoomServiceImpl;
import net.demo.services.impl.UserServiceImpl;

import java.time.LocalDate;
import java.util.List;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // creation of rooms
        RoomService roomService = new RoomServiceImpl();
        roomService.setRoom(1, RoomType.STANDARD, 1000);
        roomService.setRoom(2, RoomType.JUNIOR, 2000);
        roomService.setRoom(3, RoomType.SUITE, 3000);
        List<Room> rooms = roomService.getAllRooms();

        // Create Users
        UserService userService = new UserServiceImpl();
        userService.setUser(1,5000);
        userService.setUser(2,10000);
        List<User> users = userService.getAllUsers();

        // creation of bookings
        BookingService bookingService = new BookingServiceImpl(rooms, users);
        bookingService.bookRoom(1,1, LocalDate.of(2025,6,30) ,LocalDate.of(2025,7,2));
        bookingService.bookRoom(2,1, LocalDate.of(2025,7,30) ,LocalDate.of(2025,8,3));

        System.out.println("*******************************************************");

        // printAll the booking
        bookingService.printAll();

        System.out.println("*******************************************************");

        // printAll Users
        userService.printAllUsers();

        System.out.println("*******************************************************");
    }
}