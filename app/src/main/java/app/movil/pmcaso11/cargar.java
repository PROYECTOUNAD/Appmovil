package app.movil.pmcaso11;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class cargar extends AppCompatActivity {


    private Spinner spinner1;
    private EditText campo1, campo2;
    private Button calcular;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cargar);


        campo1=(EditText)findViewById(R.id.numero1);
        campo2=(EditText)findViewById(R.id.numero2);
        calcular=(Button)findViewById(R.id.calcular);
        resultado=(TextView)findViewById(R.id.resultado);
        spinner1=(Spinner)findViewById(R.id.lista);


        String valores[]={"SUMAR","RESTAR","MULTIPLICAR"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,valores);

        spinner1.setAdapter(adapter);

    }


        public void Calcular(View view){

        // Traer los valores

        String valor1=campo1.getText().toString();
        String valor2=campo2.getText().toString();

       // Conversion a Entero

            int valor_1=Integer.parseInt(valor1);
            int valor_2=Integer.parseInt(valor2);


            String seleccion=spinner1.getSelectedItem().toString();

            if(seleccion.equals("SUMAR")){


                int suma=valor_1+valor_2;
                String val=String.valueOf(suma);
                resultado.setText(val);


            }else if(seleccion.equals("RESTAR")){

                int restar=valor_1-valor_2;
                String val=String.valueOf(restar);
                resultado.setText(val);

            }else if(seleccion.equals("MULTIPLICAR")){

                int multiplicar=valor_1*valor_2;
                String val=String.valueOf(multiplicar);
                resultado.setText(val);

            }




        }





    }





