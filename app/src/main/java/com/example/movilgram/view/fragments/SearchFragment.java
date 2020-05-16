package com.example.movilgram.view.fragments;

import android.icu.text.CaseMap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.movilgram.R;
import com.example.movilgram.adapter.CategoryAdapter;
import com.example.movilgram.model.Category;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {
    RecyclerView recyclerView;

    CategoryAdapter categoryAdapter;

    public SearchFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_search, container, false); // Inflate the layout for this fragment
        recyclerView = root.findViewById(R.id.categotyRecycler);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getContext());
                //layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        categoryAdapter = new CategoryAdapter(buildCategories());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(categoryAdapter);


       return root;



    }

    private ArrayList<Category> buildCategories(){
        ArrayList<Category> categorias = new ArrayList<>();

        categorias.add(new Category("Autos",R.drawable.auto2));
        categorias.add(new Category("Motocicletas",R.drawable.auto2));
        categorias.add(new Category("Bicicletas",R.drawable.auto2));
        return categorias;

    }

}



