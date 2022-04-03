package com.example.persistencia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    Button btnCapturar, btnMostar;
    TextView getNombre, getEdad, getCorreo, setNombre, setEdad, setCorreo;
    Datos datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        datos = new ViewModelProvider(this).get(Datos.class);

        btnCapturar = findViewById(R.id.btnCapturar);
        btnMostar = findViewById(R.id.btnMostrar);

        getNombre = findViewById(R.id.valueNombre);
        getEdad = findViewById(R.id.valueEdad);
        getCorreo = findViewById(R.id.valueCorreo);

        setNombre = findViewById(R.id.setNombre);
        setEdad = findViewById(R.id.setEdad);
        setCorreo = findViewById(R.id.setCorreo);

        setNombre.setText("Nombre: " + datos.getNombre());
        setEdad.setText("Edad: " + String.valueOf(datos.getEdad()));
        setCorreo.setText("Correo: " + datos.getCorreo());

        btnCapturar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datos.setNombre(getNombre.getText().toString());
                datos.setEdad(Integer.parseInt(getEdad.getText().toString()));
                datos.setCorreo(getCorreo.getText().toString());
            }
        });

        btnMostar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNombre.setText("Nombre: " + datos.getNombre());
                setEdad.setText("Edad: " + String.valueOf(datos.getEdad()));
                setCorreo.setText("Correo: " + datos.getCorreo());
            }
        });

    }
}