package com.example.tg3grupo1.Vistas;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.tg3grupo1.BBDD.DownloadJson;
import com.example.tg3grupo1.Fragments.ContenidoGeneral;
import com.example.tg3grupo1.Modelo.Modelo;
import com.example.tg3grupo1.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Inicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setTheme(R.style.fondoAplicacion);
        setContentView(R.layout.activity_inicio);

        showFragment(ContenidoGeneral.newInstance(this, new ArrayList<Modelo>()));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NotNull MenuItem item) {
        if (item.getItemId() == R.id.item_home) {
            showFragment(ContenidoGeneral.newInstance(this, new ArrayList<Modelo>()));

        } else if (item.getItemId() == R.id.item_buscar) {

            DownloadJson.metercosas(this);
            DownloadJson json = new DownloadJson();

            try {
                json.execute("https://www.zaragoza.es/sede/servicio/urbanismo-infraestructuras/equipamiento/parada-taxi.json?rf=html&srsname=wgs84&start=0&rows=1000&distance=500").get();
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
        } else if (item.getItemId() == R.id.item_actualizar) {
            System.out.println("sexoanaaaaaaal");
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