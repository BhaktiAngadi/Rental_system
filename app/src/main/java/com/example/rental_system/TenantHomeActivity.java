package com.example.rental_system;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TenantHomeActivity extends AppCompatActivity {

    EditText etSearch;

    LinearLayout layoutBrowseRooms;
    LinearLayout layoutMyRequests;

    TextView tvViewRooms;

    LinearLayout navHome;
    LinearLayout navBrowse;
    LinearLayout navRequests;
    LinearLayout navProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenant_home);

        // Search
        etSearch = findViewById(R.id.etSearch);

        // Quick Access
        layoutBrowseRooms = findViewById(R.id.layoutBrowseRooms);
        layoutMyRequests = findViewById(R.id.layoutMyRequests);

        // View Available Rooms
        tvViewRooms = findViewById(R.id.tvViewRooms);

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

            Toast.makeText(
                    TenantHomeActivity.this,
                    "My Requests selected",
                    Toast.LENGTH_SHORT
            ).show();

            // We will connect this to MyRequestsActivity later
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

            Toast.makeText(
                    TenantHomeActivity.this,
                    "Browse",
                    Toast.LENGTH_SHORT
            ).show();

            // We will connect Browse screen later
        });


        // Bottom Navigation - Requests
        navRequests.setOnClickListener(v -> {

            Toast.makeText(
                    TenantHomeActivity.this,
                    "Requests",
                    Toast.LENGTH_SHORT
            ).show();

            // We will connect My Requests screen later
        });


        // Bottom Navigation - Profile
        navProfile.setOnClickListener(v -> {

            Toast.makeText(
                    TenantHomeActivity.this,
                    "Profile",
                    Toast.LENGTH_SHORT
            ).show();

            // We will create Profile screen later
        });
    }
}