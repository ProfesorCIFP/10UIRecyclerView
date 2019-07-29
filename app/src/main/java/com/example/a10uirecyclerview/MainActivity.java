package com.example.a10uirecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.DialogTitle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main Activity";

    ArrayList<PersonajeVO> listaPersonajes;
    RecyclerView recyclerPersonajes;
    TextView tvSeleccion;
    Button btnList, btnGrid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerPersonajes = findViewById(R.id.rvPersonajes);

        tvSeleccion = findViewById(R.id.tvSeleccion);
        btnList = findViewById(R.id.btnList);
        btnGrid = findViewById(R.id.btnGrid);

        construirRecycler();
    }

    private void llenarPersonajes() {
        listaPersonajes.add(new PersonajeVO("Krusty","Herschel Shmoikel Pinkus Yerocham Krustofsky, conocido como Krusty el payaso, es un personaje de la serie de dibujos animados Los Simpson.",R.drawable.krusti));
        listaPersonajes.add(new PersonajeVO("Homero","Homer Jay Simpson es uno de los protagonistas de la serie. Es el padre de la familia protagonista y uno de los personajes centrales y más importantes de la serie.",R.drawable.homero));
        listaPersonajes.add(new PersonajeVO("Marge","Marjorie \"Marge\" Bouvier Simpson una de los protagonistas de la serie. Es la esposa de Homer Simpson y madre de los tres hijos que ha tenido de esta unión amorosa: Bart, Lisa y Maggie. ",R.drawable.marge));
        listaPersonajes.add(new PersonajeVO("Bart","Bartholomew JoJo «Bart» Simpson, es uno de los protagonistas de la serie. Bart tiene 10 años y es el primogénito, y único hijo varón de Homer y Marge Simpson. ",R.drawable.bart));
        listaPersonajes.add(new PersonajeVO("Lisa","Lisa Marie Simpson es una de las protagonistas de la serie. Es la hija mediana de Homer y Marge Simpson, y hermana de Bart y Maggie. Goza de notable protagonismo y complejidad en la serie.",R.drawable.lisa));
        listaPersonajes.add(new PersonajeVO("Magie","Margaret Evelyn \"Maggie\" Simpson es una de las protagonistas de la serie. Es la tercera hija del matrimonio protagonista, Homer y Marge Simpson, y la más joven de ellos.",R.drawable.magie));
        listaPersonajes.add(new PersonajeVO("Flanders","Nedward «Ned» Flanders es un personaje ficticio de la serie de televisión de dibujos animados Los Simpson. La voz original en inglés es de Harry Shearer.",R.drawable.flanders));
        listaPersonajes.add(new PersonajeVO("Milhouse","Milhouse Mussolini Van Houten es un personaje ficticio de la serie animada Los Simpson, creado por Matt Groening.",R.drawable.milhouse));
        listaPersonajes.add(new PersonajeVO("Mr. Burns","Charles Montgomery Burns, más conocido como el señor Burns o Monty Burns, es un personaje ficticio recurrente de la serie de televisión de dibujos animados Los Simpson, creada por Matt Groening.",R.drawable.burns));
    }

    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnList:
                Utilidades.visualizacion = Utilidades.LIST;
                break;

            case R.id.btnGrid:
                Utilidades.visualizacion = Utilidades.GRID;
                break;
        }

        construirRecycler();
    }

    private void construirRecycler() {
        listaPersonajes = new ArrayList<>();

        if (Utilidades.visualizacion == Utilidades.LIST) {
           // recyclerPersonajes.setLayoutManager(new LinearLayoutManager(this));
            recyclerPersonajes.setLayoutManager(new GridLayoutManager(this, 1));
        } else {
            recyclerPersonajes.setLayoutManager(new GridLayoutManager(this, 3));
        }


        llenarPersonajes();

        final AdaptadorPersonajes adaptadorPersonajes = new AdaptadorPersonajes(listaPersonajes);
        recyclerPersonajes.setAdapter(adaptadorPersonajes);

        adaptadorPersonajes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PersonajeVO personaje = listaPersonajes.get(recyclerPersonajes.getChildAdapterPosition(view));

                tvSeleccion.setText("Seleccionado: " + personaje.getNombre());
            }
        });
    }
}
