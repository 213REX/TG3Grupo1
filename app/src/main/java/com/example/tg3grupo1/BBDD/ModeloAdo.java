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
        helper.onCreate(db);
        for (int i = 0 ; i< parada.size(); i++) {
            ContentValues valores = new ContentValues();
            valores.put("id", parada.get(i).getId().replace("\"","" ));
            valores.put("titulo", parada.get(i).getTitulo().replace("\"","" ));
            valores.put("ultimaactualizacion", parada.get(i).getUltimaactualizacion().replace("\"","" ));
            valores.put("coordenadas", parada.get(i).getCoordenadas().replace("\"","" ));
            valores.put("icono", parada.get(i).getIcono().replace("\"","" ));
            helper.getWritableDatabase().insert("registros", null, valores);
        }
    }

    public List<Modelo> buscar(String dato){
        List<Modelo> parada = new ArrayList<>();
        String sql = "SELECT * FROM registros WHERE id LIKE '%"+dato+"%' OR titulo LIKE '%"+dato+"%' " +
                "OR ultimaactualizacion LIKE '%"+dato+"%' OR coordenadas LIKE '%"+dato+"%';";
        Cursor cursor = db.rawQuery(sql, null);

        while (cursor.moveToNext()){
            Modelo para = new Modelo();
            para.setId(cursor.getString(0));
            para.setTitulo(cursor.getString(1));
            para.setUltimaactualizacion(cursor.getString(2));
            para.setCoordenadas(cursor.getString(3));
            para.setIcono(cursor.getString(4));
            parada.add(para);
        }

        return parada;
    }



    @Override
    public void close() throws Exception {
        db.close();
    }
}
