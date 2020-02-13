package app.movil.pmcaso11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class testdb extends AppCompatActivity {

    private EditText id, nombre, apellido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testdb);

        id=(EditText)findViewById(R.id.id);
        nombre=(EditText)findViewById(R.id.nombre);
        apellido=(EditText)findViewById(R.id.apellido);

    }

    //METODO PARA AGREGAR UN USUARIO

    public void registrar(View view){

        AdminSqliteOpenHelper admin =new AdminSqliteOpenHelper(this,"greendb",null,1); // Creacion de base de datos
        SQLiteDatabase db =admin.getWritableDatabase(); // Abrir la bases de datos en modo lectura y escritura

        String iden=id.getText().toString(); // conversion de los datos
        String nom=nombre.getText().toString();
        String ape=apellido.getText().toString();

        //int valor=Integer.parseInt(iden);


        if(!iden.isEmpty() && !nom.isEmpty()&& !ape.isEmpty()){

            ContentValues datos= new ContentValues();

            datos.put("idDocumento",iden );  //Asociar los datos de las variables a los campos
            datos.put("nombreUsuario",nom);
            datos.put("apellidoUsuario",ape);


            db.insert("usuario",null, datos);
            db.close();

            id.setText("");
            nombre.setText("");
            apellido.setText("");

            Toast.makeText(this,"REGISTRO EXITOSO",Toast.LENGTH_LONG).show();

        }else{

            Toast.makeText(this,"DEBE LLENAR TODOS LOS CAMPOS",Toast.LENGTH_LONG).show();
        }



    }

    // METODO PARA BUSCAR UN USUARIO

    public void buscar(View view){

        AdminSqliteOpenHelper admin =new AdminSqliteOpenHelper(this,"greendb",null,1 );
        SQLiteDatabase db =admin.getWritableDatabase();

        String codigo= id.getText().toString();

        if(!codigo.isEmpty()){

            Cursor registro =db.rawQuery("select nombreUsuario, apellidoUsuario from usuario where idUsuario="+codigo, null);

            if(registro.moveToFirst()){

                nombre.setText(registro.getString(0));
                apellido.setText(registro.getString(1));

                db.close();
            }else{
                Toast.makeText(this,"NO EXISTEN REGISTROS",Toast.LENGTH_LONG).show();
                db.close();
            }


        }else{

            Toast.makeText(this,"DEBE INTRODUCIR UN NUMERO DE CEDULA",Toast.LENGTH_LONG).show();
        }






    }




}
