package com.example.tg3grupo1.BBDD;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;

import com.example.tg3grupo1.Modelo.Modelo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DowloadJson extends AsyncTask<String, Void, String> {
    private static Context CONTEXT;
    private static String result = "";
    public static ArrayList<Modelo> modelos = new ArrayList<>();

    public static void metercosas(Context contexto, View view) {

    }

    @Override
    protected String doInBackground(String... urls) {
        result = "";
        URL url;
        HttpURLConnection urlConnection = null;
        try {
            url = new URL(urls[0]);
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = urlConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);
            int data = reader.read();
            while (data != -1) {
                char current = (char) data;
                result += current;
                data = reader.read();
            }
            cargarModelo();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
    }

    public void cargarModelo() {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(result, JsonObject.class);
        JsonElement idElement = jsonObject.get("result");
        JsonArray lista = idElement.getAsJsonArray();
        List<JsonObject> objeto = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            objeto.add((JsonObject) lista.get(i));
        }
        List<JsonObject> geome = new ArrayList<>();
        for (int i = 0; i < objeto.size(); i++) {
            geome.add((JsonObject) objeto.get(i).get("geometry"));
            //geome.get(i).get("coordinates");

            modelos.add(new Modelo(objeto.get(i).get("id").toString(),
                    objeto.get(i).get("title").toString(),
                    objeto.get(i).get("lastUpdated").toString(),
                    geome.get(i).get("coordinates").toString(),
                    objeto.get(i).get("icon").toString()
            ));
        }
//        ModeloHelper modeloHelper = new ModeloHelper(this);
//        modeloHelper.getWritableDatabase();
//        ModeloAdo modeloAdo = new ModeloAdo(this);
//        modeloAdo.rellenarAlumnos(flkjflkj, modelos);

    }
}
