package com.example.bhargav23;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class OrderSummaryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);

        TextView orderSummary = findViewById(R.id.orderSummary);
        TextView totalCostView = findViewById(R.id.totalCost);

        ArrayList<String> orderList = getIntent().getStringArrayListExtra("orderList");
        int totalCost = getIntent().getIntExtra("totalCost", 0);

        if (orderList != null) {
            StringBuilder orderDetails = new StringBuilder();
            for (String item : orderList) {
                orderDetails.append(item).append("\n");
            }
            orderSummary.setText(orderDetails.toString());
        }

        totalCostView.setText("Total Cost: ₹" + totalCost);
    }
}

