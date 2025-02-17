package com.example.bhargav311;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class ConfirmationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        TextView confirmationTextView = findViewById(R.id.confirmationTextView);

        String details = "Movie: " + getIntent().getStringExtra("movie") +
                "\nTheatre: " + getIntent().getStringExtra("theatre") +
                "\nDate: " + getIntent().getStringExtra("date") +
                "\nTime: " + getIntent().getStringExtra("time") +
                "\nTicket Type: " + getIntent().getStringExtra("ticketType");

        confirmationTextView.setText(details);
    }
}
