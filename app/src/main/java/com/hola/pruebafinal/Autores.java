package com.hola.pruebafinal;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;


public class Autores extends Fragment {

    GridView autoresGrid;
    String[] nombres ={"Darlis ","Marissa ","Lily ","Kiera ","Becca ","Julio", "George", "J.K"};
    String[] apellido = {"Stefany","Meyer","del Pilar","Cass","Fitzpatrick","Verne", "Orwell", "Rowling"};
    int[] images ={R.drawable.darlis, R.drawable.marissa,R.drawable.lily,R.drawable.kiera3,R.drawable.becca2,R.drawable.verne2, R.drawable.george, R.drawable.jkrowling, R.drawable.jkrowling};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista= inflater.inflate(R.layout.fragment_autores, container, false);

        autoresGrid = (GridView) vista.findViewById(R.id.gridAutores);
        autoresGrid.setAdapter(new CustomAdaper(nombres, apellido,images, getContext()));


        return vista;
    }

    public class CustomAdaper extends BaseAdapter {

        private String[] imagesName;
        private String[] apellido;
        private int[] imagenesFoto;
        private Context context;
        private LayoutInflater layoutInflater;

        public CustomAdaper(String[] imagesName, String[] apellidom, int[] imagenesFoto, Context context) {
            this.imagesName = imagesName;
            this.apellido = apellidom;
            this.imagenesFoto = imagenesFoto;
            this.context = context;
            this.layoutInflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return imagenesFoto.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            if(view == null){
                view = layoutInflater.inflate(R.layout.cardview_autores, viewGroup,false);


            }

            TextView Name = view.findViewById(R.id.txtNombre);
            TextView Ape = view.findViewById(R.id.txtApellido);
            ImageView imageView = view.findViewById(R.id.img1);

            Name.setText(imagesName[i]);
            Ape.setText(apellido[i]);
            imageView.setImageResource(imagenesFoto[i]);


            return view;
        }
    }


}