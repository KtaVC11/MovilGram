package com.example.movilgram.view;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.movilgram.R;
import com.example.movilgram.view.fragments.HomeFragment;
import com.example.movilgram.view.fragments.ProfileFragment;
import com.example.movilgram.view.fragments.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class ContainerActivity extends AppCompatActivity {

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
}


