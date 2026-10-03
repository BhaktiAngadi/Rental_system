package com.example.rental_system;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.rental_system.model.Complaint;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ComplaintActivity extends AppCompatActivity {

    EditText etComplaintTitle;
    EditText etComplaintRoomId;
    EditText etComplaintDescription;

    Button btnSubmitComplaint;

    LinearLayout layoutComplaints;
    TextView tvNoComplaints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_complaint);

        // Find views

        etComplaintTitle =
                findViewById(R.id.etComplaintTitle);

        etComplaintRoomId =
                findViewById(R.id.etComplaintRoomId);

        etComplaintDescription =
                findViewById(R.id.etComplaintDescription);

        btnSubmitComplaint =
                findViewById(R.id.btnSubmitComplaint);

        layoutComplaints =
                findViewById(R.id.layoutComplaints);

        tvNoComplaints =
                findViewById(R.id.tvNoComplaints);


        // Submit complaint

        btnSubmitComplaint.setOnClickListener(v -> {

            String title =
                    etComplaintTitle.getText()
                            .toString()
                            .trim();

            String roomId =
                    etComplaintRoomId.getText()
                            .toString()
                            .trim();

            String description =
                    etComplaintDescription.getText()
                            .toString()
                            .trim();


            // Validation

            if (title.isEmpty()) {

                etComplaintTitle.setError(
                        "Enter complaint title"
                );

                return;
            }

            if (roomId.isEmpty()) {

                etComplaintRoomId.setError(
                        "Enter room ID"
                );

                return;
            }

            if (description.isEmpty()) {

                etComplaintDescription.setError(
                        "Enter complaint description"
                );

                return;
            }


            // Current date

            String date =
                    new SimpleDateFormat(
                            "dd/MM/yyyy",
                            Locale.getDefault()
                    ).format(new Date());


            // Create Complaint object

            Complaint complaint =
                    new Complaint(
                            "CMP001",
                            "TENANT001",
                            roomId,
                            title,
                            description,
                            date,
                            "Pending"
                    );


            // Display complaint

            addComplaintCard(complaint);


            // Clear fields

            etComplaintTitle.setText("");
            etComplaintRoomId.setText("");
            etComplaintDescription.setText("");


            Toast.makeText(
                    ComplaintActivity.this,
                    "Complaint submitted successfully",
                    Toast.LENGTH_SHORT
            ).show();

        });
    }


    // Add complaint card

    private void addComplaintCard(Complaint complaint) {

        tvNoComplaints.setVisibility(TextView.GONE);


        // Card

        CardView card =
                new CardView(this);

        card.setRadius(20);
        card.setCardElevation(6);


        LinearLayout.LayoutParams cardParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        cardParams.setMargins(0, 8, 0, 16);

        card.setLayoutParams(cardParams);


        // Card content

        LinearLayout content =
                new LinearLayout(this);

        content.setOrientation(
                LinearLayout.VERTICAL
        );

        content.setPadding(
                25,
                25,
                25,
                25
        );


        // Title

        TextView title =
                new TextView(this);

        title.setText(
                complaint.getTitle()
        );

        title.setTextSize(19);
        title.setTypeface(null, 1);


        // Room

        TextView room =
                new TextView(this);

        room.setText(
                "Room ID: "
                        + complaint.getRoomId()
        );

        room.setTextSize(14);


        // Description

        TextView description =
                new TextView(this);

        description.setText(
                complaint.getDescription()
        );

        description.setTextSize(15);

        description.setTextColor(
                0xFF666666
        );


        // Date

        TextView date =
                new TextView(this);

        date.setText(
                "Date: "
                        + complaint.getDate()
        );

        date.setTextSize(14);


        // Status

        TextView status =
                new TextView(this);

        status.setText(
                "Status: "
                        + complaint.getStatus()
        );

        status.setTextSize(16);
        status.setTypeface(null, 1);
        status.setGravity(Gravity.CENTER);


        LinearLayout.LayoutParams statusParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        statusParams.setMargins(
                0,
                12,
                0,
                0
        );

        status.setLayoutParams(statusParams);


        // Add views

        content.addView(title);
        content.addView(room);
        content.addView(description);
        content.addView(date);
        content.addView(status);

        card.addView(content);

        layoutComplaints.addView(card);
    }
}