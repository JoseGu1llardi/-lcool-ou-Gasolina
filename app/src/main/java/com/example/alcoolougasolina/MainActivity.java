package com.example.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editAlcool, editGasolina;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editAlcool   = findViewById(R.id.editPrecoAlcool);
        editGasolina = findViewById(R.id.editPrecoGasolina);
        resultado    = findViewById(R.id.textResultado);
    }

    public void calcularPreco(View view) {

        // Recuperar valores digitados
        String precoAlcool = editAlcool.getText().toString();
        String precoGasolina = editGasolina.getText().toString();

        // Validar campos digitados
        Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);
        if(camposValidados) {

            // Converter Strings para números
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);

            /* Fazer cálculo de menor preço
                se(valorAlcool / valorGasolina) >= 0.7 é melhor utilizar gasolina
                senao(é melhor utilizar alcool)
             */

            Double resultadoCalculo = valorAlcool / valorGasolina;
            if (resultadoCalculo >= 0.7){
                resultado.setText("Melhor utilizar Gasolina " + resultadoCalculo);
            }else {
                resultado.setText("Melhor utilizar Alcool " + resultadoCalculo);
            }

        }else {
            resultado.setText("Preencha os campos primeiro");
        }
    }

    public Boolean validarCampos(String pAlcool, String pGasolina) {

        Boolean camposValidados = true;

        if (pAlcool == null || pAlcool.equals("")){
                camposValidados = false;
        } else  if (pGasolina == null || pGasolina.equals("")) {
            camposValidados = false;
        }

        return camposValidados;
    }
}