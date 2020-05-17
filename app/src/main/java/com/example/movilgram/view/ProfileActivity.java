package com.example.movilgram.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.movilgram.R;
import com.example.movilgram.adapter.AutoAdapterRecyclerView;
import com.example.movilgram.model.Auto;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profile);

        showToolbar("",true); //no se necesita titulo, tampoco regresar,pasa al view

        RecyclerView picturesRecycler = (RecyclerView) findViewById(R.id.pictureProfileRecycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);//genera la lista vertical

        picturesRecycler.setLayoutManager(linearLayoutManager);
        AutoAdapterRecyclerView pictureAdapterRecyclerView = new AutoAdapterRecyclerView(buildPictures(),R.layout.cardview_picture,this);
        picturesRecycler.setAdapter(pictureAdapterRecyclerView);

    }

    public ArrayList<Auto> buildPictures(){
        ArrayList<Auto> pictures = new ArrayList<>();
        pictures.add(new Auto(R.drawable.auto2,"Audi","4 dias" ,"3 Me Gusta"));
        pictures.add(new Auto(R.drawable.auto6,"Volvo","3 dias" ,"10 Me Gusta"));
        pictures.add(new Auto(R.drawable.auto7,"Audi","2 dias" ,"9 Me Gusta"));
        return pictures;
    }

    public void showToolbar(String title, boolean upButton){ //recibe un titulo, la mayoria y algunos botones
        Toolbar toolbar =(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //para que se vea bien en versiones anteriores
      getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);//en caso de que tenga boton para que se vea el upButton osea un boton arriba en la jerarquia
    }
}
