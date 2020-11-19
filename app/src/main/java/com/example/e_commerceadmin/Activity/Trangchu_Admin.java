package com.example.e_commerceadmin.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import com.example.e_commerceadmin.R;

public class Trangchu_Admin extends AppCompatActivity {


//    DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.e_commerceadmin.R.layout.activity_trangchu__admin);
    }

//    public void clickMenu(View view){
//        openDrawer(drawerLayout);
//    }
//
//    private static void openDrawer(DrawerLayout drawerLayout){
//        drawerLayout.openDrawer(GravityCompat.START);
//    }
}