package com.example.bhargav11;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnOreo = findViewById(R.id.button_oreo);
        Button btnPie = findViewById(R.id.button_pie);
        Button btnQ = findViewById(R.id.button_q);

        btnOreo.setOnClickListener(v -> showToast("Android Oreo", android.R.drawable.ic_dialog_info));
        btnPie.setOnClickListener(v -> showToast("Android Pie", android.R.drawable.ic_dialog_alert));
        btnQ.setOnClickListener(v -> showToast("Android Q", android.R.drawable.ic_menu_info_details));
    }

    private void showToast(String message, int iconResId) {
        LinearLayout layout = new LinearLayout(getApplicationContext());
        layout.setOrientation(LinearLayout.HORIZONTAL);

        ImageView imageView = new ImageView(getApplicationContext());
        imageView.setImageResource(iconResId);
        layout.addView(imageView);

        TextView textView = new TextView(getApplicationContext());
        textView.setText(message);
        layout.addView(textView);

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);
        toast.show();
    }
}
