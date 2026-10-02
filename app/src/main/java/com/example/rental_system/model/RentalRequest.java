package com.example.rental_system.model;

public class RentalRequest {

    private String requestId;
    private String tenantId;
    private String roomId;
    private String status;

    public RentalRequest(
            String requestId,
            String tenantId,
            String roomId) {

        this.requestId = requestId;
        this.tenantId = tenantId;
        this.roomId = roomId;
        this.status = "Pending";
    }

    public String getRequestId() {
        return requestId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public String getRoomId() {
        return roomId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}