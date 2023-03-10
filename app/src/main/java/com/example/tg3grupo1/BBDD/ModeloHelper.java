package com.example.tg3grupo1.BBDD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ModeloHelper extends SQLiteOpenHelper {

    public ModeloHelper(@Nullable Context context) {
        super(context, "Taxis.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS registros");
        String sql = "CREATE TABLE registros (id TEXT, titulo TEXT, " +
                "ultimaactualizacion TEXT, coordenadas TEXT, icono TEXT);";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
