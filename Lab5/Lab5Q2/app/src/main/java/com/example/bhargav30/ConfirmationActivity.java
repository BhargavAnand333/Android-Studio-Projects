package com.example.bhargav30;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ConfirmationActivity extends AppCompatActivity {
    private TextView detailsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        detailsTextView = findViewById(R.id.detailsTextView);

        Intent intent = getIntent();
        String source = intent.getStringExtra("source");
        String destination = intent.getStringExtra("destination");
        String date = intent.getStringExtra("date");
        String tripType = intent.getStringExtra("tripType");

        String details = "Source: " + source + "\n" +
                "Destination: " + destination + "\n" +
                "Date: " + date + "\n" +
                "Trip Type: " + tripType;

        detailsTextView.setText(details);
    }
}
