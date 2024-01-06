package com.example.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private TextView tvRes;
    private TextView pantalla;
    private Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bsum,bres,bmul,bdiv,big;
    private double primerNumero = 0;
    private String operacionPendiente = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvRes = findViewById(R.id.tvRes);
        pantalla = findViewById(R.id.pantalla);
        b0 = findViewById(R.id.num0);
        b1 = findViewById(R.id.num1);
        b2 = findViewById(R.id.num2);
        b3 = findViewById(R.id.num3);
        b4 = findViewById(R.id.num4);
        b5 = findViewById(R.id.num5);
        b6 = findViewById(R.id.num6);
        b7 = findViewById(R.id.num7);
        b8 = findViewById(R.id.num8);
        b9 = findViewById(R.id.num9);
        bsum = findViewById(R.id.suma);
        bres = findViewById(R.id.resta);
        bmul = findViewById(R.id.multiplicacion);
        bdiv = findViewById(R.id.division);
        big = findViewById(R.id.igual);
    }


    public void calcular(View v){//Cacha todo tipo de parametro View
        String textButon = ((Button) v).getText().toString();

        if(esNumero(textButon) || textButon.equals(".")) {
            tvRes.append(textButon);

        }else if(!textButon.equals("=")){
            realizarOperacion(textButon);
        }else{
            // Si se presiona "=", realizar la operacion pendiente
            realizarOperacion(operacionPendiente);
            // Reiniciar la operacion pendiente
            operacionPendiente = "";
        }
    }


    private boolean esNumero(String texto){
        return texto.matches("\\d+(\\.\\d+)?");
    }

    public void realizarOperacion(String operacion){

    double numeroActual = Double.parseDouble(tvRes.getText().toString());

    switch(operacionPendiente){
        case "+":
            primerNumero += numeroActual;
            break;
        case "-":
            primerNumero -= numeroActual;
            break;
        case "*":
            primerNumero *= numeroActual;
            break;
        case "/":
            if( numeroActual != 0 ){
                primerNumero /= numeroActual;
            }else{
                pantalla.setText("Error");
                return;
            }
            break;
        default:
            primerNumero = numeroActual;
            break;
    }

    pantalla.setText(String.valueOf(primerNumero));

    operacionPendiente = operacion.equals("=") ? "" : operacion;
    tvRes.setText("");
        }


}