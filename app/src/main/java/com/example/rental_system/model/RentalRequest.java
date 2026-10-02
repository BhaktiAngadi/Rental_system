package com.example.rental_system.model;

public class RentalRequest {

    private String requestId;
    private String roomId;
    private String tenantId;
    private String roomType;
    private String location;
    private double rent;
    private String status;

    public RentalRequest(
            String requestId,
            String roomId,
            String tenantId,
            String roomType,
            String location,
            double rent,
            String status) {

        this.requestId = requestId;
        this.roomId = roomId;
        this.tenantId = tenantId;
        this.roomType = roomType;
        this.location = location;
        this.rent = rent;
        this.status = status;
    }

    public String getRequestId() {
        return requestId;
    }

    public String getRoomId() {
        return roomId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getLocation() {
        return location;
    }

    public double getRent() {
        return rent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}