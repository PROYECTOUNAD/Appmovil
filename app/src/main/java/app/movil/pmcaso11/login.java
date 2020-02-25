package app.movil.pmcaso11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class login extends AppCompatActivity {

    private Button registro;
    private TextView recuperar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        recuperar=(TextView)findViewById(R.id.recuperar);

        registro = (Button) findViewById(R.id.registrar);


            registro.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                        Intent second = new Intent(login.this,registroUsu.class);
                        startActivity(second);

                }
            });

            // Recuperar Pass

            recuperar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent second = new Intent(login.this,activity_recover_password_new.class);
                    startActivity(second);

                }
            });


    }

}
