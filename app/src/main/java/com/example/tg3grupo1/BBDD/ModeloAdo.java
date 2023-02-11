package com.example.tg3grupo1.BBDD;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tg3grupo1.Modelo.Modelo;

import java.util.ArrayList;
import java.util.List;

public class ModeloAdo {
    private Context context;
    private static final String ID = "id";

    public ModeloAdo(Context context){
        this.context = context;
    }

    public List<Modelo> getAll(){
        List<Modelo> alumnos = new ArrayList<>();
        String sql = "SELECT * FROM alumnos";

        try (SQLiteDatabase db = Util.abrirBD(context, Util.DBNAME)){
            Cursor cursor = db.rawQuery(sql, null);

            rellenarAlumnos(cursor, alumnos);
        }

        return alumnos;
    }

    private void rellenarAlumnos(Cursor cursor, List<Modelo> alumnos) {
        while (cursor.moveToNext()){
            Modelo alumno = new Modelo();
            alumno.setId(cursor.getString(0));
            alumno.setTitulo(cursor.getString(1));
            alumno.setUltimaactualizacion(cursor.getString(2));
            alumno.setCoordenadas(cursor.getString(3));
            alumno.setIcono(cursor.getString(4));
            alumnos.add(alumno);

        }
    }

    public Modelo getById(String id){
        String sql = "SELECT * FROM alumnos WHERE id = ?";

        try (SQLiteDatabase db = Util.abrirBD(context, Util.DBNAME)){
            Cursor cursor = db.rawQuery(sql, new String[]{String.valueOf(id)});

            if (cursor.moveToNext()){
                Modelo parada = new Modelo();
                parada.setId(id);
                parada.setTitulo(cursor.getString(1));
                parada.setUltimaactualizacion(cursor.getString(2));
                parada.setCoordenadas(cursor.getString(3));
                parada.setIcono(cursor.getString(4));
                return parada;
            }
            else
                return null;
        }
    }

    public List<Modelo> getByEmailServer(String server){
        List<Modelo> alumnos = new ArrayList<>();
        String sql = "SELECT * FROM alumnos WHERE email LIKE '%@" + server + "'";

        try (SQLiteDatabase db = Util.abrirBD(context, Util.DBNAME)){
            Cursor cursor = db.rawQuery(sql, null);

            rellenarAlumnos(cursor, alumnos);
        }

        return alumnos;
    }

    public Modelo insertarAlumno(String id, String titulo, String ultmimaactualizacion, String coordenadas, String icono){
        try (SQLiteDatabase db = Util.abrirBD(context, Util.DBNAME)) {
            ContentValues cv = new ContentValues();
            cv.put(ID, id);
            cv.put("titulo", titulo);
            cv.put("utlimaactualizacion", ultmimaactualizacion);
            cv.put("coordenadas", coordenadas);
            cv.put("icono", icono);


            Modelo parada = new Modelo();
            parada.setId(id);
            parada.setTitulo(titulo);
            parada.setUltimaactualizacion(ultmimaactualizacion);
            parada.setCoordenadas(coordenadas);
            parada.setIcono(icono);

            return parada;
        }
    }

    public void actualizarAlumno(Modelo parada){
        try (SQLiteDatabase db = Util.abrirBD(context, Util.DBNAME)){
            ContentValues cv = new ContentValues();
            cv.put(ID, parada.getTitulo());
            cv.put("ultimaactualizacion", parada.getUltimaactualizacion());
            cv.put("coordenadas", parada.getCoordenadas());
            cv.put("icono", parada.getIcono());
            db.update("alumnos", cv, "id = ?", new String[]{String.valueOf(parada.getId())});
        }
    }

    public void borrarAlumno(Modelo parada){
        try (SQLiteDatabase db = Util.abrirBD(context, Util.DBNAME)){
            db.delete("alumnos", "id = ?", new String[] {String.valueOf(parada.getId())});
        }
    }

    public List<Modelo> update(){
        List<Modelo> parada = new ArrayList<>();
        String sql = "UPDATE alumnos SET alumnos = ?";

        try (SQLiteDatabase db = Util.abrirBD(context, Util.DBNAME)){
            Cursor cursor = db.rawQuery(sql, null);

            rellenarAlumnos(cursor, parada);
        }

        return parada;
    }

    public List<Modelo> createTable(){
        List<Modelo> alumnos = new ArrayList<>();
        String sql = "CREATE TABLE databasename(String parada)";

        try (SQLiteDatabase db = Util.abrirBD(context, Util.DBNAME)){
            Cursor cursor = db.rawQuery(sql, null);

            rellenarAlumnos(cursor, alumnos);
        }

        return alumnos;
    }

    public List<Modelo> busccar(){
        List<Modelo> alumnos = new ArrayList<>();
        String sql = "SELECT * FROM nombre_tabla WHERE id LIKE '%CAMPO_BUSCAR%' OR titulo LIKE '%CAMPO_BUSCAR%'" +
                "OR ultimaactualizacion LIKE '%CAMPO_BUSCAR%' OR coordenadas LIKE '%CAMPO_BUSCAR%' OR " +
                "icono LIKE '%CAMPO_BUSCAR%'";

        try (SQLiteDatabase db = Util.abrirBD(context, Util.DBNAME)){
            Cursor cursor = db.rawQuery(sql, null);

            rellenarAlumnos(cursor, alumnos);
        }

        return alumnos;
    }
}
