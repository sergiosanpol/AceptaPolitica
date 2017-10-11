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
    private int edad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifica);

        //Asigno las vistas de la activity a las variables
        this.acepto = (Button) findViewById(R.id.acepto);
        this.rechazo = (Button) findViewById(R.id.rechazo);
        this.saludo = (TextView) findViewById(R.id.saludo);

        //Compruebo si la activity anterior a mandado los datos de NOMBRE y EDAD y lo guado en variables. Muestra un mensaje
        //con el texto de si acepta las politicas
        if(getIntent().hasExtra("NOMBRE") && getIntent().hasExtra("EDAD")){
            this.nombre = getIntent().getStringExtra("NOMBRE");
            this.edad = getIntent().getIntExtra("EDAD", 0);
            this.saludo.setText("Hola " + this.nombre + " ¿Aceptas la política de privacidad?");
        }
    }

    //La activity tiene dos botones acepto o rechazo. Depende de cual se pulse devuelve una cosa u otra. Si se acepta se comprueba si
    //es mayor de edad o no
    public void enviarResultado(View v){
        Intent resultados = new Intent();
        if(v.getId() == this.acepto.getId()){
            if(edad >= 18) {
                resultados.putExtra("RESULTADO", "Aceptada sin restricciones");
            }else{
                resultados.putExtra("RESULTADO", "Aceptada con restricciones");
            }
        }else{
            resultados.putExtra("RESULTADO", "Rechazada");
        }
        setResult(RESULT_OK, resultados); //Para devolver resultados a la activity anterior
        finish(); //Finaliza la activity actual
    }

}
