package app.movil.pmcaso11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity {

    private Button btn; // Crear variables de tipo Objeto



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


      btn=(Button)findViewById(R.id.b1);

      btn.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              Intent second = new Intent(MainActivity.this,login.class);
              startActivity(second);
          }
      });



        }






}




