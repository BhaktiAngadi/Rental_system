package com.example.rental_system;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RoomDetailsActivity extends AppCompatActivity {

    TextView tvRoomType;
    TextView tvLocation;
    TextView tvRent;
    TextView tvRoomId;
    TextView tvAvailability;

    Button btnRequestRent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_details);

        tvRoomType = findViewById(R.id.tvRoomType);
        tvLocation = findViewById(R.id.tvLocation);
        tvRent = findViewById(R.id.tvRent);
        tvRoomId = findViewById(R.id.tvRoomId);
        tvAvailability = findViewById(R.id.tvAvailability);

        btnRequestRent = findViewById(R.id.btnRequestRent);

        // Get room information from BrowseRoomsActivity
        String roomId = getIntent().getStringExtra("roomId");
        String roomType = getIntent().getStringExtra("roomType");
        String location = getIntent().getStringExtra("location");
        double rent = getIntent().getDoubleExtra("rent", 0);
        boolean available = getIntent().getBooleanExtra("available", false);

        // Display room information
        tvRoomId.setText("Room ID: " + roomId);
        tvRoomType.setText(roomType);
        tvLocation.setText("📍 " + location);
        tvRent.setText("₹" + rent + " / month");

        if (available) {
            tvAvailability.setText("Available");
        } else {
            tvAvailability.setText("Not Available");
        }

        btnRequestRent.setOnClickListener(v -> {

            // Rental request will be implemented in Step 6
            android.widget.Toast.makeText(
                    RoomDetailsActivity.this,
                    "Rental Request will be added in Step 6",
                    android.widget.Toast.LENGTH_SHORT
            ).show();

        });
    }
}