package com.example.rental_system;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.rental_system.model.Review;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ReviewActivity extends AppCompatActivity {

    EditText etReviewRoomId;
    EditText etReviewComment;

    RatingBar ratingBar;

    Button btnSubmitReview;

    LinearLayout layoutReviews;
    TextView tvNoReviews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_review);

        etReviewRoomId =
                findViewById(R.id.etReviewRoomId);

        etReviewComment =
                findViewById(R.id.etReviewComment);

        ratingBar =
                findViewById(R.id.ratingBar);

        btnSubmitReview =
                findViewById(R.id.btnSubmitReview);

        layoutReviews =
                findViewById(R.id.layoutReviews);

        tvNoReviews =
                findViewById(R.id.tvNoReviews);


        btnSubmitReview.setOnClickListener(v -> {

            String roomId =
                    etReviewRoomId.getText()
                            .toString()
                            .trim();

            String comment =
                    etReviewComment.getText()
                            .toString()
                            .trim();

            int rating =
                    (int) ratingBar.getRating();


            // Validation

            if (roomId.isEmpty()) {

                etReviewRoomId.setError(
                        "Enter room ID"
                );

                return;
            }

            if (comment.isEmpty()) {

                etReviewComment.setError(
                        "Write your review"
                );

                return;
            }


            if (rating == 0) {

                Toast.makeText(
                        ReviewActivity.this,
                        "Please select a rating",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }


            // Date

            String date =
                    new SimpleDateFormat(
                            "dd/MM/yyyy",
                            Locale.getDefault()
                    ).format(new Date());


            // Create Review object

            Review review =
                    new Review(
                            "REV001",
                            "TENANT001",
                            roomId,
                            rating,
                            comment,
                            date
                    );


            // Display review

            addReviewCard(review);


            // Clear fields

            etReviewRoomId.setText("");
            etReviewComment.setText("");
            ratingBar.setRating(5);


            Toast.makeText(
                    ReviewActivity.this,
                    "Review submitted successfully",
                    Toast.LENGTH_SHORT
            ).show();

        });
    }


    private void addReviewCard(Review review) {

        tvNoReviews.setVisibility(TextView.GONE);


        CardView card =
                new CardView(this);

        card.setRadius(20);
        card.setCardElevation(6);


        LinearLayout.LayoutParams cardParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        cardParams.setMargins(
                0,
                8,
                0,
                16
        );

        card.setLayoutParams(cardParams);


        LinearLayout content =
                new LinearLayout(this);

        content.setOrientation(
                LinearLayout.VERTICAL
        );

        content.setPadding(
                25,
                25,
                25,
                25
        );


        // Room ID

        TextView room =
                new TextView(this);

        room.setText(
                "Room ID: " + review.getRoomId()
        );

        room.setTextSize(16);
        room.setTypeface(null, 1);


        // Rating

        TextView rating =
                new TextView(this);

        rating.setText(
                "Rating: "
                        + review.getRating()
                        + " / 5"
        );

        rating.setTextSize(16);

        rating.setGravity(
                Gravity.CENTER_VERTICAL
        );


        // Comment

        TextView comment =
                new TextView(this);

        comment.setText(
                review.getComment()
        );

        comment.setTextSize(15);
        comment.setTextColor(
                0xFF666666
        );


        // Date

        TextView date =
                new TextView(this);

        date.setText(
                "Date: " + review.getDate()
        );

        date.setTextSize(14);
        date.setTextColor(
                0xFF777777
        );


        content.addView(room);
        content.addView(rating);
        content.addView(comment);
        content.addView(date);

        card.addView(content);

        layoutReviews.addView(card);
    }
}