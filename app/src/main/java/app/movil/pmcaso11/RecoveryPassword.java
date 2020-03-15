package app.movil.pmcaso11;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class RecoveryPassword extends AppCompatActivity {


    private EditText email;
    private Button enviar;
    private String mail;
    private FirebaseAuth mAuth;
    private ProgressDialog progreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recovery_password);

        email=(EditText)findViewById(R.id.correor);
        enviar=(Button)findViewById(R.id.envioCorreo);

        mAuth = FirebaseAuth.getInstance();
        progreso=new ProgressDialog(this);



        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               mail=email.getText().toString();

               if(!mail.isEmpty()){

                    progreso.setMessage("Enviando.. Por Favor Espera");
                    progreso.setCanceledOnTouchOutside(false);
                    progreso.show();
                   resetPassword();

               }else{

                   Toast.makeText(RecoveryPassword.this,"Debe ingresar una Direccion de Correo",Toast.LENGTH_SHORT).show();

               }



            }
        });





    }

    private void resetPassword() {


    mAuth.setLanguageCode("es");
    mAuth.sendPasswordResetEmail(mail).addOnCompleteListener(new OnCompleteListener<Void>() {
        @Override
        public void onComplete(@NonNull Task<Void> task) {

            if(task.isSuccessful()){



                Toast.makeText(RecoveryPassword.this,"Se ha Enviado un Correo de Recuperacion de Password",Toast.LENGTH_SHORT).show();


            }else{

                Toast.makeText(RecoveryPassword.this,"No se Pudo Enviar el Correo de Recuperacion ",Toast.LENGTH_SHORT).show();

            }

            progreso.dismiss();

        }
    });

    }


}
