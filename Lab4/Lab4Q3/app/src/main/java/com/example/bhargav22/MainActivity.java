package com.example.bhargav22;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toggleButton;
    private ImageView imageView;
    private Button changeModeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton = findViewById(R.id.toggleButton);
        imageView = findViewById(R.id.imageView);
        changeModeButton = findViewById(R.id.changeModeButton);

        toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> updateUI(isChecked));

        changeModeButton.setOnClickListener(v -> {
            boolean newState = !toggleButton.isChecked();
            toggleButton.setChecked(newState);
            updateUI(newState);
        });

        updateUI(toggleButton.isChecked()); // Ensure correct state on launch
    }

    private void updateUI(boolean isWifi) {
        imageView.setImageResource(isWifi ? R.drawable.pic1 : R.drawable.pic2);
        String mode = isWifi ? "Wi-Fi" : "Mobile Data";
        Toast.makeText(this, "Current Mode: " + mode, Toast.LENGTH_SHORT).show();

    }
}
