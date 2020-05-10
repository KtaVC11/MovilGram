package com.example.movilgram.view.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.movilgram.R;
import com.example.movilgram.adapter.PictureAdapterRecyclerView;
import com.example.movilgram.model.Picture;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) { //debe mostrar el toolbar, el recyclerView
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        showToolbar(getResources().getString(R.string.tab_home),false,view);

        RecyclerView picturesRecycler = (RecyclerView) view.findViewById(R.id.pictureRecycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);//genera la lista vertical

        picturesRecycler.setLayoutManager(linearLayoutManager);
        PictureAdapterRecyclerView pictureAdapterRecyclerView = new PictureAdapterRecyclerView(buildPictures(),R.layout.cardview_picture,getActivity());
        picturesRecycler.setAdapter(pictureAdapterRecyclerView);
        return view;
    }

    public ArrayList<Picture> buildPictures(){
        ArrayList<Picture> pictures = new ArrayList<>();
        pictures.add(new Picture(R.drawable.descarga,"Katalina Viquez","4 dias" ,"3 Me Gusta"));
        pictures.add(new Picture(R.drawable.mountain,"Melany Monge","3 dias" ,"10 Me Gusta"));
        pictures.add(new Picture(R.drawable.future_city,"Uriel Ramirez","2 dias" ,"9 Me Gusta"));
    return pictures;
    }


    public void showToolbar(String title,boolean upButton,View view){ //recibe un titulo, la mayoria y algunos botones
        Toolbar toolbar =(Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
         //para que se vea bien en versiones anteriores
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);//en caso de que tenga boton para que se vea el upButton osea un boton arriba en la jerarquia
    }
}
