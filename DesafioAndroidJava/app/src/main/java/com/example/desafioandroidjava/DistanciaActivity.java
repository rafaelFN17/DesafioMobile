package com.example.desafioandroidjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class DistanciaActivity extends AppCompatActivity {

    EditText CoordX1;
    EditText CoordY1;
    EditText CoordX2;
    EditText CoordY2;
    TextView Resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distancia);
    }


    @Override
    protected void onResume() {
        super.onResume();

        CoordX1 = findViewById(R.id.editCoordX1);
        CoordY1 = findViewById(R.id.editCoordY1);
        CoordX2 = findViewById(R.id.editCoordX2);
        CoordY2 = findViewById(R.id.editCoordY2);
        Resultado = findViewById(R.id.txtViewDistancia);
    }


    public void CalcularDistancia(View view){

        double x1 = pegarValorInserido(CoordX1);
        double y1 = pegarValorInserido(CoordY1);
        double x2 = pegarValorInserido(CoordX2);
        double y2 = pegarValorInserido(CoordY2);

        DecimalFormat df = new DecimalFormat("#,###.00");

        double distancia = ((x2-x1)*(x2-x1))+((y2-y1)*(y2-y1));
        distancia = Math.sqrt(distancia);

        Resultado.setText("Distância:" +df.format(distancia));
        esconderTeclado(view);
    }


    //Metodos auxiliares
    public void esconderTeclado(View view){
        InputMethodManager inputManager = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }


    public Double pegarValorInserido(EditText editText) {
        String valor = editText.getText().toString();
        if(valor != null && valor.length() > 0 ) {
            return Double.parseDouble(valor);
        }
        else {
            editText.setError("Digite um número decimal");
            return 0.0;
        }
    }

}