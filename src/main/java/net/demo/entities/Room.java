package net.demo.entities;

import net.demo.enums.RoomType;

import java.util.Objects;

public class Room {
    private int roomNumber;
    private double pricePerNight;
    private RoomType roomType;

    public Room(RoomType roomType, int roomNumber,double pricePerNight) {
        this.roomType = roomType;
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Room room)) return false;
        return roomNumber == room.roomNumber && Double.compare(pricePerNight, room.pricePerNight) == 0 && roomType == room.roomType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber, pricePerNight, roomType);
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", pricePerNight=" + pricePerNight +
                ", roomType=" + roomType +
                '}';
    }
}
