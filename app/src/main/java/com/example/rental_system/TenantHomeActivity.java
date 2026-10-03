package com.example.rental_system;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TenantHomeActivity extends AppCompatActivity {

    LinearLayout layoutBrowseRooms;
    LinearLayout layoutMyRequests;

    TextView tvViewRooms;

    LinearLayout navHome;
    LinearLayout navBrowse;
    LinearLayout navRequests;
    LinearLayout navProfile;
    LinearLayout layoutCurrentRental;
    LinearLayout layoutComplaints;
    LinearLayout layoutReviews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_home);

        // Quick Access
        layoutBrowseRooms = findViewById(R.id.layoutBrowseRooms);
        layoutMyRequests = findViewById(R.id.layoutMyRequests);

        // View Available Rooms
        tvViewRooms = findViewById(R.id.tvViewRooms);

        //current rental

        layoutCurrentRental = findViewById(R.id.layoutCurrentRental);

        //complaint
        layoutComplaints = findViewById(R.id.layoutComplaints);

        //review
        layoutReviews = findViewById(R.id.layoutReviews);

        // Bottom Navigation
        navHome = findViewById(R.id.navHome);
        navBrowse = findViewById(R.id.navBrowse);
        navRequests = findViewById(R.id.navRequests);
        navProfile = findViewById(R.id.navProfile);


        // Browse Rooms
        layoutBrowseRooms.setOnClickListener(v -> {

            Intent intent = new Intent(
                    TenantHomeActivity.this,
                    BrowseRoomsActivity.class
            );

            startActivity(intent);
        });


        // My Requests
        layoutMyRequests.setOnClickListener(v -> {

            Intent intent = new Intent(
                    TenantHomeActivity.this,
                    MyRequestsActivity.class
            );

            startActivity(intent);
        });


        // View Available Rooms
        tvViewRooms.setOnClickListener(v -> {

            Intent intent = new Intent(
                    TenantHomeActivity.this,
                    BrowseRoomsActivity.class
            );

            startActivity(intent);
        });


        // Bottom Navigation - Home
        navHome.setOnClickListener(v -> {

            Toast.makeText(
                    TenantHomeActivity.this,
                    "Home",
                    Toast.LENGTH_SHORT
            ).show();

        });


        // Bottom Navigation - Browse
        navBrowse.setOnClickListener(v -> {

            Intent intent = new Intent(
                    TenantHomeActivity.this,
                    BrowseRoomsActivity.class
            );

            startActivity(intent);
        });


        // Bottom Navigation - Requests
        navRequests.setOnClickListener(v -> {

            Intent intent = new Intent(
                    TenantHomeActivity.this,
                    MyRequestsActivity.class
            );

            startActivity(intent);
        });


        // Bottom Navigation - Profile
        // Profile
        navProfile.setOnClickListener(v -> {

            Intent intent = new Intent(
                    TenantHomeActivity.this,
                    ProfileActivity.class
            );

            startActivity(intent);

        });

        //current rental
        layoutCurrentRental.setOnClickListener(v -> {

            Intent intent = new Intent(
                    TenantHomeActivity.this,
                    ActiveRentalActivity.class
            );

            startActivity(intent);
        });


        // Complaints
        layoutComplaints.setOnClickListener(v -> {

            Intent intent = new Intent(
                    TenantHomeActivity.this,
                    ComplaintActivity.class
            );

            startActivity(intent);
        });

        // Reviews
        layoutReviews.setOnClickListener(v -> {

            Intent intent = new Intent(
                    TenantHomeActivity.this,
                    ReviewActivity.class
            );

            startActivity(intent);

        });
    }
}