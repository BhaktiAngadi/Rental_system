package com.example.rental_system;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActiveRentalActivity extends AppCompatActivity {

    LinearLayout navHome;
    LinearLayout navBrowse;
    LinearLayout navRequests;
    LinearLayout navProfile;

    TextView tvNoRental;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_active_rental);

        tvNoRental = findViewById(R.id.tvNoRental);

        navHome = findViewById(R.id.navHome);
        navBrowse = findViewById(R.id.navBrowse);
        navRequests = findViewById(R.id.navRequests);
        navProfile = findViewById(R.id.navProfile);


        // For now, there is no active rental.
        // Later Firebase will provide the accepted rental.
        tvNoRental.setText(
                "You don't have an active rental yet.\n\n" +
                        "Once your rental request is accepted, " +
                        "your rented room will appear here."
        );


        // Home
        navHome.setOnClickListener(v -> {

            Intent intent = new Intent(
                    ActiveRentalActivity.this,
                    TenantHomeActivity.class
            );

            startActivity(intent);
            finish();
        });


        // Browse
        navBrowse.setOnClickListener(v -> {

            Intent intent = new Intent(
                    ActiveRentalActivity.this,
                    BrowseRoomsActivity.class
            );

            startActivity(intent);
            finish();
        });


        // Requests
        navRequests.setOnClickListener(v -> {

            Intent intent = new Intent(
                    ActiveRentalActivity.this,
                    MyRequestsActivity.class
            );

            startActivity(intent);
            finish();
        });


        // Profile
        navProfile.setOnClickListener(v -> {

            // Profile will be implemented in Step 12

        });
    }
}