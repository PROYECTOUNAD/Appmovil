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


        /*** BASE DE DATOS PROYECTO GREEN ZONE ****/

            db.execSQL("create table usuario(idDocumento integer primary key," +
                        "tipoDocumento text," +
                        "nombreUsuario text," +
                        "apellidoUsuario text," +
                        "idCiudad text," +
                        "idPais text," +
                        "idRol integer," +
                        "direcUsuario text," +
                        "emailUsuario text," +
                        "telefonoUsuario integer," +
                        "passUsuario text,"+
                        "foreign key (idRol) references rol (idRol)," +
                        "foreign key(tipoDocumento)references documento(idDocumento)," +
                        "foreign key (idCiudad) references ciudad(idCiudad)," +
                        "foreign key (idPais) references pais(idPais))");


            db.execSQL("create table rol(idRol integer not null primary key autoincrement,nombreRol text)");


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

            db.execSQL("create table ciudad(idCiudad int primary key autoincrement," +
                        "nomCiudad varchar(10)," +
                        "idPais,foreign key (idPais) references pais(idpais))");

            db.execSQL("create table reciclaje(idNumero int primary key autoincrement," +
                        "idDocumento int," +
                        "idZona int ," +
                        "fechaReciclaje text," +
                        "idCategoria int," +
                        "idMedida int," +
                        "desReciclaje varchar(35)," +
                        "cantReciclaje real," +
                        "valorReciclaje real,foreign key (idDocumento) references usuario(idDocumento)," +
                        "foreign key (idMedida) references medida(idMedida)," +
                        "foreign key (idCategoria) references categoria(idCategoria)," +
                        "foreign key (idZona) references zona(idZona))");


            db.execSQL("create table medida(idMedida int primary key autoincrement," +
                        "unMedida char(2)," +
                        "desMedida varchar(15))");

            db.execSQL("create table categoria(idCategoria int primary key autoincrement," +
                        "nomCategoria varchar(25)," +
                        "desCategoria varchar(25))");


            db.execSQL("create table zona(idZona int primary key autoincrement," +
                        "idZona int," +
                        "nombreZona varchar(20)," +
                        "direccZona varchar(25)," +
                        "telZona int," +
                        "localidadZona varchar(30))");


            db.execSQL("create table pais(idPais int primary key autoincrement," +
                         "nomPais varchar(20))");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {






    }






}
