package com.example.bhargav30;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private Spinner sourceSpinner, destinationSpinner;
    private EditText dateEditText;
    private Switch tripSwitch;
    private Button submitButton, resetButton;
    private String selectedSource, selectedDestination;
    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sourceSpinner = findViewById(R.id.sourceSpinner);
        destinationSpinner = findViewById(R.id.destinationSpinner);
        dateEditText = findViewById(R.id.dateEditText);
        tripSwitch = findViewById(R.id.tripSwitch);
        submitButton = findViewById(R.id.submitButton);
        resetButton = findViewById(R.id.resetButton);

        calendar = Calendar.getInstance();
        updateDateField(); // Set current date by default

        // Populate Spinners
        ArrayList<String> locations = new ArrayList<>();
        locations.add("Bangalore");
        locations.add("Chennai");
        locations.add("Mumbai");
        locations.add("Delhi");
        locations.add("Hyderabad");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, locations);
        sourceSpinner.setAdapter(adapter);
        destinationSpinner.setAdapter(adapter);

        // Get selected items
        sourceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedSource = locations.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        destinationSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedDestination = locations.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        // Date Picker Dialog
        dateEditText.setOnClickListener(view -> {
            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    MainActivity.this,
                    (view1, year, month, dayOfMonth) -> {
                        calendar.set(year, month, dayOfMonth);
                        updateDateField();
                    },
                    calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
            datePickerDialog.show();
        });

        // Submit button: Send data to confirmation screen
        submitButton.setOnClickListener(view -> {
            String travelDate = dateEditText.getText().toString();
            String tripType = tripSwitch.isChecked() ? "Round-Trip" : "One-Way";

            Intent intent = new Intent(MainActivity.this, ConfirmationActivity.class);
            intent.putExtra("source", selectedSource);
            intent.putExtra("destination", selectedDestination);
            intent.putExtra("date", travelDate);
            intent.putExtra("tripType", tripType);
            startActivity(intent);
        });

        // Reset button: Clear fields and reset date
        resetButton.setOnClickListener(view -> {
            sourceSpinner.setSelection(0);
            destinationSpinner.setSelection(0);
            calendar = Calendar.getInstance();
            updateDateField();
            tripSwitch.setChecked(false);
        });
    }

    private void updateDateField() {
        dateEditText.setText(calendar.get(Calendar.DAY_OF_MONTH) + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.YEAR));
    }
}
