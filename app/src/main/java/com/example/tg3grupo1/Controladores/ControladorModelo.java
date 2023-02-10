package com.example.tg3grupo1.Controladores;

import android.content.Context;

import com.example.tg3grupo1.BBDD.ModeloAdo;
import com.example.tg3grupo1.Modelo.Modelo;

import java.util.List;

public class ControladorModelo {
    private static ControladorModelo instance;
    private ModeloAdo ado;

    private ControladorModelo(){}

    public static ControladorModelo getInstance(Context context){
        if (instance == null)
            instance = new ControladorModelo();

        instance.ado = new ModeloAdo(context);

        return instance;
    }

    public Modelo getAlumno(String id){
        return ado.getById(id);
    }

    public List<Modelo> getAlumnos(){
        return ado.getAll();
    }

    public boolean insertar(String id, String titulo, String ultimaactualizacion, String coordenadas, String telefono){
        if (titulo == null || titulo.isEmpty()){
            return false;
        }
        // resto de comprobaciones

        ado.insertarAlumno(id, titulo, ultimaactualizacion, coordenadas, telefono);
        return true;
    }
}
