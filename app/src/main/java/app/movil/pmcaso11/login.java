package app.movil.pmcaso11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {

    private Button registro;
    private Button ingreso;
    private EditText user;
    private EditText clave;
    private TextView recovery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        registro =(Button)findViewById(R.id.registrar);
        ingreso=(Button)findViewById(R.id.ingresar);
        user=(EditText)findViewById(R.id.usuario);
        clave=(EditText)findViewById(R.id.pass);
        recovery=(TextView)findViewById(R.id.recovery);
    }

        public void ingresar(View view){

           /* AdminSqliteOpenHelper admin =new AdminSqliteOpenHelper(this,"DB15",null,1 );
            SQLiteDatabase db =admin.getReadableDatabase();
            String us=user.getText().toString();
            String cl=clave.getText().toString();

            Cursor registro =db.rawQuery("select emailUsuario, passUsuario from usuario where emailUsuario="+"'us'"+"and passUsuario="+"'cl'", null);


*/
                Intent second = new Intent(login.this,principal.class);
                startActivity(second);

                Toast.makeText(this,"BIENVENIDO",Toast.LENGTH_LONG).show();

        }

        public void registrar(View view){

            Intent second = new Intent(login.this,registroUsu.class);
            startActivity(second);

        }
        public void recovery(View view){

        Intent recovery = new Intent ( login.this, RecoveryPassword.class );
        startActivity(recovery);
    }

}
