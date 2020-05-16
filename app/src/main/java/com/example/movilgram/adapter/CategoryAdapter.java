package com.example.movilgram.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movilgram.R;
import com.example.movilgram.model.Category;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoriaViewHolder> {
    //recibe lista del modelo
    private ArrayList<Category> categorias;

    public CategoryAdapter(ArrayList<Category> categorias) {
        this.categorias = categorias;
    }

    @NonNull
    @Override
    public CategoriaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_search,parent,false);
        return  new CategoriaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriaViewHolder holder, int position) {
        //enlaza el viewHolder con el modelo
        Category categoria = categorias.get(position);
        holder.textoCategoria.setText(categoria.getNombre());
        holder.imagenCategoria.setImageResource(categoria.getImagen());


    }

    @Override
    public int getItemCount() {

        return categorias.size();
    }

    public class CategoriaViewHolder extends RecyclerView.ViewHolder {
        TextView textoCategoria;
        ImageView imagenCategoria;



        public CategoriaViewHolder(@NonNull View itemView) {

            super(itemView);
            //esto es el viewHolder
            textoCategoria = itemView.findViewById(R.id.txtCategory);
            imagenCategoria = itemView.findViewById(R.id.pictureCategory);
        }
    }
}
