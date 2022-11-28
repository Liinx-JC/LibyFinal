package com.hola.pruebafinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hola.pruebafinal.Datos.Libreria;
import com.hola.pruebafinal.Datos.LibreriaAdapter;

import java.util.ArrayList;

public class ListLibrerias extends AppCompatActivity {


    ArrayList<Libreria> libre = new ArrayList<>();
    LibreriaAdapter adapter;
    RecyclerView recyclerLibreria;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_librerias);
        recyclerLibreria = findViewById(R.id.recyclerId);
        recyclerLibreria.setLayoutManager(new LinearLayoutManager(this ));


        iniciarfirebase();

    }



    private void iniciarfirebase() {
        FirebaseApp.initializeApp(this);
        //PASAMOS LA INSTANCIA Y LA REFERENCIA DE LA BD
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        Toast.makeText(getApplicationContext(),"Ejecuta",Toast.LENGTH_SHORT).show();
    }



}