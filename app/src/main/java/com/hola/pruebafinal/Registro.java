package com.hola.pruebafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class Registro extends AppCompatActivity {

    //DECLARAMOS VARIABLES
    EditText nom, ape, correo, pass, fono, dire;
    TextView volv;
    private dbHelper helper;
    private SQLiteDatabase db;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        nom=(EditText)findViewById(R.id.editNombre);
        ape=(EditText)findViewById(R.id.editApe);
        correo=(EditText)findViewById(R.id.editCorreo);
        pass=(EditText)findViewById(R.id.editPass);
        fono=(EditText)findViewById(R.id.editFono);
        dire=(EditText)findViewById(R.id.editDire);


        inicializarfirebase();
    }

    private void inicializarfirebase() {


        FirebaseApp.initializeApp(this);
        //PASAMOS LA INSTANCIA Y LA REFERENCIA DE LA BD
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        Toast.makeText(getApplicationContext(),"Ejecuta",Toast.LENGTH_SHORT).show();
    }

    public void registrarDatos(View view){

        String nombre = nom.getText().toString();
        String apellido = ape.getText().toString();
        String corre = correo.getText().toString();
        String password = pass.getText().toString();
        String telefono = fono.getText().toString();
        String direccion = dire.getText().toString();

        if(nombre.equals("")||apellido.equals("")||corre.equals("")||password.equals("")||telefono.equals("")||direccion.equals("")){
            nom.setError("Campo requerido");
            ape.setError("Campo requerido");
            correo.setError("Campo requerido");
            pass.setError("Campo requerido");
            fono.setError("Campo requerido");
            dire.setError("Campo requerido");
        }else{
            Persona p = new Persona();
            p.setUid(UUID.randomUUID().toString());
            p.setNombre(nombre);
            p.setApellido(apellido);
            p.setCorreo(corre);
            p.setContra(password);
            p.setFono(telefono);
            p.setDire(direccion);
            databaseReference.child("Usuario").child(p.getUid()).setValue(p);
            Toast.makeText(getApplicationContext(),"Persona registrada", Toast.LENGTH_SHORT).show();
        }

        helper = new dbHelper(this);
        db = helper.getWritableDatabase();
        //CAPTURA LOS DATOS INGRESADOS EN VARIABLES
        String n = nom.getText().toString();
        String a = ape.getText().toString();
        String c = correo.getText().toString();
        String p = pass.getText().toString();
        String t = fono.getText().toString();
        String d = dire.getText().toString();

        //ENLANZA EL ATRIBUTO CON LAS VARIABLES QUE ALMACENAN LOS DATOS
        ContentValues registro = new ContentValues();
        registro.put("nombre", n);
        registro.put("apellido", a);
        registro.put("correo", c);
        registro.put("contraseña", p);
        registro.put("fono", t);
        registro.put("dire", d);

        //CURSOR SIRVE PARA RECORRER LOS REGISTROS OBTENIDOS, EN ESTE CASO UNA QUERY PARA OBTENER LOS REGISTROS DE X RUT
        Cursor fila = db.rawQuery("select nombre, apellido, correo, contraseña, fono, dire from perfil where correo = '" + c + "'", null);
        //SI SE ENCUENTRA UN REGISTRO
        if (fila.moveToFirst()) {
            nom.setText(fila.getString(0));
            ape.setText(fila.getString(1));
            correo.setText(fila.getString(2));
            pass.setText(fila.getString(3));
            fono.setText(fila.getString(4));
            dire.setText(fila.getString(5));
            Toast.makeText(getApplicationContext(), "Usuario ya existente", Toast.LENGTH_LONG).show();
        } else { //EN CASO CONTRARIO
            nom.setText("");
            ape.setText("");
            correo.setText("");
            pass.setText("");
            fono.setText("");
            dire.setText("");
            db.insert("perfil", null, registro);
            Toast.makeText(getApplicationContext(), "Usuario ha sido registrado", Toast.LENGTH_LONG).show();
        }
        db.close();//TERMINA LA CONEXION
        nom.setText("");
        ape.setText("");
        correo.setText("");
        pass.setText("");
        fono.setText("");
        dire.setText("");



    }
    public void Volver (View view){
        volv = (TextView) findViewById(R.id.txtVolver);
        Intent volv = new Intent(Registro.this, Login.class);
        startActivity(volv);
    }

}