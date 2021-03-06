package com.example.movilgram.ui.product;

import android.os.Build;
import android.os.Bundle;
import android.transition.Fade;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.movilgram.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;


public class ProductDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        showToolbar("",true);
        //definir transicion de entrada
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//validacion para que la transicion no explote
            getWindow().setEnterTransition(new Fade());

        }
    }

    public void showToolbar(String title, boolean upButton){ //recibe un titulo, la mayoria y algunos botones
        Toolbar toolbar =(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //para que se vea bien en versiones anteriores
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);//en caso de que tenga boton para que se vea el upButton osea un boton arriba en la jerarquia
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsingToolbar);
    }
}
