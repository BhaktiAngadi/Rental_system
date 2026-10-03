package com.example.rental_system;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MyRequestsActivity extends AppCompatActivity {

    LinearLayout layoutRequests;
    TextView tvNoRequests;

    LinearLayout navHome;
    LinearLayout navBrowse;
    LinearLayout navRequests;
    LinearLayout navProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_requests);

        layoutRequests = findViewById(R.id.layoutRequests);
        tvNoRequests = findViewById(R.id.tvNoRequests);

        navHome = findViewById(R.id.navHome);
        navBrowse = findViewById(R.id.navBrowse);
        navRequests = findViewById(R.id.navRequests);
        navProfile = findViewById(R.id.navProfile);


        // Get request information
        String requestId =
                getIntent().getStringExtra("requestId");

        String roomId =
                getIntent().getStringExtra("roomId");

        String roomType =
                getIntent().getStringExtra("roomType");

        String location =
                getIntent().getStringExtra("location");

        double rent =
                getIntent().getDoubleExtra("rent", 0);

        String status =
                getIntent().getStringExtra("status");


        // Display request
        if (roomId != null) {

            tvNoRequests.setVisibility(TextView.GONE);

            createRequestCard(
                    requestId,
                    roomId,
                    roomType,
                    location,
                    rent,
                    status
            );

        } else {

            tvNoRequests.setVisibility(TextView.VISIBLE);
        }


        // Home
        navHome.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MyRequestsActivity.this,
                    TenantHomeActivity.class
            );

            startActivity(intent);
            finish();
        });


        // Browse
        navBrowse.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MyRequestsActivity.this,
                    BrowseRoomsActivity.class
            );

            startActivity(intent);
            finish();
        });


        // Requests
        navRequests.setOnClickListener(v -> {

            // Already on My Requests
        });


        // PROFILE
        navProfile.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MyRequestsActivity.this,
                    ProfileActivity.class
            );

            startActivity(intent);
            finish();
        });
    }


    // -----------------------------------------
    // CREATE REQUEST CARD
    // -----------------------------------------

    private void createRequestCard(
            String requestId,
            String roomId,
            String roomType,
            String location,
            double rent,
            String status) {


        CardView card = new CardView(this);

        card.setRadius(20);
        card.setCardElevation(6);


        LinearLayout.LayoutParams cardParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        cardParams.setMargins(0, 8, 0, 20);

        card.setLayoutParams(cardParams);


        // Card content
        LinearLayout content =
                new LinearLayout(this);

        content.setOrientation(
                LinearLayout.VERTICAL
        );

        content.setPadding(
                24,
                24,
                24,
                24
        );


        // Room type
        TextView roomName =
                new TextView(this);

        roomName.setText(roomType);
        roomName.setTextSize(20);
        roomName.setTextColor(
                Color.rgb(34, 34, 34)
        );

        roomName.setTypeface(null, 1);


        // Location
        TextView locationText =
                new TextView(this);

        locationText.setText(
                "📍 " + location
        );

        locationText.setTextSize(15);

        locationText.setTextColor(
                Color.DKGRAY
        );

        LinearLayout.LayoutParams locationParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        locationParams.setMargins(0, 8, 0, 0);

        locationText.setLayoutParams(locationParams);


        // Rent
        TextView rentText =
                new TextView(this);

        rentText.setText(
                "₹" + rent + " / month"
        );

        rentText.setTextSize(16);

        rentText.setTypeface(null, 1);

        LinearLayout.LayoutParams rentParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        rentParams.setMargins(0, 10, 0, 0);

        rentText.setLayoutParams(rentParams);


        // Request ID
        TextView requestText =
                new TextView(this);

        requestText.setText(
                "Request ID: " + requestId
        );

        requestText.setTextSize(13);

        requestText.setTextColor(
                Color.GRAY
        );

        LinearLayout.LayoutParams requestParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        requestParams.setMargins(0, 10, 0, 0);

        requestText.setLayoutParams(requestParams);


        // Room ID
        TextView roomIdText =
                new TextView(this);

        roomIdText.setText(
                "Room ID: " + roomId
        );

        roomIdText.setTextSize(13);

        roomIdText.setTextColor(
                Color.GRAY
        );


        // Status
        TextView statusText =
                new TextView(this);

        statusText.setText(
                "Status: " + status
        );

        statusText.setTextSize(15);

        statusText.setTypeface(null, 1);

        statusText.setGravity(
                Gravity.CENTER
        );

        LinearLayout.LayoutParams statusParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        statusParams.setMargins(
                0,
                15,
                0,
                0
        );

        statusText.setLayoutParams(statusParams);


        // Add everything
        content.addView(roomName);
        content.addView(locationText);
        content.addView(rentText);
        content.addView(requestText);
        content.addView(roomIdText);
        content.addView(statusText);

        card.addView(content);

        layoutRequests.addView(card);
    }
}