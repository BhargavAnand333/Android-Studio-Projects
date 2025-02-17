package com.example.bhargav311;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.util.*;

public class MainActivity extends AppCompatActivity {
    private Spinner movieSpinner, theatreSpinner;
    private EditText dateEditText, timeEditText;
    private Switch ticketTypeSwitch;
    private Button bookNowButton, resetButton;
    private Calendar selectedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieSpinner = findViewById(R.id.movieSpinner);
        theatreSpinner = findViewById(R.id.theatreSpinner);
        dateEditText = findViewById(R.id.dateEditText);
        timeEditText = findViewById(R.id.timeEditText);
        ticketTypeSwitch = findViewById(R.id.ticketTypeSwitch);
        bookNowButton = findViewById(R.id.bookNowButton);
        resetButton = findViewById(R.id.resetButton);
        selectedTime = Calendar.getInstance();

        // Populate spinners
        String[] movies = {"Avengers: Endgame", "Inception", "Interstellar"};
        String[] theatres = {"PVR Cinemas", "INOX", "Cinepolis"};

        ArrayAdapter<String> movieAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, movies);
        movieSpinner.setAdapter(movieAdapter);

        ArrayAdapter<String> theatreAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, theatres);
        theatreSpinner.setAdapter(theatreAdapter);

        // Date Picker
        dateEditText.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            new DatePickerDialog(this, (view, year, month, dayOfMonth) -> {
                dateEditText.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
            }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
        });

        // Time Picker
        timeEditText.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            new TimePickerDialog(this, (view, hourOfDay, minute) -> {
                selectedTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
                selectedTime.set(Calendar.MINUTE, minute);
                timeEditText.setText(hourOfDay + ":" + String.format("%02d", minute));
                validatePremiumTicket();
            }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true).show();
        });

        // Ticket Type Switch
        ticketTypeSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            ticketTypeSwitch.setText(isChecked ? "Premium Ticket" : "Standard Ticket");
            validatePremiumTicket();
        });

        // Book Now Button
        bookNowButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ConfirmationActivity.class);
            intent.putExtra("movie", movieSpinner.getSelectedItem().toString());
            intent.putExtra("theatre", theatreSpinner.getSelectedItem().toString());
            intent.putExtra("date", dateEditText.getText().toString());
            intent.putExtra("time", timeEditText.getText().toString());
            intent.putExtra("ticketType", ticketTypeSwitch.getText().toString());
            startActivity(intent);
        });

        // Reset Button
        resetButton.setOnClickListener(v -> {
            dateEditText.setText("");
            timeEditText.setText("");
            ticketTypeSwitch.setChecked(false);
            bookNowButton.setEnabled(false);
        });
    }

    private void validatePremiumTicket() {
        if (ticketTypeSwitch.isChecked()) {
            int hour = selectedTime.get(Calendar.HOUR_OF_DAY);
            bookNowButton.setEnabled(hour >= 12);
        } else {
            bookNowButton.setEnabled(true);
        }
    }
}
