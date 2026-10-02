package com.example.rental_system;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BrowseRoomsActivity extends AppCompatActivity {

    EditText etRoomSearch;

    LinearLayout layoutFilter;

    // Complete room cards
    LinearLayout roomCard1;
    LinearLayout roomCard2;
    LinearLayout roomCard3;

    // Details buttons
    Button btnDetails1;
    Button btnDetails2;
    Button btnDetails3;

    // Bottom navigation
    LinearLayout navHome;
    LinearLayout navBrowse;
    LinearLayout navRequests;
    LinearLayout navProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_browse_rooms);


        // --------------------------------
        // SEARCH
        // --------------------------------

        etRoomSearch = findViewById(R.id.etRoomSearch);


        // --------------------------------
        // FILTER
        // --------------------------------

        layoutFilter = findViewById(R.id.layoutFilter);


        // --------------------------------
        // ROOM CARDS
        // --------------------------------

        roomCard1 = findViewById(R.id.roomCard1);
        roomCard2 = findViewById(R.id.roomCard2);
        roomCard3 = findViewById(R.id.roomCard3);


        // --------------------------------
        // DETAILS BUTTONS
        // --------------------------------

        btnDetails1 = findViewById(R.id.btnDetails1);
        btnDetails2 = findViewById(R.id.btnDetails2);
        btnDetails3 = findViewById(R.id.btnDetails3);


        // --------------------------------
        // BOTTOM NAVIGATION
        // --------------------------------

        navHome = findViewById(R.id.navHome);
        navBrowse = findViewById(R.id.navBrowse);
        navRequests = findViewById(R.id.navRequests);
        navProfile = findViewById(R.id.navProfile);


        // =================================
        // ROOM 1
        // =================================

        btnDetails1.setOnClickListener(v -> {

            openRoomDetails(
                    "R001",
                    "Single Room",
                    "Panjim, Goa",
                    8000,
                    true
            );

        });


        // =================================
        // ROOM 2
        // =================================

        btnDetails2.setOnClickListener(v -> {

            openRoomDetails(
                    "R002",
                    "Shared Room",
                    "Margao, Goa",
                    5500,
                    true
            );

        });


        // =================================
        // ROOM 3
        // =================================

        btnDetails3.setOnClickListener(v -> {

            openRoomDetails(
                    "R003",
                    "1 BHK",
                    "Vasco, Goa",
                    12000,
                    true
            );

        });


        // =================================
        // SEARCH
        // =================================

        etRoomSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(
                    CharSequence s,
                    int start,
                    int count,
                    int after) {

            }


            @Override
            public void onTextChanged(
                    CharSequence s,
                    int start,
                    int before,
                    int count) {

                searchRooms(s.toString());

            }


            @Override
            public void afterTextChanged(Editable s) {

            }

        });


        // =================================
        // FILTER
        // =================================

        layoutFilter.setOnClickListener(v -> {

            Toast.makeText(
                    BrowseRoomsActivity.this,
                    "Filter options will be added next",
                    Toast.LENGTH_SHORT
            ).show();

        });


        // =================================
        // HOME
        // =================================

        navHome.setOnClickListener(v -> {

            Intent intent = new Intent(
                    BrowseRoomsActivity.this,
                    TenantHomeActivity.class
            );

            startActivity(intent);

            finish();

        });


        // =================================
        // BROWSE
        // =================================

        navBrowse.setOnClickListener(v -> {

            Toast.makeText(
                    BrowseRoomsActivity.this,
                    "You are already browsing rooms",
                    Toast.LENGTH_SHORT
            ).show();

        });


        // =================================
        // REQUESTS
        // =================================

        navRequests.setOnClickListener(v -> {

            Intent intent = new Intent(
                    BrowseRoomsActivity.this,
                    MyRequestsActivity.class
            );

            startActivity(intent);

        });


        // =================================
        // PROFILE
        // =================================

        navProfile.setOnClickListener(v -> {

            Toast.makeText(
                    BrowseRoomsActivity.this,
                    "Profile will be added in Step 12",
                    Toast.LENGTH_SHORT
            ).show();

        });

    }


    // =================================================
    // OPEN ROOM DETAILS
    // =================================================

    private void openRoomDetails(
            String roomId,
            String roomType,
            String location,
            double rent,
            boolean available) {

        Intent intent = new Intent(
                BrowseRoomsActivity.this,
                RoomDetailsActivity.class
        );

        intent.putExtra("roomId", roomId);
        intent.putExtra("roomType", roomType);
        intent.putExtra("location", location);
        intent.putExtra("rent", rent);
        intent.putExtra("available", available);

        startActivity(intent);

    }


    // =================================================
    // SEARCH ROOMS
    // =================================================

    private void searchRooms(String searchText) {

        searchText = searchText
                .toLowerCase()
                .trim();


        // -----------------------------------------
        // ROOM 1
        // -----------------------------------------

        boolean room1Matches =
                "single room".contains(searchText)
                        || "panjim".contains(searchText)
                        || "goa".contains(searchText);


        // -----------------------------------------
        // ROOM 2
        // -----------------------------------------

        boolean room2Matches =
                "shared room".contains(searchText)
                        || "margao".contains(searchText)
                        || "goa".contains(searchText);


        // -----------------------------------------
        // ROOM 3
        // -----------------------------------------

        boolean room3Matches =
                "1 bhk".contains(searchText)
                        || "vasco".contains(searchText)
                        || "goa".contains(searchText);


        // -----------------------------------------
        // SHOW / HIDE COMPLETE CARDS
        // -----------------------------------------

        if (room1Matches) {

            roomCard1.setVisibility(View.VISIBLE);

        } else {

            roomCard1.setVisibility(View.GONE);

        }


        if (room2Matches) {

            roomCard2.setVisibility(View.VISIBLE);

        } else {

            roomCard2.setVisibility(View.GONE);

        }


        if (room3Matches) {

            roomCard3.setVisibility(View.VISIBLE);

        } else {

            roomCard3.setVisibility(View.GONE);

        }

    }

}