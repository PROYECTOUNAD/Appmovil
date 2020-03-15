package app.movil.pmcaso11;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {

    private static final String TAG ="";
    private Button registro;
    private Button ingreso;
    private EditText user;
    private EditText clave;
    private TextView recovery;


     // Variable Base de Datos Firebase
    private FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        registro =(Button)findViewById(R.id.regis);
        ingreso=(Button)findViewById(R.id.ingresar);
        user=(EditText)findViewById(R.id.usuario);
        clave=(EditText)findViewById(R.id.pass);
        recovery=(TextView)findViewById(R.id.recovery);

        mAuth = FirebaseAuth.getInstance();



        ingreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String correo, password;

                correo=user.getText().toString();
                password=clave.getText().toString();


            if(TextUtils.isEmpty(correo)){

                Toast.makeText(login.this, "El Campo  Usuario no puede estar vacio.",Toast.LENGTH_SHORT).show();

                    return;
            }

            if(TextUtils.isEmpty(password)){

                    Toast.makeText(login.this, "El Campo  Password no puede estar vacio.",Toast.LENGTH_SHORT).show();

                    return;
            }
            if(password.length()<=5){

                Toast.makeText(login.this, "El Password debe ser mayor a 5 Caracteres.",Toast.LENGTH_SHORT).show();

                    return;
            }

                mAuth.signInWithEmailAndPassword(correo,password)
                        .addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    Intent second = new Intent(login.this,principal.class);
                                    startActivity(second);
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "Bienvenido");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                    Intent second = new Intent(login.this,login.class);
                                    startActivity(second);
                                    Toast.makeText(login.this, "Autenticacion Fallida.",
                                            Toast.LENGTH_SHORT).show();
                                    updateUI(null);
                                }

                                // ...
                            }
                        });




            }
        });


        // Registrar Usuario

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(login.this,registroUsu.class));


            }
        });




        recovery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent recovery = new Intent ( login.this, RecoveryPassword.class );
                startActivity(recovery);


            }
        });






    }


    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);



    }

    private void updateUI(FirebaseUser user) {

        if(user !=null){

            /*
            Intent second = new Intent(login.this,principal.class);
            startActivity(second);

            finish();


             */
        }



    }


}
