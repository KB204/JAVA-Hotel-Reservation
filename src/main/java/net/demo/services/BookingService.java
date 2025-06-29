package net.demo.services;

import java.time.LocalDate;

public interface BookingService {
    void bookRoom(int userId, int roomNumber, LocalDate checkIn, LocalDate checkOut);
    void printAll();
}
