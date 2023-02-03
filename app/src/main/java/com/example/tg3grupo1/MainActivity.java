package com.example.tg3grupo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.fondoInicio);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}