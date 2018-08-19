package com.example.AMImaps;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private boolean b_subida = false;
    private boolean b_bajada = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button boton_alrededor = (Button) findViewById(R.id.mostrar_rutas);
        Button boton_maps = (Button) findViewById(R.id.mostrar_rutas);
        boton_alrededor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent AlrededorActIntent = new Intent(getApplicationContext(), AlrededorActivity.class);
                startActivity(AlrededorActIntent);
            }
        });

        final Spinner spinnerSubida = (Spinner) findViewById(R.id.subida);
        final Spinner spinnerBajada = (Spinner) findViewById(R.id.bajada);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.points_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSubida.setPrompt("Choose one");
        spinnerBajada.setPrompt("Choose one");
        spinnerSubida.setAdapter(adapter);
        spinnerBajada.setAdapter(adapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_escaneo);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Abriendo mapa... ¡Escaneando...!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Toast.makeText(getApplicationContext(), "Abriendo mapa... ¡Escaneando...!",
                    Toast.LENGTH_SHORT).show();
                Intent ScanActIntent = new Intent(getApplicationContext(), ScanActivity.class);
                startActivity(ScanActIntent);
            }
        });

        spinnerSubida.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                if (id > 1) {
                    b_subida = true;
                }else
                    b_subida = false;

                if (b_subida && b_bajada) {
                    Intent IniFinActIntent = new Intent(getApplicationContext(), IniFinActivity.class);
                    IniFinActIntent.putExtra("idSubida", id);
                    IniFinActIntent.putExtra("idBajada", spinnerBajada.getSelectedItemId());
                    startActivity(IniFinActIntent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
        spinnerBajada.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                if (id > 1){
                    b_bajada = true;
                }else
                    b_subida = false;

                if (b_subida && b_bajada){
                    Intent IniFinActIntent = new Intent(getApplicationContext(), IniFinActivity.class);
                    IniFinActIntent.putExtra("idSubida", spinnerSubida.getSelectedItemId());
                    IniFinActIntent.putExtra("idBajada", id);
                    startActivity(IniFinActIntent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }

}

