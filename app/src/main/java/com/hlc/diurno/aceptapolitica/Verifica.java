package com.hlc.diurno.aceptapolitica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Verifica extends AppCompatActivity {

    private String nombre;
    private TextView saludo;
    private Button acepto, rechazo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifica);

        this.acepto = (Button) findViewById(R.id.acepto);
        this.rechazo = (Button) findViewById(R.id.rechazo);
        this.saludo = (TextView) findViewById(R.id.saludo);

        if(getIntent().hasExtra("NOMBRE")){
            this.nombre = getIntent().getStringExtra("NOMBRE");
            this.saludo.setText("Hola " + this.nombre + " ¿Aceptas la política de privacidad");
        }
    }

    public void enviarResultado(View v){
        Intent resultados = new Intent();
        if(v.getId() == this.acepto.getId()){
            resultados.putExtra("RESULTADO", "Aceptada");
        }else{
            resultados.putExtra("RESULTADO", "Rechazada");
        }
        setResult(RESULT_OK, resultados);
        finish();
    }

}
