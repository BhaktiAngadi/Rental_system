package com.example.rental_system;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.rental_system.model.Payment;

public class PaymentHistoryActivity extends AppCompatActivity {

    LinearLayout layoutPayments;
    TextView tvNoPayments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_history);

        layoutPayments = findViewById(R.id.layoutPayments);
        tvNoPayments = findViewById(R.id.tvNoPayments);

        // --------------------------------
        // Sample payment data
        // Later this will come from Firebase
        // --------------------------------

        Payment payment1 = new Payment(
                "PAY001",
                "TENANT001",
                8000,
                "01/10/2026",
                "Paid"
        );

        Payment payment2 = new Payment(
                "PAY002",
                "TENANT001",
                8000,
                "01/09/2026",
                "Paid"
        );

        tvNoPayments.setVisibility(TextView.GONE);

        addPaymentCard(payment1);
        addPaymentCard(payment2);
    }

    private void addPaymentCard(Payment payment) {

        // --------------------------------
        // Card
        // --------------------------------

        CardView card = new CardView(this);

        card.setRadius(20);
        card.setCardElevation(6);

        LinearLayout.LayoutParams cardParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        cardParams.setMargins(0, 10, 0, 16);

        card.setLayoutParams(cardParams);


        // --------------------------------
        // Card Content
        // --------------------------------

        LinearLayout content = new LinearLayout(this);

        content.setOrientation(LinearLayout.VERTICAL);
        content.setPadding(25, 25, 25, 25);


        // Payment ID

        TextView paymentId = new TextView(this);

        paymentId.setText(
                "Payment ID: " + payment.getPaymentId()
        );

        paymentId.setTextSize(14);


        // Amount

        TextView amount = new TextView(this);

        amount.setText(
                "₹" + payment.getAmount()
        );

        amount.setTextSize(22);
        amount.setTypeface(null, 1);


        // Date

        TextView date = new TextView(this);

        date.setText(
                "Payment Date: " + payment.getPaymentDate()
        );

        date.setTextSize(15);


        // Status

        TextView status = new TextView(this);

        status.setText(
                "Status: " + payment.getStatus()
        );

        status.setTextSize(16);
        status.setTypeface(null, 1);

        LinearLayout.LayoutParams statusParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        statusParams.setMargins(0, 12, 0, 0);

        status.setLayoutParams(statusParams);


        // --------------------------------
        // Add to Card
        // --------------------------------

        content.addView(paymentId);
        content.addView(amount);
        content.addView(date);
        content.addView(status);

        card.addView(content);

        layoutPayments.addView(card);
    }
}