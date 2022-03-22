package com.example.teamcevn_operatorid_2022;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
        Intent intent = new Intent(this, Ethan.class);
        startActivity(intent);
        
        // setContentView(R.layout.ethan_main);
      
        //Intent intent = new Intent(this, Login.class);
        //startActivity(intent);
        
        //Intent user_list = new Intent(this, UserList.class);
        //startActivity(user_list);
    }
} 