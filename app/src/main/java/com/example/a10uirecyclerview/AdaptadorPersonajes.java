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
    OnItemClickListener onItemClickListener;

    public AdaptadorPersonajes(ArrayList<PersonajeVO> listaPersonajes, OnItemClickListener onItemClickListener) {
        this.listaPersonajes = listaPersonajes;
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    @NonNull
    @Override
    public ViewHolderPersonajes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_personajes,null,false);
        return new ViewHolderPersonajes(vista, onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolderPersonajes holder, final int position) {
        holder.tvNombre.setText(listaPersonajes.get(position).getNombre());
        holder.tvDescripcion.setText(listaPersonajes.get(position).getDescripcion());
        holder.ivFoto.setImageResource(listaPersonajes.get(position).getFoto());
    }

    @Override
    public int getItemCount() {
        return listaPersonajes.size();
    }


    public class ViewHolderPersonajes extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvNombre, tvDescripcion;
        ImageView ivFoto;
        OnItemClickListener onPersonajeListener;

        public ViewHolderPersonajes(@NonNull View itemView, OnItemClickListener onPersonajeListener) {
            super(itemView);

            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvDescripcion = itemView.findViewById(R.id.tvDescripcion);
            ivFoto = itemView.findViewById(R.id.ivFoto);
            this.onPersonajeListener = onPersonajeListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onPersonajeListener.onItemClick(getAdapterPosition());
        }
    }
}
