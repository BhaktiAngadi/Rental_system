package com.example.rental_system.model;
//encapsulation
public class Room {

    private String roomId;
    private String roomType;
    private String location;
    private double monthlyRent;
    private boolean available;

    public Room(
            String roomId,
            String roomType,
            String location,
            double monthlyRent,
            boolean available) {

        this.roomId = roomId;
        this.roomType = roomType;
        this.location = location;
        this.monthlyRent = monthlyRent;
        this.available = available;
    }

    public String getRoomId() {
        return roomId;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getLocation() {
        return location;
    }

    public double getMonthlyRent() {
        return monthlyRent;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setMonthlyRent(double monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}