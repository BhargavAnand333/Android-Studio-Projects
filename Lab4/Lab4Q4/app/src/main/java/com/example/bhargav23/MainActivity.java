package com.example.bhargav23;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private HashMap<CheckBox, Integer> foodItems;
    private Button submitButton;
    private boolean isOrderPlaced = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize food items with prices
        foodItems = new HashMap<>();
        foodItems.put(findViewById(R.id.pizza), 150);
        foodItems.put(findViewById(R.id.burger), 100);
        foodItems.put(findViewById(R.id.pasta), 120);
        foodItems.put(findViewById(R.id.icecream), 80);

        submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(v -> {
            if (isOrderPlaced) {
                Toast.makeText(MainActivity.this, "Order already placed!", Toast.LENGTH_SHORT).show();
                return;
            }

            ArrayList<String> selectedItems = new ArrayList<>();
            int totalCost = 0;

            for (CheckBox checkBox : foodItems.keySet()) {
                if (checkBox.isChecked()) {
                    selectedItems.add(checkBox.getText().toString() + " - ₹" + foodItems.get(checkBox));
                    totalCost += foodItems.get(checkBox);
                    checkBox.setEnabled(false);  // Disable checkbox after submission
                }
            }

            if (selectedItems.isEmpty()) {
                Toast.makeText(MainActivity.this, "Please select at least one item!", Toast.LENGTH_SHORT).show();
                return;
            }

            isOrderPlaced = true;
            submitButton.setEnabled(false); // Disable button

            Intent intent = new Intent(MainActivity.this, OrderSummaryActivity.class);
            intent.putStringArrayListExtra("orderList", selectedItems);
            intent.putExtra("totalCost", totalCost);
            startActivity(intent);
        });
    }
}