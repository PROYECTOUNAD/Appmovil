package app.movil.pmcaso11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

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




