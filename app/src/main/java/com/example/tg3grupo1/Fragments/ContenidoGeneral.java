package com.example.tg3grupo1.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.example.tg3grupo1.Adapters.SerieAdapter;
import com.example.tg3grupo1.BBDD.DowloadJson;
import com.example.tg3grupo1.Modelo.Modelo;
import com.example.tg3grupo1.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ContenidoGeneral#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContenidoGeneral extends Fragment implements SerieAdapter.OnNoteListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static ContenidoGeneral instance;
    private static View view;
    private static Context context;
    // TODO: Rename and change types of parameters

    public ContenidoGeneral() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ContenidoGeneral.
     */
    // TODO: Rename and change types and number of parameters
    public static ContenidoGeneral newInstance(Context cont) {
        if (instance == null){
            instance = new ContenidoGeneral();
            context = cont;
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
        view = inflater.inflate(R.layout.fragment_contenido_general, container, false);
        ArrayList<Modelo> f = DowloadJson.modelos;
        return view;
    }

    @Override
    public void onNoteClic(int posicion){
        getFragmentManager().beginTransaction().replace(R.id.contenedor,
                Descripcion.newInstance(context)).commit();
    }
}