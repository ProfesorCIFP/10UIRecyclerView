package com.example.a10uirecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorPersonajes extends RecyclerView.Adapter<AdaptadorPersonajes.ViewHolderPersonajes> {

    ArrayList<PersonajeVO> listaPersonajes;

    public AdaptadorPersonajes(ArrayList<PersonajeVO> listaPersonajes) {
        this.listaPersonajes = listaPersonajes;
    }

    @NonNull
    @Override
    public ViewHolderPersonajes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_personajes,null,false);
        return new ViewHolderPersonajes(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPersonajes holder, int position) {
        holder.tvNombre.setText(listaPersonajes.get(position).getNombre());
        holder.tvDescripcion.setText(listaPersonajes.get(position).getDescripcion());
        holder.ivFoto.setImageResource(listaPersonajes.get(position).getFoto());
    }

    @Override
    public int getItemCount() {
        return listaPersonajes.size();
    }

    public class ViewHolderPersonajes extends RecyclerView.ViewHolder {
        TextView tvNombre, tvDescripcion;
        ImageView ivFoto;

        public ViewHolderPersonajes(@NonNull View itemView) {
            super(itemView);

            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvDescripcion = itemView.findViewById(R.id.tvDescripcion);
            ivFoto = itemView.findViewById(R.id.ivFoto);

        }
    }
}
