package com.example.a10uirecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorRecyclerView extends RecyclerView.Adapter<AdaptadorRecyclerView.ViewHolderDatos> {

    ArrayList<String> listaDatos;


    public AdaptadorRecyclerView(ArrayList<String> listaDatos) {
        this.listaDatos = listaDatos;
    }

    @NonNull
    @Override
    public AdaptadorRecyclerView.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.elementos_recycler,null,false);

        return new ViewHolderDatos(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorRecyclerView.ViewHolderDatos holder, int position) {
        holder.asignarDatos(listaDatos.get(position));
    }

    @Override
    public int getItemCount() {
        return listaDatos.size();
    }


    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView datos;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            datos = itemView.findViewById(R.id.txInformacion);
        }

        public void asignarDatos(String dato) {
            datos.setText(dato);
        }
    }
}
