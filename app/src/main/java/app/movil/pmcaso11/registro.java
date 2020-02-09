package app.movil.pmcaso11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class registro extends AppCompatActivity {

    private Button btn1;
    private Button btn2;
    private TextView vista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);



        Bundle mensaje=getIntent().getExtras();

        if(mensaje!=null){

            String Bundle = mensaje.getString("msn");

            Toast.makeText(registro.this,Bundle,Toast.LENGTH_LONG).show();


        }else{

            Toast.makeText(registro.this,"Esto se encuentra vacio",Toast.LENGTH_LONG).show();


        }


        btn2=(Button)findViewById(R.id.apr1);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent second2 = new Intent(registro.this,registroUsu.class);

                startActivity(second2);
            }
        });



    }



}
