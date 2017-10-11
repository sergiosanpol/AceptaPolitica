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

    private EditText nombre, edad;
    private Button verifica;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Asigno las vistas de la activity a las variables
        this.nombre = (EditText) findViewById(R.id.et_nombre);
        this.edad = (EditText) findViewById(R.id.et_edad);
        this.verifica = (Button) findViewById(R.id.verifica);
        this.resultado = (TextView) findViewById(R.id.resultado);

        //Le asigno al texto que muestra el resultado el texto incial
        this.resultado.setText("Resultado:");

        //Le asigno una escucha al botón verifica que pasará a la activity verifica. Esta nos devolverá unos resultados
        this.verifica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!nombre.getText().toString().isEmpty()){
                    Intent intent = new Intent(view.getContext(), Verifica.class);
                    intent.putExtra("NOMBRE", nombre.getText().toString());
                    intent.putExtra("EDAD", Integer.parseInt(edad.getText().toString()));
                    startActivityForResult(intent, CODIGO_VERIFICA);
                }
            }
        });
    }

    /**
     * Método que nos gestiona los resultados que devuelve la activity Verifica
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == CODIGO_VERIFICA && resultCode == RESULT_OK){
            if(data.hasExtra("RESULTADO")){
                this.resultado.setText("Resultado: " + data.getStringExtra("RESULTADO"));
            }
        }
    }
}
