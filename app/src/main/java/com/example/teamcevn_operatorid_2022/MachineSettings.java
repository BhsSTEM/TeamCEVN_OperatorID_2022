package com.example.teamcevn_operatorid_2022;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MachineSettings extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {
    BottomNavigationView nav_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.machine_settings);

        nav_bar = findViewById(R.id.bottom_navigation);
        nav_bar.setOnItemSelectedListener(this);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        CharSequence title = item.getTitle();
        if ("Profile".contentEquals(title)) {
            startActivity(new Intent(this, UserList.class));
        } else if ("Pin".contentEquals(title)) {
            startActivity(new Intent(this, MapsActivity.class));
        } else if ("Setting".contentEquals(title)) {
            startActivity(new Intent(this, MachineSettings.class));
        }
        return false;
    }
}