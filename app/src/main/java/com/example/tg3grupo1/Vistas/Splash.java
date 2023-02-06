package com.example.tg3grupo1.Vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.example.tg3grupo1.R;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler(Looper.myLooper());
        handler.postDelayed(()->{

            Intent intent = new Intent(getApplicationContext(), Inicio.class);
            startActivity(intent);
            finish();
        },5000);
    }
}