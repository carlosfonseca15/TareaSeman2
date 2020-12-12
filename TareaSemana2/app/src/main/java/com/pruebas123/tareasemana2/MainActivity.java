package com.pruebas123.tareasemana2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etNombreCompleto;
    private TextView tvFecha;
    private EditText etTelefono;
    private EditText etEmail;
    private EditText etDescripcion;
    String nombre, fecha, tel, email, desc;
    DatePicker picker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //valieda si hay parametros
        if (getIntent()!=null && getIntent().getExtras() !=null) {
            Bundle bundle = getIntent().getExtras();
            nombre = bundle.getString(getResources().getString(R.string.pnombre));
            fecha = bundle.getString(getResources().getString(R.string.pfecha));
            tel = bundle.getString(getResources().getString(R.string.ptelefono));
            email = bundle.getString(getResources().getString(R.string.pemail));
            desc = bundle.getString(getResources().getString(R.string.pdescripcion));
        }

        etNombreCompleto = (EditText) findViewById(R.id.etNombreCompleto);
        tvFecha          = (TextView) findViewById(R.id.tvFechaNac);
        etTelefono       = (EditText) findViewById(R.id.etTelefono);
        etEmail          = (EditText) findViewById(R.id.etEmail);
        etDescripcion    = (EditText) findViewById(R.id.etDescripcion);
        Button bSiguiente = (Button) findViewById(R.id.bSiguiente);
        Button bfecha = (Button) findViewById(R.id.bFecha);
        picker           = (DatePicker) findViewById(R.id.datePicker1);
        bfecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvFecha.setText(picker.getDayOfMonth()+"/"+ (picker.getMonth() + 1)+"/"+picker.getYear());
            }
        });
        //carga valores de parametros
        etNombreCompleto.setText(nombre);
        tvFecha.setText(fecha);
        etTelefono.setText(tel);
        etEmail.setText(email);
        etDescripcion.setText(desc);

        bSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ConfirmarDatos.class);
                intent.putExtra(getResources().getString(R.string.pnombre),etNombreCompleto.getText().toString());
                intent.putExtra(getResources().getString(R.string.pfecha),tvFecha.getText().toString());
                intent.putExtra(getResources().getString(R.string.ptelefono),etTelefono.getText().toString());
                intent.putExtra(getResources().getString(R.string.pemail),etEmail.getText().toString());
                intent.putExtra(getResources().getString(R.string.pdescripcion),etDescripcion.getText().toString());

                startActivity(intent);
                finish();
            }
        });


    }


}