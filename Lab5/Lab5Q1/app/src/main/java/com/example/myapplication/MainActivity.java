package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Spinner vehicleTypeSpinner;
    private EditText vehicleNumber, rcNumber;
    private Button submitButton;
    private String selectedVehicleType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        vehicleTypeSpinner = findViewById(R.id.vehicleTypeSpinner);
        vehicleNumber = findViewById(R.id.vehicleNumber);
        rcNumber = findViewById(R.id.rcNumber);
        submitButton = findViewById(R.id.submitButton);

        // Populate Spinner
        ArrayList<String> vehicleTypes = new ArrayList<>();
        vehicleTypes.add("Car");
        vehicleTypes.add("Bike");
        vehicleTypes.add("Truck");
        vehicleTypes.add("Bus");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, vehicleTypes);
        vehicleTypeSpinner.setAdapter(adapter);

        // Get selected vehicle type
        vehicleTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedVehicleType = vehicleTypes.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        // Handle submit button click
        submitButton.setOnClickListener(view -> {
            String vNumber = vehicleNumber.getText().toString();
            String rcNum = rcNumber.getText().toString();

            // Open confirmation screen
            Intent intent = new Intent(MainActivity.this, ConfirmationActivity.class);
            intent.putExtra("vehicleType", selectedVehicleType);
            intent.putExtra("vehicleNumber", vNumber);
            intent.putExtra("rcNumber", rcNum);
            startActivity(intent);
        });
    }
}
