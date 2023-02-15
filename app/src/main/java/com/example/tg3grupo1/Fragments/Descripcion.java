package com.example.tg3grupo1.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.tg3grupo1.Modelo.Modelo;
import com.example.tg3grupo1.R;
import com.example.tg3grupo1.Vistas.AlertDialogs;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Descripcion#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Descripcion extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    private static Descripcion instance;
    private static View view;
    private static Context context;
    private static int pos;
    private static ArrayList<Modelo> contenido;

    private TextView id;
    private TextView ultimaModificacion;
    private TextView coordenadas;
    private TextView titulo;
    private ImageButton btnIzq;
    private ImageButton btnDer;
    // TODO: Rename and change types of parameters

    public Descripcion() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Descripcion.
     */
    // TODO: Rename and change types and number of parameters
    public static Descripcion newInstance(Context cont, ArrayList<Modelo> model, int posicion) {
        if (instance == null) {
            instance = new Descripcion();
            context = cont;
            contenido = model;
            pos = posicion;
        }
        return instance;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_descripcion, container, false);
        id = view.findViewById(R.id.id);
        ultimaModificacion = view.findViewById(R.id.ultimaModificacion);
        coordenadas = view.findViewById(R.id.coordenadas);
        titulo = view.findViewById(R.id.titulo);
        btnIzq = view.findViewById(R.id.btnIzq);
        btnDer = view.findViewById(R.id.btnDer);
        cargarContenido();
        btnDer.setOnClickListener(v -> {
            if (pos == contenido.size()-1) {
                AlertDialogs.AlertError(context, "No quedan registros");
            } else {
                pos++;
                cargarContenido();
            }
        });
        btnIzq.setOnClickListener(v->{
            if (pos == 0) {
                AlertDialogs.AlertError(context, "No quedan registros");
            } else {
                pos--;
                cargarContenido();
            }
        });
        return view;
    }

    private void cargarContenido() {
        id.setText(contenido.get(pos).getId().replace("\"","" ));
        coordenadas.setText(contenido.get(pos).getCoordenadas().replace("\"","" ));
        titulo.setText(contenido.get(pos).getTitulo().replace("\"","" ));
        ultimaModificacion.setText(contenido.get(pos).getUltimaactualizacion().replace("\"","" ));
    }

    @Override
    public void onStop() {
        super.onStop();
        instance = null;
    }
}