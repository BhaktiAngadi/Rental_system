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
    LinearLayout layoutCurrentRental;
    LinearLayout layoutRecentPayment;
    LinearLayout layoutComplaints;

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

        // Current Rental
        layoutCurrentRental = findViewById(R.id.layoutCurrentRental);

        // View Available Rooms
        tvViewRooms = findViewById(R.id.tvViewRooms);

        // Bottom Navigation
        navHome = findViewById(R.id.navHome);
        navBrowse = findViewById(R.id.navBrowse);
        navRequests = findViewById(R.id.navRequests);
        navProfile = findViewById(R.id.navProfile);

        // Recent Payment
        layoutRecentPayment = findViewById(R.id.layoutRecentPayment);

        //complaints
        layoutComplaints = findViewById(R.id.layoutComplaints);


        // --------------------------------
        // Browse Rooms
        // --------------------------------

        layoutBrowseRooms.setOnClickListener(v -> {

            Intent intent = new Intent(
                    TenantHomeActivity.this,
                    BrowseRoomsActivity.class
            );

            startActivity(intent);
        });


        // --------------------------------
        // My Requests
        // --------------------------------

        layoutMyRequests.setOnClickListener(v -> {

            Intent intent = new Intent(
                    TenantHomeActivity.this,
                    MyRequestsActivity.class
            );

            startActivity(intent);
        });


        // --------------------------------
        // Current Rental
        // --------------------------------

        layoutCurrentRental.setOnClickListener(v -> {

            Intent intent = new Intent(
                    TenantHomeActivity.this,
                    ActiveRentalActivity.class
            );

            startActivity(intent);
        });


        // --------------------------------
        // View Available Rooms
        // --------------------------------

        tvViewRooms.setOnClickListener(v -> {

            Intent intent = new Intent(
                    TenantHomeActivity.this,
                    BrowseRoomsActivity.class
            );

            startActivity(intent);
        });


        // --------------------------------
        // Bottom Navigation - Home
        // --------------------------------

        navHome.setOnClickListener(v -> {

            Toast.makeText(
                    TenantHomeActivity.this,
                    "Home",
                    Toast.LENGTH_SHORT
            ).show();
        });


        // --------------------------------
        // Bottom Navigation - Browse
        // --------------------------------

        navBrowse.setOnClickListener(v -> {

            Intent intent = new Intent(
                    TenantHomeActivity.this,
                    BrowseRoomsActivity.class
            );

            startActivity(intent);
        });


        // --------------------------------
        // Bottom Navigation - Requests
        // --------------------------------

        navRequests.setOnClickListener(v -> {

            Intent intent = new Intent(
                    TenantHomeActivity.this,
                    MyRequestsActivity.class
            );

            startActivity(intent);
        });


        // --------------------------------
        // Bottom Navigation - Profile
        // --------------------------------

        navProfile.setOnClickListener(v -> {

            Toast.makeText(
                    TenantHomeActivity.this,
                    "Profile will be added in Step 12",
                    Toast.LENGTH_SHORT
            ).show();
        });


        // ----------------------------
        // Recent Payment
        // ----------------------------
        layoutRecentPayment.setOnClickListener(v -> {

            Intent intent = new Intent(
                    TenantHomeActivity.this,
                    PaymentHistoryActivity.class
            );

            startActivity(intent);
        });

        // ----------------------------
        // complaints
        // ----------------------------
        layoutComplaints.setOnClickListener(v -> {

            Intent intent = new Intent(
                    TenantHomeActivity.this,
                    ComplaintActivity.class
            );

            startActivity(intent);
        });
    }
}