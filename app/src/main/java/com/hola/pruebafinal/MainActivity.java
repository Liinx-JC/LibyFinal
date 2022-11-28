package com.hola.pruebafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Mensaje emergente
        //Toast.makeText(getApplicationContext(),"Cargando...", Toast.LENGTH_LONG).show();
        //intent para pasar a la siguiente activity
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                Intent liby1 = new Intent(MainActivity.this, Login.class);
                startActivity(liby1);
                finish();
            }
        };
        //Tiempo que se le dara al splashscreen
        Timer tiempo = new Timer();
        tiempo.schedule(tarea, 4000);

    }
}