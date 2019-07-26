package com.example.a10uirecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> listaDatos;
    RecyclerView vistaRecycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vistaRecycler = findViewById(R.id.rvDiasSemana);
       // vistaRecycler.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        vistaRecycler.setLayoutManager(new GridLayoutManager(this, 1));

        listaDatos = new ArrayList<>();

        for (int i = 0; i <= 50; i++) {
            listaDatos.add("Dato " + i);
        }

        AdaptadorRecyclerView adaptadorRecyclerView = new AdaptadorRecyclerView(listaDatos);
        vistaRecycler.setAdapter(adaptadorRecyclerView);
    }
}
