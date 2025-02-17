package com.example.myapplication;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set Toolbar as ActionBar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.workout_plans) {
            Toast.makeText(this, "Workout Plans Selected", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.trainers) {
            Toast.makeText(this, "Trainers Selected", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.membership) {
            Toast.makeText(this, "Membership Selected", Toast.LENGTH_SHORT).show();
        } else {
            return super.onOptionsItemSelected(item);
        }

        return true;
    }
}
