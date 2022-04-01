package com.example.teamcevn_operatorid_2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MachineSettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.machine_settings);
    }

    public void profile(View view){
        startActivity(new Intent(this, UserList.class));
    }

    public void map(View view){
        // TODO Needs map class
//        startActivity(new Intent(this, ));
    }

    public void settings(View view){
        startActivity(new Intent(this, MachineSettings.class));
    }
}