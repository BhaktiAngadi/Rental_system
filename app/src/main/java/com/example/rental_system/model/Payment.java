package com.example.rental_system.model;

public class Payment {

    private String paymentId;
    private String tenantId;
    private double amount;
    private String paymentDate;
    private String status;

    public Payment(
            String paymentId,
            String tenantId,
            double amount,
            String paymentDate,
            String status) {

        this.paymentId = paymentId;
        this.tenantId = tenantId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.status = status;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public String getStatus() {
        return status;
    }
}