package com.example.rental_system;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rental_system.model.RentalRequest;

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

        // Get room information
        String roomId = getIntent().getStringExtra("roomId");
        String roomType = getIntent().getStringExtra("roomType");
        String location = getIntent().getStringExtra("location");

        double rent = getIntent().getDoubleExtra("rent", 0);

        boolean available =
                getIntent().getBooleanExtra("available", false);

        // Display room information
        tvRoomId.setText("Room ID: " + roomId);
        tvRoomType.setText(roomType);
        tvLocation.setText("📍 " + location);
        tvRent.setText("₹" + rent + " / month");

        if (available) {

            tvAvailability.setText("Available");
            btnRequestRent.setEnabled(true);

        } else {

            tvAvailability.setText("Not Available");
            btnRequestRent.setEnabled(false);
        }


        // Request to Rent
        btnRequestRent.setOnClickListener(v -> {

            // Create RentalRequest object
            RentalRequest request = new RentalRequest(
                    "REQ001",
                    roomId,
                    "TENANT001",
                    roomType,
                    location,
                    rent,
                    "Pending"
            );

            Toast.makeText(
                    RoomDetailsActivity.this,
                    "Rental request submitted",
                    Toast.LENGTH_SHORT
            ).show();


            // Open My Requests
            Intent intent = new Intent(
                    RoomDetailsActivity.this,
                    MyRequestsActivity.class
            );

            // Send complete request information
            intent.putExtra(
                    "requestId",
                    request.getRequestId()
            );

            intent.putExtra(
                    "roomId",
                    request.getRoomId()
            );

            intent.putExtra(
                    "roomType",
                    request.getRoomType()
            );

            intent.putExtra(
                    "location",
                    request.getLocation()
            );

            intent.putExtra(
                    "rent",
                    request.getRent()
            );

            intent.putExtra(
                    "status",
                    request.getStatus()
            );

            startActivity(intent);
            finish();
        });
    }
}