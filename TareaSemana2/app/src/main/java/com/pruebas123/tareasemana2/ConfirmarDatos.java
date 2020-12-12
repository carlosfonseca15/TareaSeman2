package com.pruebas123.tareasemana2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ConfirmarDatos extends AppCompatActivity {

    private TextView tvNombre, tvFechaNacimiento, tvTelefono, tvEmail, tvDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        Bundle bundle = getIntent().getExtras();
        String nombre = bundle.getString(getResources().getString(R.string.pnombre));
        String fecha = bundle.getString(getResources().getString(R.string.pfecha));
        String tel = bundle.getString(getResources().getString(R.string.ptelefono));
        String email = bundle.getString(getResources().getString(R.string.pemail));
        String desc = bundle.getString(getResources().getString(R.string.pdescripcion));

        tvNombre            = findViewById(R.id.tvNombre);
        tvFechaNacimiento   = findViewById(R.id.tvFechaNacimiento);
        tvTelefono          = findViewById(R.id.tvTelefono);
        tvEmail             = findViewById(R.id.tvEmail);
        tvDescripcion       = findViewById(R.id.tvDescripcion);
        Button bEnviaDatos = findViewById(R.id.bEnviaDatos);

        tvNombre.setText(nombre);
        tvFechaNacimiento.setText(fecha);
        tvTelefono.setText(tel);
        tvEmail.setText(email);
        tvDescripcion.setText(desc);

        bEnviaDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConfirmarDatos.this, MainActivity.class);
                intent.putExtra(getResources().getString(R.string.pnombre),tvNombre.getText().toString());
                intent.putExtra(getResources().getString(R.string.pfecha),tvFechaNacimiento.getText().toString());
                intent.putExtra(getResources().getString(R.string.ptelefono),tvTelefono.getText().toString());
                intent.putExtra(getResources().getString(R.string.pemail),tvEmail.getText().toString());
                intent.putExtra(getResources().getString(R.string.pdescripcion),tvDescripcion.getText().toString());

                startActivity(intent);
                finish();
            }
        });

    }
}