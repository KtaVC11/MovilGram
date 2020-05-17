package com.example.movilgram.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movilgram.R;
import com.example.movilgram.adapter.AutoAdapterRecyclerView;
import com.example.movilgram.model.Auto;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);

        RecyclerView picturesRecycler = view.findViewById(R.id.pictureRecycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);//genera la lista vertical

        picturesRecycler.setLayoutManager(linearLayoutManager);
        AutoAdapterRecyclerView pictureAdapterRecyclerView = new AutoAdapterRecyclerView(buildPictures(),R.layout.cardview_product,getActivity());
        picturesRecycler.setAdapter(pictureAdapterRecyclerView);
        return view;
    }

    public ArrayList<Auto> buildPictures(){
        ArrayList<Auto> pictures = new ArrayList<>();
        pictures.add(new Auto(R.drawable.auto2,"Audi","4 dias" ,"3 Me Gusta"));
        pictures.add(new Auto(R.drawable.auto6,"Volvo","3 dias" ,"10 Me Gusta"));
        pictures.add(new Auto(R.drawable.auto7,"Audi","2 dias" ,"9 Me Gusta"));
    return pictures;
    }
}
