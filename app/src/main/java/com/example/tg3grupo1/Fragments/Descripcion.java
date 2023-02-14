package com.example.tg3grupo1.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tg3grupo1.Modelo.Modelo;
import com.example.tg3grupo1.R;

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
        return view;
    }
}