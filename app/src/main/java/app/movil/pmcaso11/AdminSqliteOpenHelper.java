package app.movil.pmcaso11;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class AdminSqliteOpenHelper extends SQLiteOpenHelper {


    public AdminSqliteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
        public void onCreate(SQLiteDatabase db) {

          //TABLA DE PRUEBAS

            db.execSQL("create table usuarios(idDocumento int primary key,nombreUsuario varchar(20),apellidoUsuario varchar(20))");




            /* BASE DE DATOS PROYECTO GREEN ZONE */

            db.execSQL("create table usuario(idDocumento int primary key," +
                    "tipoDocumento int," +
                    "idRol int," +
                    "nombreUsuario varchar(20)," +
                    "apellidoUsuario varchar(20)," +
                    "idCiudad int," +
                    "direcUsuario varchar(10)," +
                    "emailUsuario varchar(20), " +
                    "telefonoUsuario int," +
                    "passUsuario varchar(8)," +
                    "foreign key (idRol) references rol (idRol)," +
                    "foreign key(tipoDocumento)references documento(idDocumento) )");


            db.execSQL("create table rol(idRol int primary key autoincrement," +
                        "nombreRol varchar(20))");


            db.execSQL("create table permiso(idPermiso int primary key autoincrement," +
                        "idRol int,nomPermiso varchar(15),autoPermiso numeric," +
                        "denePermiso,foreign key (idRol) references rol (idRol))");


            db.execSQL("create table documento(idDocumento int primary key autoincrement," +
                        "desDocumento varchar(15))");

            db.execSQL("create table puntos(idpunto int primary key autoincrement," +
                        "idDocumento int," +
                        "fechaPunto text," +
                        "cantidadPunto int,foreign key (idDocumento) references usuario (idDocumento))");

            db.execSQL("create table bono(idBono int primary key autoincrement, " +
                        "idDocumento int," +
                        "fechaBono text," +
                        "valorBono real,foreign key (idDocumento) references usuario(idDocumento))");

            db.execSQL("create table descuento(idDescuento int primary key autoincrement," +
                        "idDocumento int," +
                        "porcDescuento int," +
                        "valDescuento real," +
                        "foreign key (idDocumento) references usuario(idDocumento))");

            db.execSQL("create table pago(idPago int primary key autoincrement," +
                        "idDocumento int," +
                        "fechaPago text," +
                        "valorPago real," +
                        "descPago varchar(15)," +
                        "foreign key (idDocumento) references usuario(idDocumento))");











    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
