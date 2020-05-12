package com.example.movilgram.view;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.movilgram.R;
import com.example.movilgram.view.fragments.HomeFragment;
import com.example.movilgram.view.fragments.ProfileFragment;
import com.example.movilgram.view.fragments.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class ContainerActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;

    //es mejor declarar las variables por fuera de los métodos para que todos tengan acceso a esas variables
    // y se pueda tener mejor organizado el código
    BottomNavigationView bottomNavigationView;
    FrameLayout container;

    HomeFragment home;
    ProfileFragment profile;
    SearchFragment search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        drawerLayout= (DrawerLayout) findViewById(R.id.drawer_layout);
        showToolbar(getResources().getString(R.string.tab_home),true);//llamar un recurso, en este caso string y se llama al string que se creo, el true para que se vea

        //Aqui se declaran todos los fragments que se van a usar
        home = new HomeFragment();
        profile = new ProfileFragment();
        search = new SearchFragment();

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        container = findViewById(R.id.container);

        //Este método se inicia al iniciar el activity
        setBottomNav();

        //Aqui se le dice al container que fragment cargar al momento de iniciar el activity
        setFragment(home);

        //Con este método se le dice cual item del menú está seleccionado
        bottomNavigationView.setSelectedItemId(R.id.home);
    }

    //Este método implementa el ClickListener e identifica cada fragment con el ID que se le dio en el menu
    private void setBottomNav() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.home:
                        //Aquí se llama al método para que relacione el container con el fragment
                        setFragment(home);
                        return true;
                    case R.id.search:
                        setFragment(search);
                        return true;
                    case R.id.profile:
                        setFragment(profile);
                        return true;
                }
                return false;
            }
        });
    }

    //Este método le dice al container que fragment colocar dentro de ese contenedor
    private void setFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }

    public void showToolbar(String title,boolean upButton){ //recibe un titulo, la mayoria y algunos botones
        Toolbar toolbar =(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); //para que se vea bien en versiones anteriores
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);//en caso de que tenga boton para que se vea el upButton osea un boton arriba en la jerarquia
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home: //home
                //abre e menu lateral
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}


