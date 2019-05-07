package com.talessa.food2fork.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.talessa.food2fork.GlideApp;
import com.talessa.food2fork.R;
import com.talessa.food2fork.model.Receta;

import java.util.ArrayList;
import java.util.List;

public class RecetaListAdapter extends RecyclerView.Adapter<RecetaListAdapter.RecetaListViewHolder> {
    public List<Receta> recetaList = new ArrayList<>();

    public RecetaListAdapter.RecetaListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_receta,parent,false);
        return new RecetaListViewHolder(view);
    }

    public void onBindViewHolder(@NonNull RecetaListViewHolder holder,int position){
        Receta receta = recetaList.get(position);

        holder.id.setText(""+receta.recipe_id);
        holder.titulo.setText(receta.title);
        holder.ranquing.setText(""+receta.social_rank);
        GlideApp.with(holder.itemView.getContext()).load(receta.image_url.replace("http://", "https://")).into(holder.imagenReceta);
        holder.web.setText(receta.source_url);
    }
    public int getItemCount(){
        return recetaList.size();
    }

    class RecetaListViewHolder extends RecyclerView.ViewHolder {
        TextView id;
        TextView titulo;
        TextView ranquing;
        ImageView imagenReceta;
        TextView web;

        public RecetaListViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.recetaId);
            titulo = itemView.findViewById(R.id.recetaTitulo);
            ranquing = itemView.findViewById(R.id.recetaRanquing);
            imagenReceta = itemView.findViewById(R.id.recetaImage);
            web = itemView.findViewById(R.id.recetaweb);
        }
    }
}
