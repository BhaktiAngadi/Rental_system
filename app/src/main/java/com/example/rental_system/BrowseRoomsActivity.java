package com.example.rental_system;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BrowseRoomsActivity extends AppCompatActivity {

    EditText etRoomSearch;

    LinearLayout layoutFilter;

    Button btnDetails1;
    Button btnDetails2;
    Button btnDetails3;

    LinearLayout navHome;
    LinearLayout navBrowse;
    LinearLayout navRequests;
    LinearLayout navProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_rooms);

        // Search
        etRoomSearch = findViewById(R.id.etRoomSearch);

        // Filter
        layoutFilter = findViewById(R.id.layoutFilter);

        // Room buttons
        btnDetails1 = findViewById(R.id.btnDetails1);
        btnDetails2 = findViewById(R.id.btnDetails2);
        btnDetails3 = findViewById(R.id.btnDetails3);

        // Bottom navigation
        navHome = findViewById(R.id.navHome);
        navBrowse = findViewById(R.id.navBrowse);
        navRequests = findViewById(R.id.navRequests);
        navProfile = findViewById(R.id.navProfile);


        // Room 1
        btnDetails1.setOnClickListener(v -> {

            Toast.makeText(
                    BrowseRoomsActivity.this,
                    "Single Room selected",
                    Toast.LENGTH_SHORT
            ).show();

        });


        // Room 2
        btnDetails2.setOnClickListener(v -> {

            Toast.makeText(
                    BrowseRoomsActivity.this,
                    "Shared Room selected",
                    Toast.LENGTH_SHORT
            ).show();

        });


        // Room 3
        btnDetails3.setOnClickListener(v -> {

            Toast.makeText(
                    BrowseRoomsActivity.this,
                    "1 BHK selected",
                    Toast.LENGTH_SHORT
            ).show();

        });


        // Filter
        layoutFilter.setOnClickListener(v -> {

            Toast.makeText(
                    BrowseRoomsActivity.this,
                    "Filter options will be added in Step 5",
                    Toast.LENGTH_SHORT
            ).show();

        });


        // Home
        navHome.setOnClickListener(v -> {

            Intent intent = new Intent(
                    BrowseRoomsActivity.this,
                    TenantHomeActivity.class
            );

            startActivity(intent);
            finish();

        });


        // Browse
        navBrowse.setOnClickListener(v -> {

            Toast.makeText(
                    BrowseRoomsActivity.this,
                    "You are already browsing rooms",
                    Toast.LENGTH_SHORT
            ).show();

        });


        // Requests
        navRequests.setOnClickListener(v -> {

            Toast.makeText(
                    BrowseRoomsActivity.this,
                    "My Requests will be added later",
                    Toast.LENGTH_SHORT
            ).show();

        });


        // Profile
        navProfile.setOnClickListener(v -> {

            Toast.makeText(
                    BrowseRoomsActivity.this,
                    "Profile will be added in Step 12",
                    Toast.LENGTH_SHORT
            ).show();

        });

    }
}