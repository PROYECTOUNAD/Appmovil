package app.movil.pmcaso11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class principal extends AppCompatActivity {

    private Button zonas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        zonas=(Button)findViewById(R.id.zonasR);

        zonas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent second = new Intent(principal.this,zonas.class);
                startActivity(second);



            }
        });


    }





}
