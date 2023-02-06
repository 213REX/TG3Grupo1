package com.example.tg3grupo1.Vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tg3grupo1.R;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.fondoInicio);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }
}