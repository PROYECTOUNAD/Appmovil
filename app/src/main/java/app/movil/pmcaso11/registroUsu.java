package app.movil.pmcaso11;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class registroUsu extends AppCompatActivity {

    private EditText numero1;
    private EditText numero2;
    private Button Boton;
    private TextView Resultado;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usu);

       // numero1=(EditText) findViewById(R.id.numero1);
       // numero2=(EditText) findViewById(R.id.numero2);
       // Boton=(Button)findViewById(R.id.sumar);
        //Resultado=(TextView) findViewById(R.id.resultado);



        }


        public void suma(View vista){

           String campo1=numero1.getText().toString(); // Traer los datos de los Campos
           String campo2=numero2.getText().toString();

           int n1=Integer.parseInt(campo1); // Conversion de String a Entero
           int n2=Integer.parseInt(campo2); // conversion de String a Entero

            int suma=n1+n2;
            String res=String.valueOf(suma);

            Resultado.setText(res); // Mostrar Resultado


            /** if(n1!=0 && n2!=0){


             }else {

                 Toast.makeText(registroUsu.this,mensaje, Toast.LENGTH_LONG).show();

             }*/


          }





  }



