package com.example.tg3grupo1.BBDD;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import com.example.tg3grupo1.Fragments.ContenidoGeneral;
import com.example.tg3grupo1.Modelo.Modelo;
import com.example.tg3grupo1.R;
import com.example.tg3grupo1.Vistas.Inicio;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DownloadJson extends AsyncTask<String, Void, String> {
    private static Context CONTEXT;
    private static String result = "";
    public static Bitmap iconoImagen;
    public static ArrayList<Modelo> modelos = new ArrayList<>();

    public static void metercosas(Context context) {
        CONTEXT = context;
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
        //aqui lo que hacemos es llamar el metodo para meter dentro de iconoImagen el
        //bitmap para utilizarlo luego en la inserción de datos

        //downloadImage(modelos.get(0).getIcono());

        //aqui lo que hacemos es meter los datos dentro de la base de datos, para luego hacer
        //las consultas correspondiente a esta

//        ModeloHelper modeloHelper = new ModeloHelper(CONTEXT);
//        modeloHelper.getWritableDatabase();

        ModeloAdo modeloAdo = new ModeloAdo(CONTEXT);
        modeloAdo.insertar(modelos);
    }


    public void downloadImage(String imageUrl) {
        Bitmap bitmap = null;
        try {
            URL url = new URL(imageUrl);
            bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        iconoImagen = bitmap;
    }

    @Override
    protected void onPostExecute(String bitmap) {
    }

}
