package com.example.lab3.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION =1;
    private static final String DATABASE_NOMBRE = "contrasenas.db";
    public static final String TABLE_CONTRAS = "t_constras";


    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_CONTRAS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "plataforma TEXT NOT NULL," +
                "contrasena TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) { //ACTUALIZAR TABLA, AGREGAR CAMPOS,ETC
        sqLiteDatabase.execSQL("DROP TABLE" + TABLE_CONTRAS);
        onCreate(sqLiteDatabase);
    }
}