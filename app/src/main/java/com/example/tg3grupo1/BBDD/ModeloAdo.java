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
    private static final String NOMBRE = "nombre";

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
                Modelo alumno = new Modelo();
                alumno.setId(id);
                alumno.setTitulo(cursor.getString(1));
                alumno.setUltimaactualizacion(cursor.getString(2));
                alumno.setCoordenadas(cursor.getString(3));
                alumno.setIcono(cursor.getString(4));
                return alumno;
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

    public Modelo insertarAlumno(String id, String nombre, String direccion, String telefono, String email){
        try (SQLiteDatabase db = Util.abrirBD(context, Util.DBNAME)) {
            ContentValues cv = new ContentValues();
            cv.put("id", id);
            cv.put(NOMBRE, nombre);
            cv.put("direccion", direccion);
            cv.put("telefono", telefono);
            cv.put("email", email);


            Modelo alumno = new Modelo();
            alumno.setId(id);
            alumno.setTitulo(nombre);
            alumno.setUltimaactualizacion(direccion);
            alumno.setCoordenadas(telefono);
            alumno.setIcono(email);

            return alumno;
        }
    }

    public void actualizarAlumno(Modelo alumno){
        try (SQLiteDatabase db = Util.abrirBD(context, Util.DBNAME)){
            ContentValues cv = new ContentValues();
            cv.put(NOMBRE, alumno.getTitulo());
            cv.put("direccion", alumno.getUltimaactualizacion());
            cv.put("telefono", alumno.getCoordenadas());
            cv.put("email", alumno.getIcono());
            db.update("alumnos", cv, "id = ?", new String[]{String.valueOf(alumno.getId())});
        }
    }

    public void borrarAlumno(Modelo alumno){
        try (SQLiteDatabase db = Util.abrirBD(context, Util.DBNAME)){
            db.delete("alumnos", "id = ?", new String[] {String.valueOf(alumno.getId())});
        }
    }
}
