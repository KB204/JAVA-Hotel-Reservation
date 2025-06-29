package net.demo.services;

import net.demo.entities.Room;
import net.demo.enums.RoomType;

import java.util.List;

public interface RoomService {
    void setRoom(int roomNumber, RoomType roomType, double roomPricePerNight);
    List<Room> getAllRooms();
}
