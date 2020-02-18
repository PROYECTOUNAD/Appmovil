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
    private EditText identificacion,nombre,apellido,direccion,email,telefono,password;
    private String tipod;
    private String country;
    private String ciud;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usu);

        identificacion=(EditText) findViewById(R.id.doc);
        nombre=(EditText)findViewById(R.id.nombre);
        apellido=(EditText)findViewById(R.id.apellido);
        direccion=(EditText)findViewById(R.id.direccion);
        email=(EditText)findViewById(R.id.email);
        telefono=(EditText)findViewById(R.id.telefono);
        password=(EditText)findViewById(R.id.password);



        //Spinner Tipo de Documento

        despliegue=(Spinner) findViewById(R.id.tipodoc);

        ArrayList<String> elementos= new ArrayList<>();

        elementos.add("CEDULA");
        elementos.add("PASAPORTE");

        ArrayAdapter adp=new ArrayAdapter(registroUsu.this,android.R.layout.simple_spinner_dropdown_item,elementos);

        despliegue.setAdapter(adp);
        despliegue.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String elemento=(String)despliegue.getAdapter().getItem(position);
                tipod=elemento;

                Toast.makeText(registroUsu.this,"Seleccionaste :"+elemento, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //Spinner Pais

        pais=(Spinner) findViewById(R.id.pais);

        ArrayList<String> paises= new ArrayList<>();

        paises.add("COLOMBIA");

        ArrayAdapter lista=new ArrayAdapter(registroUsu.this,android.R.layout.simple_spinner_dropdown_item,paises);

        pais.setAdapter(lista);

        pais.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String elementob=(String)pais.getAdapter().getItem((position));
                country=elementob;
                Toast.makeText(registroUsu.this,"Seleccionaste :"+elementob, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //Spinner Ciudad


        ciudad=(Spinner)findViewById(R.id.ciudad);

        ArrayList<String>ciudades =new ArrayList<>();

        ciudades.add("BOGOTA");
        ciudades.add("MEDELLIN");
        ciudades.add("CALI");

        final ArrayAdapter ciu=new ArrayAdapter(registroUsu.this,android.R.layout.simple_spinner_dropdown_item,ciudades);
        ciudad.setAdapter(ciu);

        ciudad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String elementoc=(String)ciudad.getAdapter().getItem(position);
                ciud=elementoc;
                Toast.makeText(registroUsu.this,"Seleccionaste :"+elementoc, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        }

        public void registrar(View view){

            AdminSqliteOpenHelper admin =new AdminSqliteOpenHelper(this,"DB2020",null,1); // Creacion de base de datos
            SQLiteDatabase db =admin.getWritableDatabase();

            String iden=identificacion.getText().toString();
            String nom=nombre.getText().toString();
            String ape=apellido.getText().toString();
            String dir=direccion.getText().toString();
            String correo=email.getText().toString();
            String tel=telefono.getText().toString();
            String pass=password.getText().toString();

            ContentValues datos=new ContentValues();

            datos.put("idDocumento",iden);
            datos.put("tipoDocumento",tipod);
            datos.put("idRol",1);
            datos.put("nombreUsuario",nom);
            datos.put("apellidoUsuario",ape);
            datos.put("idCiudad",ciud);
            datos.put("idPais",country);
            datos.put("direcUsuario",dir);
            datos.put("emailUsuario",correo);
            datos.put("telefonoUsuario",tel);
            datos.put("passUsuario",pass);

            db.insert("usuario",null, datos);
            db.close();


            Toast.makeText(this,"REGISTRO EXITOSO",Toast.LENGTH_LONG).show();




    }







}



