package com.hola.pruebafinal;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class dbHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "libyinicio.sqlite"; //NOMBRE DE LA BD
    private static final int DB_SCHEME_VERSION = 1;

    //CONSTRUCTOR
    public dbHelper(Context context) {
        super(context, DB_NAME, null, DB_SCHEME_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table perfil(id integer primary key autoincrement not null,nombre text not null,apellido text not null,correo text not null, contraseña text not null, fono text not null, dire text not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public Cursor ConsultarUsu(String usu, String pass) throws SQLException {
        Cursor mcursor = null;
        mcursor = this.getReadableDatabase().query("perfil", new String[]{
                "id", "nombre", "apellido", "correo", "contraseña", "fono", "dire"}, "correo like '" + usu + "' " + "and password like '" + pass + "' ", null, null, null, null);
        return mcursor;
    }
}
