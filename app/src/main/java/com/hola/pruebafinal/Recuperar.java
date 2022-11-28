package com.hola.pruebafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Recuperar extends AppCompatActivity {

    TextView vol;
    private EditText correo, contraseña, confiContraseña;
    private dbHelper helper;
    private SQLiteDatabase db;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar);

        correo = (EditText) findViewById(R.id.confiCorreo);
        contraseña = (EditText) findViewById(R.id.nuevaPassword);
        confiContraseña=(EditText) findViewById(R.id.confiPassword);
        
        iniciarfirebase();
    }

    private void iniciarfirebase() {

        FirebaseApp.initializeApp(this);
        //PASAMOS LA INSTANCIA Y LA REFERENCIA DE LA BD
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        Toast.makeText(getApplicationContext(),"Ejecuta",Toast.LENGTH_SHORT).show();
    }

    public void confirmarCambio(View view){
        helper = new dbHelper(this);
        db = helper.getWritableDatabase();
        //CAPTURA LOS DATOS INGRESADOS EN VARIABLES
        String c = correo.getText().toString();
        String p = contraseña.getText().toString();
        String cp = confiContraseña.getText().toString();
        int cantidadFilas;
        //LO QUE QUIERO QUE SE SOBREESCRIBA
        ContentValues registro = new ContentValues();
        registro.put("correo", c);
        registro.put("contraseña", p);
        registro.put("confiContra", cp);

        if(!c.isEmpty()|| !p.isEmpty()||cp.isEmpty()){
            if(contraseña.equals(confiContraseña)){
                cantidadFilas = db.update("perfil", registro, "correo = '"+ c + "'",null);
                if(cantidadFilas == 1){
                    Toast.makeText(getApplicationContext(),"Los datos han sido modificados",Toast.LENGTH_LONG).show();
                } else{ //EN CASO CONTRARIO
                    Toast.makeText(getApplicationContext(), "EL usuario no existe en los registro",Toast.LENGTH_LONG).show();
                }
            }Toast.makeText(getApplicationContext(), "Las contraseñas deben ser iguales",Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(getApplicationContext(), "Los campos no pueden estar vacios",Toast.LENGTH_LONG).show();
        }



        db.close();
        correo.setText("");
        contraseña.setText("");
        confiContraseña.setText("");
        /*String Correo = correo.getText().toString();
        String Contra = contraseña.getText().toString();
        String NewContra = confiContraseña.getText().toString();

        if(Correo.equals("")||Contra.equals("")||NewContra.equals("")){
            correo.setError("Campo requerido");
            contraseña.setError("Campo requerido");
            confiContraseña.setError("Campo requerido");
        }else{
            if(correo == 1){
                Persona p2 = new Persona();
                //p2.setUid(personaSelected.getUid());
                p2.setCorreo(correo.getText().toString().trim());
                p2.setContra(contraseña.getText().toString().trim());
                p2.setContra(confiContraseña.getText().toString().trim());
                databaseReference.child("Usuario").child(p2.getUid()).setValue(p2);
                Toast.makeText(this, "Registro modificado", Toast.LENGTH_SHORT).show();
            }

        }
        correo.setText("");
        contraseña.setText("");
        confiContraseña.setText("");*/
    }

    public void volverLog(View view){
        vol = (TextView) findViewById(R.id.txtvol);
        Intent vol = new Intent(Recuperar.this, Login.class);
        startActivity(vol);
    }
}