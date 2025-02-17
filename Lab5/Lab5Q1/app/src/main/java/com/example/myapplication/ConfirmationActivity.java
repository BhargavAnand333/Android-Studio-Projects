package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class ConfirmationActivity extends AppCompatActivity {
    private TextView detailsTextView;
    private Button confirmButton, editButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        // Initialize UI components
        detailsTextView = findViewById(R.id.detailsTextView);
        confirmButton = findViewById(R.id.confirmButton);
        editButton = findViewById(R.id.editButton);

        // Get data from intent
        Intent intent = getIntent();
        String vehicleType = intent.getStringExtra("vehicleType");
        String vehicleNumber = intent.getStringExtra("vehicleNumber");
        String rcNumber = intent.getStringExtra("rcNumber");

        // Display details
        String details = "Vehicle Type: " + vehicleType + "\n" +
                "Vehicle Number: " + vehicleNumber + "\n" +
                "RC Number: " + rcNumber;
        detailsTextView.setText(details);

        // Confirm Button: Show a unique serial number
        confirmButton.setOnClickListener(view -> {
            int serialNumber = new Random().nextInt(9000) + 1000; // Generate a random 4-digit number
            Toast.makeText(ConfirmationActivity.this, "Parking Confirmed! Serial No: " + serialNumber, Toast.LENGTH_LONG).show();
        });

        // Edit Button: Go back to MainActivity
        editButton.setOnClickListener(view -> {
            Intent backIntent = new Intent(ConfirmationActivity.this, MainActivity.class);
            startActivity(backIntent);
        });
    }
}

