package net.demo.entities;

import net.demo.enums.RoomType;

import java.util.Objects;

public class Room {
    private int roomNumber;
    private double pricePerNight;
    private RoomType roomType;
    private boolean available;

    public Room(RoomType roomType, int roomNumber,double pricePerNight, boolean available) {
        this.roomType = roomType;
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
        this.available = available;
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

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
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
        return roomNumber == room.roomNumber && Double.compare(pricePerNight, room.pricePerNight) == 0 && available == room.available && roomType == room.roomType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber, pricePerNight, roomType, available);
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", pricePerNight=" + pricePerNight +
                ", roomType=" + roomType +
                ", available=" + available +
                '}';
    }
}
