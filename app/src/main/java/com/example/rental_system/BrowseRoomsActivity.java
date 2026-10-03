package com.example.rental_system;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BrowseRoomsActivity extends AppCompatActivity {

    EditText etRoomSearch;

    LinearLayout layoutFilter;

    LinearLayout roomCard1;
    LinearLayout roomCard2;
    LinearLayout roomCard3;

    Button btnDetails1;
    Button btnDetails2;
    Button btnDetails3;

    LinearLayout navHome;
    LinearLayout navBrowse;
    LinearLayout navRequests;
    LinearLayout navProfile;


    // Current filter values
    String selectedRoomType = "All";
    String selectedLocation = "All";
    double maxRent = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_browse_rooms);


        // Search
        etRoomSearch = findViewById(R.id.etRoomSearch);


        // Filter
        layoutFilter = findViewById(R.id.layoutFilter);


        // Room cards
        roomCard1 = findViewById(R.id.roomCard1);
        roomCard2 = findViewById(R.id.roomCard2);
        roomCard3 = findViewById(R.id.roomCard3);


        // Buttons
        btnDetails1 = findViewById(R.id.btnDetails1);
        btnDetails2 = findViewById(R.id.btnDetails2);
        btnDetails3 = findViewById(R.id.btnDetails3);


        // Bottom navigation
        navHome = findViewById(R.id.navHome);
        navBrowse = findViewById(R.id.navBrowse);
        navRequests = findViewById(R.id.navRequests);
        navProfile = findViewById(R.id.navProfile);


        // -----------------------------------------
        // ROOM DETAILS
        // -----------------------------------------

        btnDetails1.setOnClickListener(v -> {

            openRoomDetails(
                    "R001",
                    "Single Room",
                    "Panjim, Goa",
                    8000,
                    true
            );

        });


        btnDetails2.setOnClickListener(v -> {

            openRoomDetails(
                    "R002",
                    "Shared Room",
                    "Margao, Goa",
                    5500,
                    true
            );

        });


        btnDetails3.setOnClickListener(v -> {

            openRoomDetails(
                    "R003",
                    "1 BHK",
                    "Vasco, Goa",
                    12000,
                    true
            );

        });


        // -----------------------------------------
        // SEARCH
        // -----------------------------------------

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

                applySearchAndFilter();

            }


            @Override
            public void afterTextChanged(Editable s) {
            }

        });


        // -----------------------------------------
        // FILTER BUTTON
        // -----------------------------------------

        layoutFilter.setOnClickListener(v -> showFilterDialog());


        // -----------------------------------------
        // HOME
        // -----------------------------------------

        navHome.setOnClickListener(v -> {

            Intent intent = new Intent(
                    BrowseRoomsActivity.this,
                    TenantHomeActivity.class
            );

            startActivity(intent);
            finish();

        });


        // -----------------------------------------
        // BROWSE
        // -----------------------------------------

        navBrowse.setOnClickListener(v -> {

            Toast.makeText(
                    BrowseRoomsActivity.this,
                    "You are already browsing rooms",
                    Toast.LENGTH_SHORT
            ).show();

        });


        // -----------------------------------------
        // REQUESTS
        // -----------------------------------------

        navRequests.setOnClickListener(v -> {

            Intent intent = new Intent(
                    BrowseRoomsActivity.this,
                    MyRequestsActivity.class
            );

            startActivity(intent);

        });


        // -----------------------------------------
        // PROFILE
        // -----------------------------------------

        navProfile.setOnClickListener(v -> {

            Toast.makeText(
                    BrowseRoomsActivity.this,
                    "Profile will be added in Step 12",
                    Toast.LENGTH_SHORT
            ).show();

        });

    }


    // =================================================
    // ROOM DETAILS
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
    // FILTER DIALOG
    // =================================================

    private void showFilterDialog() {

        View view = getLayoutInflater().inflate(
                R.layout.dialog_room_filter,
                null
        );


        Spinner spinnerRoomType =
                view.findViewById(R.id.spinnerRoomType);

        Spinner spinnerLocation =
                view.findViewById(R.id.spinnerLocation);

        EditText etMaxRent =
                view.findViewById(R.id.etMaxRent);

        Button btnClearFilter =
                view.findViewById(R.id.btnClearFilter);

        Button btnApplyFilter =
                view.findViewById(R.id.btnApplyFilter);


        // Room type options
        String[] roomTypes = {
                "All",
                "Single Room",
                "Shared Room",
                "1 BHK"
        };


        ArrayAdapter<String> roomTypeAdapter =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_spinner_dropdown_item,
                        roomTypes
                );

        spinnerRoomType.setAdapter(roomTypeAdapter);


        // Location options
        String[] locations = {
                "All",
                "Panjim",
                "Margao",
                "Vasco"
        };


        ArrayAdapter<String> locationAdapter =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_spinner_dropdown_item,
                        locations
                );

        spinnerLocation.setAdapter(locationAdapter);


        // -----------------------------------------
        // DIALOG
        // -----------------------------------------

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setView(view)
                .create();


        // -----------------------------------------
        // APPLY
        // -----------------------------------------

        btnApplyFilter.setOnClickListener(v -> {

            selectedRoomType =
                    spinnerRoomType.getSelectedItem().toString();

            selectedLocation =
                    spinnerLocation.getSelectedItem().toString();


            String rentText =
                    etMaxRent.getText().toString().trim();


            if (rentText.isEmpty()) {

                maxRent = 0;

            } else {

                maxRent = Double.parseDouble(rentText);

            }


            applySearchAndFilter();

            dialog.dismiss();

        });


        // -----------------------------------------
        // CLEAR
        // -----------------------------------------

        btnClearFilter.setOnClickListener(v -> {

            selectedRoomType = "All";
            selectedLocation = "All";
            maxRent = 0;

            etRoomSearch.setText("");

            applySearchAndFilter();

            dialog.dismiss();

        });


        dialog.show();

    }


    // =================================================
    // SEARCH + FILTER
    // =================================================

    private void applySearchAndFilter() {

        String searchText =
                etRoomSearch.getText()
                        .toString()
                        .toLowerCase()
                        .trim();


        // -----------------------------------------
        // ROOM 1
        // -----------------------------------------

        boolean room1Search =
                "single room".contains(searchText)
                        || "panjim".contains(searchText)
                        || "goa".contains(searchText);


        boolean room1Type =
                selectedRoomType.equals("All")
                        || selectedRoomType.equals("Single Room");


        boolean room1Location =
                selectedLocation.equals("All")
                        || selectedLocation.equals("Panjim");


        boolean room1Rent =
                maxRent == 0 || 8000 <= maxRent;


        boolean showRoom1 =
                room1Search
                        && room1Type
                        && room1Location
                        && room1Rent;


        // -----------------------------------------
        // ROOM 2
        // -----------------------------------------

        boolean room2Search =
                "shared room".contains(searchText)
                        || "margao".contains(searchText)
                        || "goa".contains(searchText);


        boolean room2Type =
                selectedRoomType.equals("All")
                        || selectedRoomType.equals("Shared Room");


        boolean room2Location =
                selectedLocation.equals("All")
                        || selectedLocation.equals("Margao");


        boolean room2Rent =
                maxRent == 0 || 5500 <= maxRent;


        boolean showRoom2 =
                room2Search
                        && room2Type
                        && room2Location
                        && room2Rent;


        // -----------------------------------------
        // ROOM 3
        // -----------------------------------------

        boolean room3Search =
                "1 bhk".contains(searchText)
                        || "vasco".contains(searchText)
                        || "goa".contains(searchText);


        boolean room3Type =
                selectedRoomType.equals("All")
                        || selectedRoomType.equals("1 BHK");


        boolean room3Location =
                selectedLocation.equals("All")
                        || selectedLocation.equals("Vasco");


        boolean room3Rent =
                maxRent == 0 || 12000 <= maxRent;


        boolean showRoom3 =
                room3Search
                        && room3Type
                        && room3Location
                        && room3Rent;


        // -----------------------------------------
        // SHOW / HIDE CARDS
        // -----------------------------------------

        roomCard1.setVisibility(
                showRoom1 ? View.VISIBLE : View.GONE
        );

        roomCard2.setVisibility(
                showRoom2 ? View.VISIBLE : View.GONE
        );

        roomCard3.setVisibility(
                showRoom3 ? View.VISIBLE : View.GONE
        );

    }

}