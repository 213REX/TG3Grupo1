package com.example.tg3grupo1.BBDD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tg3grupo1.Modelo.Modelo;

import java.util.ArrayList;
import java.util.List;

public class ModeloAdo implements AutoCloseable {

    private Context context;
    private ModeloHelper helper;
    private SQLiteDatabase db;

    public ModeloAdo(Context context) {
        helper = new ModeloHelper(context);
        db = helper.getReadableDatabase();
    }

    public void insertar(ArrayList<Modelo> parada) {
        for (int i = 0 ; i< parada.size(); i++) {
            ContentValues valores = new ContentValues();
            valores.put("id", parada.get(i).getId());
            valores.put("titulo", parada.get(i).getTitulo());
            valores.put("ultimaactualizacion", parada.get(i).getUltimaactualizacion());
            valores.put("coordenadas", parada.get(i).getCoordenadas());
            valores.put("icono", parada.get(i).getIcono());
            helper.getWritableDatabase().insert("registros", null, valores);

//            String sql = "INSERT INTO registros (id, titulo, Ultimaactuaalizacion, coordenadas, icono) VALUES (?, ?, ?, ?, ?);";
//            helper.getWritableDatabase().execSQL(sql, new Object[]{parada.get(i).getId(), parada.get(i).getTitulo(),
//                    parada.get(i).getUltimaactualizacion(), parada.get(i).getCoordenadas(), parada.get(i).getIcono()});
        }
    }

    public void buscar(String dato){
        Modelo parada = new Modelo();
        ContentValues valores = new ContentValues();
        valores.put("id", parada.getId());
        valores.put("titulo", parada.getTitulo());
        valores.put("ultimaactualizacion", parada.getUltimaactualizacion());
        valores.put("coordenadas", parada.getCoordenadas());
        valores.put("icono", parada.getIcono());
        helper.getWritableDatabase().insert("Taxis", null, valores);

        String sql = "SELECT * FROM registros WHERE id LIKE '%"+dato+"%' OR titulo LIKE '%"+dato+"%' " +
                "OR ultimaactualizacion LIKE '%"+dato+"%' OR coordenadas LIKE '%"+dato+"%' " +
                "OR icono LIKE '%"+dato+"%';";
        helper.getWritableDatabase().execSQL(sql, new Object[]{parada.getId(), parada.getTitulo(),
                parada.getUltimaactualizacion(), parada.getCoordenadas(), parada.getIcono()});
    }

    @Override
    public void close() throws Exception {
        db.close();
    }
}
