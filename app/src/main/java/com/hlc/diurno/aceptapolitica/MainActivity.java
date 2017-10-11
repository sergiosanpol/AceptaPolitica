package com.hlc.diurno.aceptapolitica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final static int CODIGO_VERIFICA = 1;

    private EditText nombre;
    private Button verifica;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.nombre = (EditText) findViewById(R.id.et_nombre);
        this.verifica = (Button) findViewById(R.id.verifica);
        this.resultado = (TextView) findViewById(R.id.resultado);

        this.resultado.setText("Resultado:");

        this.verifica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!nombre.getText().toString().isEmpty()){
                    Intent intent = new Intent(view.getContext(), Verifica.class);
                    intent.putExtra("NOMBRE", nombre.getText().toString());
                    startActivityForResult(intent, CODIGO_VERIFICA);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == CODIGO_VERIFICA && resultCode == RESULT_OK){
            if(data.hasExtra("RESULTADO")){
                this.resultado.setText("Resultado: " + data.getStringExtra("RESULTADO"));
            }
        }
    }
}
