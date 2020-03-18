package app.movil.pmcaso11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class reciclaje extends AppCompatActivity {

    private Button BconsultarBonoPunt, BingresarReci;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reciclaje);

        BconsultarBonoPunt=(Button)findViewById(R.id.consultarBonoPunt);
        BingresarReci=(Button)findViewById(R.id.ingresarReci);


        BconsultarBonoPunt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(reciclaje.this,consultarBonPun.class));
            }
        });

        BingresarReci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent second = new Intent(reciclaje.this,infoReciclajeUsu.class);
                startActivity(second);

            }
        });
    }
}
