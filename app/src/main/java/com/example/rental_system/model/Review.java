package com.example.rental_system.model;

// Encapsulation
public class Review {

    private String reviewId;
    private String tenantId;
    private String roomId;
    private int rating;
    private String comment;
    private String date;

    public Review(
            String reviewId,
            String tenantId,
            String roomId,
            int rating,
            String comment,
            String date) {

        this.reviewId = reviewId;
        this.tenantId = tenantId;
        this.roomId = roomId;
        this.rating = rating;
        this.comment = comment;
        this.date = date;
    }

    public String getReviewId() {
        return reviewId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public String getRoomId() {
        return roomId;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public String getDate() {
        return date;
    }
}