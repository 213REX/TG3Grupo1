package com.example.tg3grupo1.Vistas;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tg3grupo1.BBDD.DowloadJson;
import com.example.tg3grupo1.Modelo.Modelo;
import com.example.tg3grupo1.R;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Inicio extends AppCompatActivity {
    private static String contenido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.fondoAplicacion);
        setContentView(R.layout.activity_inicio);

        DowloadJson json = new DowloadJson();
        try {
            contenido = json.execute("https://www.zaragoza.es/sede/servicio/urbanismo-infraestructuras/equipamiento/parada-taxi.json?rf=html&srsname=wgs84&start=0&rows=1000&distance=500").get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        cargarodelo();
    }

    private static void cargarodelo() {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(contenido, JsonObject.class);
        JsonElement idElement = jsonObject.get("result");
        JsonArray lista = idElement.getAsJsonArray();
        List<JsonObject> objeto = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            objeto.add((JsonObject) lista.get(i));
        }
        List<JsonObject>geome = new ArrayList<>();
        List<Modelo>modelos = new ArrayList<>();
        for (int i = 0;i<objeto.size(); i++){
            geome.add((JsonObject) objeto.get(i).get("geometry"));
            geome.get(i).get("coordinates");
            modelos.add(new Modelo(
                    objeto.get(i).get("id").toString(),
                    objeto.get(i).get("title").toString(),
                    objeto.get(i).get("lastUpdated").toString(),
                    geome.get(i).get("coordinates").toString(),
                    objeto.get(i).get("icon").toString()
            ));
        }
        System.out.println("");
    }
}