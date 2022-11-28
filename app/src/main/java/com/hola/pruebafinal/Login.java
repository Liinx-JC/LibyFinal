package com.hola.pruebafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    Button regi, ini;
    EditText usu, pass;
    TextView recupe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void Registro(View view) {
        regi = (Button) findViewById(R.id.regis);
        Intent regi = new Intent(Login.this, Registro.class);
        startActivity(regi);
    }

    public void Iniciar(View view) {
        ini = (Button) findViewById(R.id.iniciar);
        Intent ini = new Intent(Login.this, NavigationDrawer.class);
        startActivity(ini);
    }

    public void Recuperar (View view){
        recupe = (TextView) findViewById(R.id.recuperar);
        Intent recupe = new Intent(Login.this, Recuperar.class);
        startActivity(recupe);
    }
}