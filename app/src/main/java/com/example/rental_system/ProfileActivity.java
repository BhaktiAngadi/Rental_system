package com.example.rental_system;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    Button btnLogout;

    LinearLayout navHome;
    LinearLayout navBrowse;
    LinearLayout navRequests;
    LinearLayout navProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_profile);

        btnLogout = findViewById(R.id.btnLogout);

        navHome = findViewById(R.id.navHome);
        navBrowse = findViewById(R.id.navBrowse);
        navRequests = findViewById(R.id.navRequests);
        navProfile = findViewById(R.id.navProfile);


        // Logout

        btnLogout.setOnClickListener(v -> {

            Intent intent = new Intent(
                    ProfileActivity.this,
                    LoginActivity.class
            );

            // Remove previous screens
            intent.setFlags(
                    Intent.FLAG_ACTIVITY_NEW_TASK |
                            Intent.FLAG_ACTIVITY_CLEAR_TASK
            );

            startActivity(intent);

            finish();
        });


        // Home

        navHome.setOnClickListener(v -> {

            Intent intent = new Intent(
                    ProfileActivity.this,
                    TenantHomeActivity.class
            );

            startActivity(intent);

            finish();
        });


        // Browse

        navBrowse.setOnClickListener(v -> {

            Intent intent = new Intent(
                    ProfileActivity.this,
                    BrowseRoomsActivity.class
            );

            startActivity(intent);

            finish();
        });


        // Requests

        navRequests.setOnClickListener(v -> {

            Intent intent = new Intent(
                    ProfileActivity.this,
                    MyRequestsActivity.class
            );

            startActivity(intent);

            finish();
        });


        // Profile

        navProfile.setOnClickListener(v -> {
            // Already on profile
        });
    }
}