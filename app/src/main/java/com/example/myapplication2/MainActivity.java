package com.example.myapplication2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication2.acticity.EnviarRegistros;
import com.example.myapplication2.acticity.registro;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irParaSomos(View view) {

    Intent intentSomos = new Intent(getApplicationContext(), Telaquemsomos.class);
    startActivity(intentSomos);

}

    public void irParaPerfil (View view) {

        Intent intentPerfil = new Intent(getApplicationContext(), perfil.class);
        startActivity(intentPerfil);

    }

    public void irParaRegistro (View view) {

        Intent intentRegistro = new Intent(getApplicationContext(), registro.class);
        startActivity(intentRegistro);

    }

    public void irParaEnviar (View view) {

        Intent intentEnviar = new Intent(getApplicationContext(), EnviarRegistros.class);
        startActivity(intentEnviar);

    }

}
