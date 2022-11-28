package com.hola.pruebafinal.Datos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hola.pruebafinal.R;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LibrosAdapter extends RecyclerView.Adapter<LibrosAdapter.ViewHolder>{

    private List<Libros> mData;
    //declaramos una segunda array que se utilizara para el filtrado
    ArrayList<Libros> listado2;
    private LayoutInflater mInflater;
    private Context context;

    public LibrosAdapter(List<Libros> lista, Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context= context;
        this.mData = lista;
        listado2 = new ArrayList<>();
        listado2.addAll(mData);
    }

    @Override
    public int getItemCount() { return mData.size();  }

    @NonNull
    @Override
    public LibrosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.cardview_libros, null);
        return new LibrosAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LibrosAdapter.ViewHolder holder, int pos1) {
        holder.img1.setImageResource(mData.get(pos1).getImg());
        holder.nom_libro.setText(mData.get(pos1).getNom_libro());
        holder.autor.setText(mData.get(pos1).getAutor());
    }

    //Metodo utilizado para filtrar por el nombre del libro, sin importar si son minusculas o mayusculas
    public void filtrado2(final String buscar){
        int longitud = buscar.length();
        if(longitud == 0){
            mData.clear();
            mData.addAll(listado2);
        }else{
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                List<Libros> collecion = mData.stream().filter(i -> i.getNom_libro().toLowerCase().contains(buscar.toLowerCase())).collect(Collectors.toList());
                mData.clear();
                mData.addAll(collecion);
            }else{
                for(Libros l: listado2){
                    if(l.getNom_libro().toLowerCase().contains(buscar.toLowerCase())){
                        mData.add(l);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }

    public void setItems(List<Libros> items){mData= items;}

    public class ViewHolder extends  RecyclerView.ViewHolder {
        TextView nom_libro, autor;
        ImageView img1;

        ViewHolder(View itemView) {
            super(itemView);
            img1 = itemView.findViewById(R.id.img1);
            nom_libro = itemView.findViewById(R.id.txtnom_libro);
            autor = itemView.findViewById(R.id.txtautor);

        }

        public void bindData(Libros item) {
            nom_libro.setText(item.getNom_libro());
            autor.setText(item.getAutor());


        }

    }
}
