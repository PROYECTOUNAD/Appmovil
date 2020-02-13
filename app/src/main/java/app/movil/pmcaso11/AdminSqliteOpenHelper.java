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

            db.execSQL("create table usuario(idDocumento int primary key,nombreUsuario varchar(20),apellidoUsuario varchar(20))");






    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
