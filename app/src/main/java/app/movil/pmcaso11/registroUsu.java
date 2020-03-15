package app.movil.pmcaso11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class registroUsu extends AppCompatActivity {

    private static final String TAG ="" ;
    private Spinner despliegue;
    private Spinner pais;
    private Spinner ciudad;
    private EditText identificacion, nombre, apellido, direccion, email, telefono, password;
    private Integer tipod;
    private Integer country;
    private Integer ciud;
    private Button registro;

    private final Integer rol=1;

    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usu);

        identificacion = (EditText) findViewById(R.id.doc);
        nombre = (EditText) findViewById(R.id.nomUsuario);
        apellido = (EditText) findViewById(R.id.apeUsuario);
        direccion = (EditText) findViewById(R.id.direccion);
        email = (EditText) findViewById(R.id.email);
       telefono = (EditText) findViewById(R.id.telefono);
        password = (EditText) findViewById(R.id.password);

        registro=(Button)findViewById(R.id.regis);
        mAuth = FirebaseAuth.getInstance();

        //Spinner Tipo de Documento


        despliegue = (Spinner) findViewById(R.id.tipodoc);
        String Documento[]={"CEDULA","PASAPORTE","TI"};
        ArrayAdapter<String> document=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,Documento);
        despliegue.setAdapter(document);



       //Spinner Pais



        pais = (Spinner) findViewById(R.id.pais);
        String paises[]={"COLOMBIA"};
        ArrayAdapter<String> document1=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,paises);
        pais.setAdapter(document1);

        //Spinner Ciudad





        ciudad = (Spinner) findViewById(R.id.ciudad);
        String ciudades[]={"BOGOTA","MEDELLIN","CALI"};
        ArrayAdapter<String> document2=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,ciudades);
        ciudad.setAdapter(document2);




        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String correo, pass;

                correo=email.getText().toString();
                pass=password.getText().toString();

                mAuth.createUserWithEmailAndPassword(correo, pass)


                        .addOnCompleteListener(registroUsu.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information

                                    Toast.makeText(registroUsu.this, "Usuario Registrado Correctamente.",
                                            Toast.LENGTH_LONG).show();
                                    Intent second = new Intent(registroUsu.this,principal.class);
                                    startActivity(second);
                                    Log.d(TAG, "Usuario Creado Exitosamente");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(registroUsu.this, "Imposible Registrarse.",
                                            Toast.LENGTH_SHORT).show();
                                    updateUI(null);
                                }

                                // ...
                            }
                        });


            }
        });



    }

    private void updateUI(FirebaseUser user) {

        if(user !=null){

            Intent second = new Intent(registroUsu.this,principal.class);
            startActivity(second);

            finish();

        }



    }



}



