package com.example.rental_system;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MyRequestsActivity extends AppCompatActivity {

    LinearLayout layoutRequests;
    TextView tvNoRequests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_requests);

        layoutRequests = findViewById(R.id.layoutRequests);
        tvNoRequests = findViewById(R.id.tvNoRequests);

        String roomId = getIntent().getStringExtra("roomId");
        String roomType = getIntent().getStringExtra("roomType");
        String location = getIntent().getStringExtra("location");
        double rent = getIntent().getDoubleExtra("rent", 0);

        if (roomId != null) {

            tvNoRequests.setVisibility(TextView.GONE);

            // -----------------------------
            // CARD
            // -----------------------------

            CardView card = new CardView(this);

            card.setRadius(20);
            card.setCardElevation(8);

            LinearLayout.LayoutParams cardParams =
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.MATCH_PARENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    );

            cardParams.setMargins(0, 10, 0, 20);

            card.setLayoutParams(cardParams);

            // -----------------------------
            // CONTENT INSIDE CARD
            // -----------------------------

            LinearLayout cardContent = new LinearLayout(this);

            cardContent.setOrientation(LinearLayout.VERTICAL);
            cardContent.setPadding(25, 25, 25, 25);

            // Room type
            TextView roomName = new TextView(this);

            roomName.setText(roomType);
            roomName.setTextSize(21);
            roomName.setTypeface(null, 1);

            // Location
            TextView roomLocation = new TextView(this);

            roomLocation.setText("📍 " + location);
            roomLocation.setTextSize(16);

            // Rent
            TextView roomRent = new TextView(this);

            roomRent.setText("₹" + rent + " / month");
            roomRent.setTextSize(17);

            // Room ID
            TextView roomIdText = new TextView(this);

            roomIdText.setText("Room ID: " + roomId);
            roomIdText.setTextSize(14);

            // Status
            TextView status = new TextView(this);

            status.setText("Pending");
            status.setTextSize(16);
            status.setTypeface(null, 1);
            status.setGravity(Gravity.CENTER);

            LinearLayout.LayoutParams statusParams =
                    new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.WRAP_CONTENT,
                            LinearLayout.LayoutParams.WRAP_CONTENT
                    );

            statusParams.setMargins(0, 15, 0, 0);

            status.setLayoutParams(statusParams);

            // -----------------------------
            // ADD CONTENT TO CARD
            // -----------------------------

            cardContent.addView(roomName);
            cardContent.addView(roomLocation);
            cardContent.addView(roomRent);
            cardContent.addView(roomIdText);
            cardContent.addView(status);

            card.addView(cardContent);

            // -----------------------------
            // ADD CARD TO SCREEN
            // -----------------------------

            layoutRequests.addView(card);
        }
    }
}