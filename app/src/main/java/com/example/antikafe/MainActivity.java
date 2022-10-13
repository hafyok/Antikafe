package com.example.antikafe;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.antikafe.DI.ServiceLocator;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ServiceLocator.init(getApplicationContext());

    }



}