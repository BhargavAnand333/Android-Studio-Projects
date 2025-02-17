package com.example.bhargav4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button; //*
import android.widget.EditText; //*
import android.view.View; //*
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText urlInput = findViewById(R.id.urlInput);
        Button openUrlButton = findViewById(R.id.openUrlButton);

        openUrlButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String url = urlInput.getText().toString().trim();

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);

            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}