package com.example.pruebasbd.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.pruebasbd.ExtraccionRegistros;

import java.util.ArrayList;

public class DbContras extends DbHelper{

    Context context;
    public DbContras(@Nullable Context context) {
        super(context);
        this.context = context;
    }
    public long insertarContra(String plataforma, String Contra){
        long id = 0;
        try{
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("plataforma", plataforma);
            values.put("contrasena", Contra);

            id =  db.insert(TABLE_CONTRAS, null, values);
        } catch(Exception ex){
            ex.toString();
        }
        return id;
    }
    public ArrayList<ExtraccionRegistros> mostrarContras(){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ArrayList<ExtraccionRegistros> listaContras = new ArrayList<>();
        ExtraccionRegistros Reg = null;
        Cursor cursorcontras = null;

        cursorcontras = db.rawQuery("SELECT * FROM " + TABLE_CONTRAS, null);

        if (cursorcontras.moveToFirst()){
            do{
                Reg = new ExtraccionRegistros();
                Reg.setId(cursorcontras.getInt(0));
                Reg.setPlataforma(cursorcontras.getString(1));
                Reg.setContrasenas(cursorcontras.getString(2));

                listaContras.add(Reg);
            }while(cursorcontras.moveToNext());
        }
        cursorcontras.close();
        return listaContras;
    }
}