package com.example.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText num1 = findViewById(R.id.num1);
        EditText num2 = findViewById(R.id.num2);
        Spinner operator = findViewById(R.id.operator);
        Button calculate = findViewById(R.id.calculate);

        // Populate Spinner manually (No strings.xml needed)
        String[] operators = {"+", "-", "×", "÷"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, operators);
        operator.setAdapter(adapter);

        calculate.setOnClickListener(v -> {
            String number1 = num1.getText().toString().trim();
            String number2 = num2.getText().toString().trim();

            if (number1.isEmpty() || number2.isEmpty()) {
                Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                double n1 = Double.parseDouble(number1);
                double n2 = Double.parseDouble(number2);
                String op = operator.getSelectedItem().toString();
                double result = 0;

                switch (op) {
                    case "+": result = n1 + n2; break;
                    case "-": result = n1 - n2; break;
                    case "×": result = n1 * n2; break;
                    case "÷":
                        if (n2 == 0) {
                            Toast.makeText(this, "Cannot divide by zero!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        result = n1 / n2;
                        break;
                }

                String resultString = n1 + " " + op + " " + n2 + " = " + result;

                // Pass result to ResultActivity
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("result", resultString);
                startActivity(intent);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Invalid number format", Toast.LENGTH_SHORT).show();
                Log.e("CalculatorError", "Error parsing input: " + e.getMessage());
            }
        });
    }
}
