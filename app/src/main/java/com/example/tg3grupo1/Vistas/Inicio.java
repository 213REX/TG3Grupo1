package com.example.tg3grupo1.Vistas;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.HorizontalScrollView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.tg3grupo1.BBDD.DowloadJson;
import com.example.tg3grupo1.BBDD.ModeloAdo;
import com.example.tg3grupo1.BBDD.ModeloHelper;
import com.example.tg3grupo1.Fragments.ContenidoGeneral;
import com.example.tg3grupo1.Modelo.Modelo;
import com.example.tg3grupo1.R;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setTheme(R.style.fondoAplicacion);
        setContentView(R.layout.activity_inicio);

        showFragment(ContenidoGeneral.newInstance(this));

//        DowloadJson.metercosas(this, );
        DowloadJson json = new DowloadJson();

        try {
            json.execute("https://www.zaragoza.es/sede/servicio/urbanismo-infraestructuras/equipamiento/parada-taxi.json?rf=html&srsname=wgs84&start=0&rows=1000&distance=500").get();
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
//        cargarodelo();
    }

//    private void cargarodelo() {
//        Gson gson = new Gson();
//        JsonObject jsonObject = gson.fromJson(contenido, JsonObject.class);
//        JsonElement idElement = jsonObject.get("result");
//        JsonArray lista = idElement.getAsJsonArray();
//        List<JsonObject> objeto = new ArrayList<>();
//        for (int i = 0; i < lista.size(); i++) {
//            objeto.add((JsonObject) lista.get(i));
//        }
//        List<JsonObject> geome = new ArrayList<>();
//        List<Modelo> modelos = new ArrayList<>();
//        for (int i = 0; i < objeto.size(); i++) {
//            geome.add((JsonObject) objeto.get(i).get("geometry"));
//            //geome.get(i).get("coordinates");
//
//            modelos.add(new Modelo(objeto.get(i).get("id").toString(), objeto.get(i).get("title").toString(), objeto.get(i).get("lastUpdated").toString(), geome.get(i).get("coordinates").toString(), objeto.get(i).get("icon").toString()));
//        }
////        ModeloHelper modeloHelper = new ModeloHelper(this);
////        modeloHelper.getWritableDatabase();
////        ModeloAdo modeloAdo = new ModeloAdo(this);
////        modeloAdo.rellenarAlumnos(flkjflkj, modelos);
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        if (item.getItemId() == R.id.item_home) {

        } else if (item.getItemId() == R.id.item_buscar) {

        } else if (item.getItemId() == R.id.item_actualizar) {

        }
        return super.onOptionsItemSelected(item);
    }

    public void showFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contenedor, fragment)
                .commit();
    }
}