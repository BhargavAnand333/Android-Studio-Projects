package com.example.bhargav10;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        ToggleButton toggleButton = findViewById(R.id.toggleButton);

        button.setOnClickListener(v -> showToast("Button Clicked!", R.drawable.pic1));
        toggleButton.setOnClickListener(v -> showToast("ToggleButton Clicked!", R.drawable.pic2));
    }

    private void showToast(String message, int imageResource) {
        // Create a new LinearLayout programmatically
        LinearLayout layout = new LinearLayout(getApplicationContext());
        layout.setOrientation(LinearLayout.HORIZONTAL);

        // Create ImageView
        ImageView imageView = new ImageView(getApplicationContext());
        imageView.setImageResource(imageResource);
        layout.addView(imageView);

        // Create TextView
        TextView textView = new TextView(getApplicationContext());
        textView.setText(message);
        layout.addView(textView);

        // Create Toast
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }

}