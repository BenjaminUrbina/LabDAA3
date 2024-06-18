package com.example.pruebasbd.db;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pruebasbd.ExtraccionRegistros;
import com.example.pruebasbd.ListaContrasAdaptador;
import com.example.pruebasbd.MainActivity;
import com.example.pruebasbd.MainActivityAgregarContras;
import com.example.pruebasbd.R;

import java.util.ArrayList;

public class  Activity_inicio extends AppCompatActivity {

    RecyclerView listaContras;
    ArrayList<ExtraccionRegistros> listaarrayregistros;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        listaContras = findViewById(R.id.ListadeContrasenas);
        listaContras.setLayoutManager(new LinearLayoutManager(this));

        DbContras dbcontrasenas = new DbContras(Activity_inicio.this);

        listaarrayregistros = new ArrayList<>();
        ListaContrasAdaptador adaptador = new ListaContrasAdaptador(dbcontrasenas.mostrarContras());
        listaContras.setAdapter(adaptador);
        //CrearBase();
    }
    public void CrearBase(){
        DbHelper dbHelper= new DbHelper(Activity_inicio.this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        if(db != null){
            Toast.makeText(Activity_inicio.this, "BASE DE DATOS CREADA", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(Activity_inicio.this, "ERROR JAJA", Toast.LENGTH_LONG).show();
        }
    }
    public void VentanaAgregar(View view){
        Intent intent = new Intent(Activity_inicio.this, MainActivityAgregarContras.class);
        startActivity(intent);
    }
    public void VentanaBorrar(View view){
        Intent intent = new Intent(Activity_inicio.this, MainActivityAgregarContras.class);
        startActivity(intent);
    }
    public void VentanaEditar(View view){
        Intent intent = new Intent(Activity_inicio.this, MainActivityAgregarContras.class);
        startActivity(intent);
    }
}

