package app.movil.pmcaso11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class principal extends AppCompatActivity {

    private Button zonas;
    private Button aprende;
    private Button cerrar;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        zonas=(Button)findViewById(R.id.zonasR);
        aprende=(Button)findViewById(R.id.aprendeR);
        cerrar=(Button)findViewById(R.id.cerrarSesion);

        //Valida el usuario nuevo en la sesion
        mAuth=FirebaseAuth.getInstance();


        // Cerrar la Sesion de Usuario
        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(principal.this,MainActivity.class));
            }
        });





        zonas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent second = new Intent(principal.this,zonas.class);
                startActivity(second);



            }
        });


        aprende.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent second = new Intent(principal.this,categorias.class);
                startActivity(second);


            }
        });




    }





}
