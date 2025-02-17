package com.example.bhargav6;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View; //*
import android.widget.ListView; //*
import android.widget.Toast; //*
import android.widget.AdapterView; //*
import android.widget.ArrayAdapter; //*

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        String[] sports = {"Football", "Cricket", "Basketball", "Tennis", "Rugby", "Hockey", "Badminton"};
        ListView listView = findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sports);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedSport = sports[position];
                Toast.makeText(MainActivity.this, "Selected sport: " + selectedSport, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
