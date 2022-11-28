package com.hola.pruebafinal.Datos;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hola.pruebafinal.ListaLibreria;
import com.hola.pruebafinal.R;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LibreriaAdapter extends RecyclerView.Adapter<LibreriaAdapter.ViewHolder>{


    public List<Libreria> mData;
    //declaramos una segunda array que se utilizara para el filtrado
    ArrayList<Libreria> listado;
    private LayoutInflater mInflater;
    private Context context;


    public LibreriaAdapter(List<Libreria> itemList, Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context= context;
        this.mData = itemList;
        //listado = new ArrayList<>();
        //listado.addAll(mData);
    }

    @Override
    public int getItemCount() { return mData.size(); }

    @NonNull
    @Override
    public LibreriaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_librerias, null, false);
        return new LibreriaAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LibreriaAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(mData.get(position).getImg()).into(holder.img1);
        holder.nombre.setText(mData.get(position).getNombre());
        holder.numero.setText(mData.get(position).getFono());
        holder.email.setText(mData.get(position).getPag_web());
    }

    public void filtrado(final String buscar){
        int longitud = buscar.length();
        if(longitud == 0){
            mData.clear();
            mData.addAll(listado);
        }else{
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                List<Libreria> collecion = mData.stream().filter(i -> i.getNombre().toLowerCase().contains(buscar.toLowerCase())).collect(Collectors.toList());
                mData.clear();
                mData.addAll(collecion);
            }else{
                for(Libreria l: listado){
                    if(l.getNombre().toLowerCase().contains(buscar.toLowerCase())){
                        mData.add(l);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }

    public void setItems(List<Libreria> items){mData= items;}

    public class ViewHolder extends  RecyclerView.ViewHolder {
        TextView nombre, numero, email;
        ImageView img1;

        ViewHolder(View itemView) {
            super(itemView);
            img1 = itemView.findViewById(R.id.img1);
            nombre = itemView.findViewById(R.id.txtNombre);
            numero = itemView.findViewById(R.id.txtnumero);
            email = itemView.findViewById(R.id.txtEmail);


        }

        public void bindData(Libreria item) {
            img1.setImageResource(item.getImg());
            nombre.setText(item.getNombre());
            numero.setText(item.getFono());
            email.setText(item.getPag_web());

        }
    }
}
