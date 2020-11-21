package com.example.e_commerceadmin.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.e_commerceadmin.R;

public class Login_Admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__admin);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }
}