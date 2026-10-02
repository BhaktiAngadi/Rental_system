package com.example.rental_system;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rental_system.model.Room;

import java.util.ArrayList;
import java.util.List;

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

    // List of Room objects
    List<Room> roomList;

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


        // ------------------------------------------------
        // CREATE ROOM OBJECTS
        // ------------------------------------------------

        roomList = new ArrayList<>();

        roomList.add(new Room(
                "R001",
                "Single Room",
                "Panjim, Goa",
                8000,
                true
        ));

        roomList.add(new Room(
                "R002",
                "Shared Room",
                "Margao, Goa",
                5500,
                true
        ));

        roomList.add(new Room(
                "R003",
                "1 BHK",
                "Vasco, Goa",
                12000,
                true
        ));





        // ------------------------------------------------
        // ROOM 1
        // ------------------------------------------------

        btnDetails1.setOnClickListener(v -> {

            Room selectedRoom = roomList.get(0);

            Intent intent = new Intent(
                    BrowseRoomsActivity.this,
                    RoomDetailsActivity.class
            );

            intent.putExtra("roomId", selectedRoom.getRoomId());
            intent.putExtra("roomType", selectedRoom.getRoomType());
            intent.putExtra("location", selectedRoom.getLocation());
            intent.putExtra("rent", selectedRoom.getMonthlyRent());
            intent.putExtra("available", selectedRoom.isAvailable());

            startActivity(intent);
        });


        // ------------------------------------------------
        // ROOM 2
        // ------------------------------------------------

        btnDetails2.setOnClickListener(v -> {

            Room selectedRoom = roomList.get(1);

            Intent intent = new Intent(
                    BrowseRoomsActivity.this,
                    RoomDetailsActivity.class
            );

            intent.putExtra("roomId", selectedRoom.getRoomId());
            intent.putExtra("roomType", selectedRoom.getRoomType());
            intent.putExtra("location", selectedRoom.getLocation());
            intent.putExtra("rent", selectedRoom.getMonthlyRent());
            intent.putExtra("available", selectedRoom.isAvailable());

            startActivity(intent);
        });


        // ------------------------------------------------
        // ROOM 3
        // ------------------------------------------------

        btnDetails3.setOnClickListener(v -> {

            Room selectedRoom = roomList.get(2);

            Intent intent = new Intent(
                    BrowseRoomsActivity.this,
                    RoomDetailsActivity.class
            );

            intent.putExtra("roomId", selectedRoom.getRoomId());
            intent.putExtra("roomType", selectedRoom.getRoomType());
            intent.putExtra("location", selectedRoom.getLocation());
            intent.putExtra("rent", selectedRoom.getMonthlyRent());
            intent.putExtra("available", selectedRoom.isAvailable());

            startActivity(intent);
        });


        // ------------------------------------------------
        // FILTER
        // ------------------------------------------------

        layoutFilter.setOnClickListener(v -> {

            Toast.makeText(
                    BrowseRoomsActivity.this,
                    "Filter options will be added in Step 5",
                    Toast.LENGTH_SHORT
            ).show();

        });


        // ------------------------------------------------
        // BOTTOM NAVIGATION
        // ------------------------------------------------

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