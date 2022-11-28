package com.hola.pruebafinal;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SearchView;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.hola.pruebafinal.Datos.Libreria;
import com.hola.pruebafinal.Datos.LibreriaAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListaLibreria extends Fragment implements SearchView.OnQueryTextListener{

    SearchView buscar;
    RecyclerView recyclerLibreria;
    List<Libreria> libre = new ArrayList<>();
    LibreriaAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista= inflater.inflate(R.layout.fragment_lista_libreria, container, false);
        //relacionamos el recyclerview por su id
        recyclerLibreria = (RecyclerView) vista.findViewById(R.id.recyclerId);
        recyclerLibreria.setLayoutManager(new LinearLayoutManager(getContext()));
        buscar=(SearchView) vista.findViewById(R.id.filtro);
        buscar.setOnQueryTextListener(this);


        FirebaseApp.initializeApp(getContext());
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference();


        libre.clear();
        databaseReference.child("Libreria").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot objetodata : snapshot.getChildren()){
                    Libreria p = snapshot.getValue(Libreria.class);
                    libre.add(p);
                }
                adapter = new LibreriaAdapter(libre, getContext());
                recyclerLibreria.setAdapter(adapter);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });


        //init();
        return vista;
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        adapter.filtrado(s);
        return false;
    }

    /*private void init() {
        FirebaseApp.initializeApp(getContext());
        //FirebaseDatabase database;
        //DatabaseReference databaseReference;

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference("Libreria");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                libre.clear();
                for(DataSnapshot objetodata : snapshot.getChildren()){
                    Libreria p = snapshot.getValue(Libreria.class);
                    libre.add(p);

                }

                adapter = new LibreriaAdapter(libre, getContext());
                recyclerLibreria.setAdapter(adapter);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        });

    }*/

}