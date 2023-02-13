package com.example.tg3grupo1.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tg3grupo1.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Descripcion#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Descripcion extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    private static  Descripcion instance;
    private static View view;
    private static Context context;
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
    public static Descripcion newInstance(Context cont) {
        if (instance == null){
            instance = new Descripcion();
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
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_descripcion, container, false);
        return view;
    }
}