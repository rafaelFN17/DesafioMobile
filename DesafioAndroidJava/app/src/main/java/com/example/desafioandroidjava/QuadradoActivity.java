package com.example.desafioandroidjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class QuadradoActivity extends AppCompatActivity {

    private EditText valorInserido;
    private TextView Resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quadrado);

        valorInserido = findViewById(R.id.edtValorBase);
        Resultado = findViewById(R.id.txtViewResultado);

    }


    public  void calcularQuadradoCubo(View view){
        try {
            double valor = Double.parseDouble(valorInserido.getText().toString());
            double quadrado = valor * valor;
            double cubo = quadrado * valor;
            DecimalFormat df = new DecimalFormat("#,###.00");

            String resultado = "";
            resultado = "Numero" +"\n"
                    + valor + "\n"
                    + "Quadrado" +"\n"
                    + df.format(quadrado) +"\n"
                    + "Cubo"+"\n"
                    + df.format(cubo);

            Resultado.setText(resultado);
            esconderTeclado(view);
        }catch (Exception e){
            valorInserido.setError("Digite um número decimal");
            esconderTeclado(view);
        }
    }

    //Metodos auxiliares
    public void esconderTeclado(View view){
        InputMethodManager inputManager = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}