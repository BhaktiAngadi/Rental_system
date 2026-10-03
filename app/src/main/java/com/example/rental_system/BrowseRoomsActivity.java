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

    Button btnDetails1;
    Button btnDetails2;
    Button btnDetails3;

    LinearLayout roomCard1;
    LinearLayout roomCard2;
    LinearLayout roomCard3;

    LinearLayout navHome;
    LinearLayout navBrowse;
    LinearLayout navRequests;
    LinearLayout navProfile;

    // Room information
    String[] roomTypes = {
            "Single Room",
            "Shared Room",
            "1 BHK"
    };

    String[] locations = {
            "Panjim",
            "Margao",
            "Vasco"
    };

    double[] rents = {
            8000,
            5500,
            12000
    };

    // Current filter values
    String selectedRoomType = "All";
    String selectedLocation = "All";
    double maxRent = 0;

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
        // ROOM BUTTONS
        // --------------------------------

        btnDetails1 = findViewById(R.id.btnDetails1);
        btnDetails2 = findViewById(R.id.btnDetails2);
        btnDetails3 = findViewById(R.id.btnDetails3);

        roomCard1 = findViewById(R.id.roomCard1);
        roomCard2 = findViewById(R.id.roomCard2);
        roomCard3 = findViewById(R.id.roomCard3);

        // --------------------------------
        // BOTTOM NAVIGATION
        // --------------------------------

        navHome = findViewById(R.id.navHome);
        navBrowse = findViewById(R.id.navBrowse);
        navRequests = findViewById(R.id.navRequests);
        navProfile = findViewById(R.id.navProfile);

        // --------------------------------
        // SEARCH
        // --------------------------------

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

        // --------------------------------
        // ROOM 1
        // --------------------------------

        btnDetails1.setOnClickListener(v -> {

            openRoomDetails(
                    "R001",
                    "Single Room",
                    "Panjim",
                    8000,
                    true
            );

        });

        // --------------------------------
        // ROOM 2
        // --------------------------------

        btnDetails2.setOnClickListener(v -> {

            openRoomDetails(
                    "R002",
                    "Shared Room",
                    "Margao",
                    5500,
                    true
            );

        });

        // --------------------------------
        // ROOM 3
        // --------------------------------

        btnDetails3.setOnClickListener(v -> {

            openRoomDetails(
                    "R003",
                    "1 BHK",
                    "Vasco",
                    12000,
                    true
            );

        });

        // --------------------------------
        // FILTER BUTTON
        // --------------------------------

        layoutFilter.setOnClickListener(v -> {

            showFilterDialog();

        });

        // --------------------------------
        // HOME
        // --------------------------------

        navHome.setOnClickListener(v -> {

            Intent intent = new Intent(
                    BrowseRoomsActivity.this,
                    TenantHomeActivity.class
            );

            startActivity(intent);
            finish();

        });

        // --------------------------------
        // BROWSE
        // --------------------------------

        navBrowse.setOnClickListener(v -> {

            Toast.makeText(
                    BrowseRoomsActivity.this,
                    "You are already browsing rooms",
                    Toast.LENGTH_SHORT
            ).show();

        });

        // --------------------------------
        // REQUESTS
        // --------------------------------

        navRequests.setOnClickListener(v -> {

            Intent intent = new Intent(
                    BrowseRoomsActivity.this,
                    MyRequestsActivity.class
            );

            startActivity(intent);

        });

        // --------------------------------
        // PROFILE
        // --------------------------------

        // PROFILE
        navProfile.setOnClickListener(v -> {

            Intent intent = new Intent(
                    BrowseRoomsActivity.this,
                    ProfileActivity.class
            );

            startActivity(intent);
            finish();
        });
    }


    // =====================================================
    // FILTER DIALOG
    // =====================================================

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


        // --------------------------------
        // ROOM TYPE SPINNER
        // --------------------------------

        String[] roomTypeOptions = {
                "All",
                "Single Room",
                "Shared Room",
                "1 BHK"
        };

        ArrayAdapter<String> roomTypeAdapter =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_spinner_item,
                        roomTypeOptions
                );

        roomTypeAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spinnerRoomType.setAdapter(roomTypeAdapter);


        // --------------------------------
        // LOCATION SPINNER
        // --------------------------------

        String[] locationOptions = {
                "All",
                "Panjim",
                "Margao",
                "Vasco"
        };

        ArrayAdapter<String> locationAdapter =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_spinner_item,
                        locationOptions
                );

        locationAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spinnerLocation.setAdapter(locationAdapter);


        // --------------------------------
        // REMEMBER PREVIOUS FILTER
        // --------------------------------

        for (int i = 0; i < roomTypeOptions.length; i++) {

            if (roomTypeOptions[i].equals(selectedRoomType)) {

                spinnerRoomType.setSelection(i);
                break;
            }
        }


        for (int i = 0; i < locationOptions.length; i++) {

            if (locationOptions[i].equals(selectedLocation)) {

                spinnerLocation.setSelection(i);
                break;
            }
        }


        if (maxRent > 0) {

            etMaxRent.setText(
                    String.valueOf((int) maxRent)
            );
        }


        // --------------------------------
        // CREATE DIALOG
        // --------------------------------

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setView(view)
                .create();


        // --------------------------------
        // CLEAR FILTER
        // --------------------------------

        btnClearFilter.setOnClickListener(v -> {

            selectedRoomType = "All";
            selectedLocation = "All";
            maxRent = 0;

            etRoomSearch.setText("");

            applySearchAndFilter();

            dialog.dismiss();

            Toast.makeText(
                    BrowseRoomsActivity.this,
                    "Filters cleared",
                    Toast.LENGTH_SHORT
            ).show();

        });


        // --------------------------------
        // APPLY FILTER
        // --------------------------------

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

                maxRent =
                        Double.parseDouble(rentText);
            }


            applySearchAndFilter();

            dialog.dismiss();

            Toast.makeText(
                    BrowseRoomsActivity.this,
                    "Filter applied",
                    Toast.LENGTH_SHORT
            ).show();

        });


        dialog.show();
    }


    // =====================================================
    // SEARCH + FILTER
    // =====================================================

    private void applySearchAndFilter() {

        String searchText =
                etRoomSearch.getText()
                        .toString()
                        .toLowerCase()
                        .trim();


        // ROOM 1
        boolean room1Matches =
                matchesRoom(
                        roomTypes[0],
                        locations[0],
                        rents[0],
                        searchText
                );

        roomCard1.setVisibility(
                room1Matches
                        ? View.VISIBLE
                        : View.GONE
        );


        // ROOM 2
        boolean room2Matches =
                matchesRoom(
                        roomTypes[1],
                        locations[1],
                        rents[1],
                        searchText
                );

        roomCard2.setVisibility(
                room2Matches
                        ? View.VISIBLE
                        : View.GONE
        );


        // ROOM 3
        boolean room3Matches =
                matchesRoom(
                        roomTypes[2],
                        locations[2],
                        rents[2],
                        searchText
                );

        roomCard3.setVisibility(
                room3Matches
                        ? View.VISIBLE
                        : View.GONE
        );
    }


    // =====================================================
    // CHECK ROOM
    // =====================================================

    private boolean matchesRoom(
            String roomType,
            String location,
            double rent,
            String searchText) {


        // --------------------------------
        // SEARCH CHECK
        // --------------------------------

        boolean matchesSearch =
                searchText.isEmpty()
                        || roomType.toLowerCase().contains(searchText)
                        || location.toLowerCase().contains(searchText);


        if (!matchesSearch) {

            return false;
        }


        // --------------------------------
        // ROOM TYPE FILTER
        // --------------------------------

        boolean matchesRoomType =
                selectedRoomType.equals("All")
                        || roomType.equals(selectedRoomType);


        if (!matchesRoomType) {

            return false;
        }


        // --------------------------------
        // LOCATION FILTER
        // --------------------------------

        boolean matchesLocation =
                selectedLocation.equals("All")
                        || location.equals(selectedLocation);


        if (!matchesLocation) {

            return false;
        }


        // --------------------------------
        // MAX RENT FILTER
        // --------------------------------

        boolean matchesRent =
                maxRent == 0
                        || rent <= maxRent;


        return matchesRent;
    }


    // =====================================================
    // OPEN ROOM DETAILS
    // =====================================================

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
}