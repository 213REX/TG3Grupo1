package com.example.tg3grupo1.Vistas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.example.tg3grupo1.BBDD.DownloadJson;
import com.example.tg3grupo1.R;

import java.util.concurrent.ExecutionException;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.fondoInicio);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        DownloadJson.metercosas(this);
        DownloadJson json = new DownloadJson();

        try {
            json.execute("https://www.zaragoza.es/sede/servicio/urbanismo-infraestructuras/equipamiento/parada-taxi.json?rf=html&srsname=wgs84&start=0&rows=1000&distance=500%22").get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        //el siguiente codigo permite que el splash cambie directamente
        //a la main activity tras 5 segundos
        Handler handler = new Handler(Looper.myLooper());
        handler.postDelayed(()->{

            Intent intent = new Intent(getApplicationContext(), Inicio.class);
            startActivity(intent);
            finish();
        },5000);
    }
}