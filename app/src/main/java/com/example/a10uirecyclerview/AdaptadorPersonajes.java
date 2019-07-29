package com.example.a10uirecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorPersonajes extends RecyclerView.Adapter<AdaptadorPersonajes.ViewHolderPersonajes>
                                 implements View.OnClickListener {

    ArrayList<PersonajeVO> listaPersonajes;
    private View.OnClickListener listener;

    public AdaptadorPersonajes(ArrayList<PersonajeVO> listaPersonajes) {
        this.listaPersonajes = listaPersonajes;
    }

    @Override
    public void onClick(View view) {
        if (listener != null) {
            listener.onClick(view);
        }
    }

    public void setOnClickListener (View.OnClickListener listener) {
        this.listener = listener;
    }


    @NonNull
    @Override
    public ViewHolderPersonajes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layout = 0;

        if (Utilidades.visualizacion == Utilidades.LIST)
            layout = R.layout.item_list_personajes;
        else
            layout = R.layout.item_grid_personajes;

        View vista = LayoutInflater.from(parent.getContext()).inflate(layout,null,false);
        vista.setOnClickListener(this);

        return new ViewHolderPersonajes(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolderPersonajes holder, final int position) {
        holder.tvNombre.setText(listaPersonajes.get(position).getNombre());
        holder.ivFoto.setImageResource(listaPersonajes.get(position).getFoto());
        if (Utilidades.visualizacion == Utilidades.LIST)
            holder.tvDescripcion.setText(listaPersonajes.get(position).getDescripcion());
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
            ivFoto = itemView.findViewById(R.id.ivFoto);
            if (Utilidades.visualizacion == Utilidades.LIST)
                tvDescripcion = itemView.findViewById(R.id.tvDescripcion);
        }
    }
}
