package com.example.pruebasbd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pruebasbd.db.Activity_inicio;
import com.example.pruebasbd.db.DbContras;

public class MainActivityAgregarContras extends AppCompatActivity {
    EditText txtplataforma, txtcontrasena;
    Button AgregarBase, buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_agregar_contras); // Asegúrate de que este nombre coincida con el archivo XML

        txtplataforma = findViewById(R.id.editTextText);
        txtcontrasena = findViewById(R.id.editTextText3);
        AgregarBase = findViewById(R.id.button2);
        buttonBack = findViewById(R.id.button);

        AgregarBase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbContras dbContras = new DbContras(MainActivityAgregarContras.this);
                long id = dbContras.insertarContra(txtplataforma.getText().toString(), txtcontrasena.getText().toString());

                if (id > 0) {
                    Toast.makeText(MainActivityAgregarContras.this, "REGISTRO AGREGADO", Toast.LENGTH_LONG).show();
                    Clear();
                } else {
                    Toast.makeText(MainActivityAgregarContras.this, "ERROR AL AGREGAR REGISTRO", Toast.LENGTH_LONG).show();
                }
            }
        });

        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityAgregarContras.this, Activity_inicio.class);
                startActivity(intent);
            }
        });
    }

    private void Clear() {
        txtplataforma.setText("");
        txtcontrasena.setText("");
    }
}
