package com.example.teamcevn_operatorid_2022;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class UserList extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {
    BottomNavigationView nav_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_list);

        nav_bar = findViewById(R.id.bottom_navigation);
        nav_bar.setOnItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        CharSequence title = item.getTitle();
        Log.i("Item Title: ", (String) item.getTitle());
        if ("Profile".contentEquals(title)) {
            startActivity(new Intent(this, UserList.class));
            nav_bar.setSelectedItemId(item.getItemId());
        } else if ("Pin".contentEquals(title)) {
            startActivity(new Intent(this, MapsActivity.class));
        } else if ("Setting".contentEquals(title)) {
            startActivity(new Intent(this, MachineSettings.class));
        }
        return false;
    }
}