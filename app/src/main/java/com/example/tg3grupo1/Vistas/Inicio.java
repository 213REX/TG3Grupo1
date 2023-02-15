package com.example.tg3grupo1.Vistas;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.tg3grupo1.BBDD.DownloadJson;
import com.example.tg3grupo1.BBDD.ModeloAdo;
import com.example.tg3grupo1.Fragments.ContenidoGeneral;
import com.example.tg3grupo1.Modelo.Modelo;
import com.example.tg3grupo1.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
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

            ModeloAdo modeloAdo = new ModeloAdo(this);
            final List<Modelo>[] contenido = new ArrayList[]{new ArrayList<>()};

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.alert_dialog_busquedas, null);
            ImageButton imageButton = view.findViewById(R.id.btnBuscar);
            EditText campobuscar = view.findViewById(R.id.campoBuscar);
            builder.setView(view);
            AlertDialog dialogBusquedas = builder.create();
            final ArrayList<Modelo>[] contenidoBusqueda = new ArrayList[]{new ArrayList<Modelo>()};
            imageButton.setOnClickListener(v -> {
                if (campobuscar.getText().toString().isEmpty()) {
                    campobuscar.setError("No puede quedar vacio");
                } else {
                    contenido[0] = modeloAdo.buscar(campobuscar.getText().toString());
                    contenidoBusqueda[0] = (ArrayList<Modelo>) contenido[0];
                    if (contenidoBusqueda[0].size() != 0) {
                        showFragment(ContenidoGeneral.newInstance(this, contenidoBusqueda[0]));
                    }
                }
            });
            dialogBusquedas.show();
        } else if (item.getItemId() == R.id.item_actualizar) {

            DownloadJson.metercosas(this);
            DownloadJson json = new DownloadJson();

            try {
                json.execute("https://www.zaragoza.es/sede/servicio/urbanismo-infraestructuras/equipamiento/parada-taxi.json?rf=html&srsname=wgs84&start=0&rows=1000&distance=500").get();
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
            showFragment(ContenidoGeneral.newInstance(this, new ArrayList<Modelo>()));
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