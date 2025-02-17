package com.example.practice;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Spinner movieSpinner, theatreSpinner;
    private EditText editTextDate, editTextTime;
    private Switch switchTicketType;
    private Button resetButton, bookNowButton;
    private Calendar selectedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        movieSpinner = findViewById(R.id.movieSpinner);
        theatreSpinner = findViewById(R.id.theatreSpinner);
        editTextDate = findViewById(R.id.editTextDate);
        editTextTime = findViewById(R.id.editTextTime);
        switchTicketType = findViewById(R.id.switchTicketType);
        resetButton = findViewById(R.id.resetButton);
        bookNowButton = findViewById(R.id.bookNowButton);
        selectedTime = Calendar.getInstance();

        String[] movies = {"Movie1", "Movie2", "Movie3", "Movie4"};
        String[] theatres = {"Th1", "Th2", "Th3", "Th4"};

        ArrayAdapter<String> movieAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, movies);
        movieSpinner.setAdapter(movieAdapter);

        ArrayAdapter<String> theatreAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, theatres);
        theatreSpinner.setAdapter(theatreAdapter);

        editTextDate.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            new DatePickerDialog(this, (view, year, month, dayOfMonth) -> {
                editTextDate.setText(dayOfMonth + '/' + (month+1) + '/' + year );
            }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH) ).show();

        });

        editTextTime.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            new TimePickerDialog(this, (view, hourOfDay, minute) -> {
                editTextTime.setText(hourOfDay + ':' + String.format("%02d", minute));
            }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), true).show();
        });

        switchTicketType.setOnCheckedChangeListener((buttonView, isChecked) -> {
            switchTicketType.setText(isChecked ? "Premium" : "Standard");
        });

        bookNowButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ConfirmationActivity.class);
            intent.putExtra("movie", movieSpinner.getSelectedItem().toString());
            intent.putExtra("theatre", theatreSpinner.getSelectedItem().toString());
            intent.putExtra("date", editTextDate.getText().toString());
            intent.putExtra("time", editTextTime.getText().toString());
            intent.putExtra("ticketType", switchTicketType.getText().toString());
            startActivity(intent);
        });

        resetButton.setOnClickListener(v -> {
            editTextTime.setText("");
            editTextDate.setText("");
            switchTicketType.setChecked(false);
            bookNowButton.setEnabled(false);
        });

    }
}