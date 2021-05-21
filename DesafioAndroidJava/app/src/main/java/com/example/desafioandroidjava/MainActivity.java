package com.example.desafioandroidjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void chamarTabuada(View view){
        Intent it = new Intent(this, TabuadaActivity.class);
        startActivity(it);
    }

    public void chamarQuadrado(View view){
        Intent it = new Intent( this, QuadradoActivity.class);
        startActivity(it);
    }

    public void chamarDistancia(View view){
        Intent it = new Intent(this, DistanciaActivity.class);
        startActivity(it);
    }

}