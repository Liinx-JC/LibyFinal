package com.hola.pruebafinal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.hola.pruebafinal.Datos.Libros;
import com.hola.pruebafinal.Datos.LibrosAdapter;

import java.util.ArrayList;


public class ListaLibros extends Fragment implements SearchView.OnQueryTextListener{

    SearchView buscar2;
    RecyclerView recyclerLibro;
    ArrayList<Libros> saga;
    LibrosAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        saga = new ArrayList<>();
        View vista= inflater.inflate(R.layout.fragment_lista_libros, container, false);
        //relacionamos el recyclerview por su id
        recyclerLibro = (RecyclerView) vista.findViewById(R.id.recyclerLibro);
        //relacionamos el searchView por su id
        buscar2=(SearchView) vista.findViewById(R.id.filtrado);
        recyclerLibro.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new LibrosAdapter(saga,getContext());
        recyclerLibro.setAdapter(adapter);
        //declaramos el metodo
        cinder();
        buscar2.setOnQueryTextListener(this);
        return vista;
    }

    //Declaramos los atributos que se mostraran en la lista
    public void cinder(){
        saga.add(new Libros(R.drawable.ic_launcher_background,"La Seleccion", "Kiera Cass"));
        saga.add(new Libros(R.drawable.ic_launcher_background,"Cinder", "Marissa Meyer"));
        saga.add(new Libros(R.drawable.ic_launcher_background,"Hush hush", "Kiera Cass"));
        saga.add(new Libros(R.drawable.ic_launcher_background,"Maze Runner", "Kiera Cass"));
        saga.add(new Libros(R.drawable.ic_launcher_background,"Cress", "Marissa Meyer"));
    }

    //metodos despues de implementar SearchView.OnQueryTextListener en la clase

    @Override
    public boolean onQueryTextSubmit(String s) {
        adapter.filtrado2(s);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {

        return false;
    }
}