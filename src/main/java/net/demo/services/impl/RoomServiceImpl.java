package net.demo.services.impl;

import net.demo.entities.Room;
import net.demo.enums.RoomType;
import net.demo.exceptions.ResourceAlreadyExists;
import net.demo.exceptions.ResourceNotFoundException;
import net.demo.services.RoomService;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.*;

public class RoomServiceImpl implements RoomService {
    private final List<Room> rooms = new ArrayList<>();

    @Override
    public void setRoom(int roomNumber, RoomType roomType, double roomPricePerNight) {
        var room = new Room(roomType,roomNumber,roomPricePerNight,true);
        checkRoom(room);
    }

    @Override
    public List<Room> getAllRooms() {
        return rooms;
    }

    private void checkRoom(Room room) {
        if (room.getPricePerNight() <= 0)
            throw new ResourceNotFoundException("Price per night must be greater than 0");
        if (rooms.contains(room)){
            throw new ResourceAlreadyExists(format("Room %s already exists", room.getRoomNumber()));
        } else {
            rooms.add(room);
        }
    }
}
