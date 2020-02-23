package app.movil.pmcaso11;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class registroUsu extends AppCompatActivity {

    private Spinner despliegue;
    private Spinner pais;
    private Spinner ciudad;
    private EditText identificacion, nombre, apellido, direccion, email, telefono, password;
    private Integer tipod;
    private Integer country;
    private Integer ciud;

    private final Integer rol=1;


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




    }


        public void registrar(View view){


            AdminSqliteOpenHelper admin =new AdminSqliteOpenHelper(this,"DB15",null,1); // Creacion de base de datos
            SQLiteDatabase db =admin.getWritableDatabase();

            String seleccion=despliegue.getSelectedItem().toString();
            String seleccion1=pais.getSelectedItem().toString();
            String seleccion2=ciudad.getSelectedItem().toString();
            String iden=identificacion.getText().toString();
            String nom=nombre.getText().toString();
            String ape=apellido.getText().toString();
            String dir=direccion.getText().toString();
            String correo=email.getText().toString();
            String tel=telefono.getText().toString();
            String pass=password.getText().toString();

            int cc=Integer.parseInt(iden);
            int tele=Integer.parseInt(tel);


            ContentValues datos=new ContentValues();

            datos.put("idDocumento",cc);
            datos.put("tipoDocumento",seleccion);
            datos.put("idRol",rol);
            datos.put("nombreUsuario",nom);
            datos.put("apellidoUsuario",ape);
            datos.put("idCiudad",seleccion2);
            datos.put("idPais",seleccion1);
            datos.put("direcUsuario",dir);
            datos.put("emailUsuario",correo);
            datos.put("telefonoUsuario",tele);
            datos.put("passUsuario",pass);

            db.insert("usuario",null, datos);
            db.close();


            Toast.makeText(this,"REGISTRO EXITOSO",Toast.LENGTH_LONG).show();




    }









}



