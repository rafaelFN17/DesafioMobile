package com.example.desafioandroidjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class TabuadaActivity extends AppCompatActivity {

    EditText valorInserido;
    TextView resultadoTabuada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabuada);

        valorInserido = findViewById(R.id.editNumeroTabuada);
        resultadoTabuada = findViewById(R.id.txtViewTabuada);
    }

    public void calcularTabuada(View view){
        try {
            int valor=Integer.parseInt(valorInserido.getText().toString());

            if (valor > 10){
                valorInserido.setError("Digite um número inteiro de 0 a 10");
                valorInserido.requestFocus();
            }else{
                String tabuada ="";
                for (int count = 0; count <= 10; count++){
                    tabuada= tabuada + valor + "X" + count + "= " + (valor * count)+ "\n";
                }
                resultadoTabuada.setText(tabuada);
                esconderTeclado(view);
            }
        }catch (Exception e){
            valorInserido.setError("Digite um número inteiro de 0 a 10");
            esconderTeclado(view);
        }
    }
    public void esconderTeclado(View view){
        InputMethodManager inputManager = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }



}