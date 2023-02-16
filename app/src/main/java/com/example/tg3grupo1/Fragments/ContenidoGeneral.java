package com.example.tg3grupo1.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tg3grupo1.Adapters.SerieAdapter;
import com.example.tg3grupo1.BBDD.DownloadJson;
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
    public static View view;
    private static Context context;
    private static RecyclerView recyclerGeneral;
    private static ArrayList<Modelo> contenidRecycler;
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
    public static ContenidoGeneral newInstance(Context cont, ArrayList<Modelo> modelos) {
//        if (instance == null) {
        instance = new ContenidoGeneral();
        context = cont;
        contenidRecycler = modelos;
//        }
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

        recyclerGeneral = view.findViewById(R.id.recyclerGeneral);
        recyclerGeneral.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerGeneral.setLayoutManager(layoutManager);

        if (contenidRecycler.size() == 0) {
            contenidRecycler = DownloadJson.modelos;
            recyclerGeneral.setAdapter(new SerieAdapter(new ArrayList<Modelo>(), this));
            recyclerGeneral.setAdapter(new SerieAdapter(contenidRecycler, this));
        }else if (contenidRecycler.size() ==1 && contenidRecycler.get(0).getTitulo().equals("1")){
            recyclerGeneral.setAdapter(new SerieAdapter(new ArrayList<Modelo>(), this));
        }else{
            recyclerGeneral.setAdapter(new SerieAdapter(new ArrayList<Modelo>(), this));
            recyclerGeneral.setAdapter(new SerieAdapter(contenidRecycler, this));
        }

        return view;
    }

    @Override
    public void onNoteClic(int posicion) {
        //no funciona
        //Inicio inicio = new Inicio();
        //inicio.showFragment(Descripcion.newInstance(context, contenidRecycler, posicion));
//        getFragmentManager().beginTransaction().replace(R.id.contenedor,
//                des).commit();

        requireFragmentManager().beginTransaction()
                .replace(R.id.contenedor, Descripcion.newInstance(context, contenidRecycler, posicion))
                .commit();

    }

    @Override
    public void onStop() {
        super.onStop();
        instance = null;
    }

    @Override

    public void onPause() {
        super.onPause();
        super.onStop();
    }
}