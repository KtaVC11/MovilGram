package com.example.movilgram.View;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.movilgram.R;
import com.example.movilgram.View.fragments.HomeFragment;
import com.example.movilgram.View.fragments.ProfileFragment;
import com.example.movilgram.View.fragments.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        BottomNavigationView bottomNavigationView= findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItem(R.id.tabHome);
        bottomNavigationView.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {

                switch (tabId) {
                    case R.id.home:
                        HomeFragment homeFragment = new HomeFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment) //donde quiero insertar el fragment,homeFragment es el objeto
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null).commit();//para no tener problemas al regresar
                        break;
                    case R.id.profile:
                        ProfileFragment profileFragment = new ProfileFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, profileFragment) //donde quiero insertar el fragment,homeFragment es el objeto
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null).commit();//para no tener problemas al regresar
                        break;
                    case R.id.search:
                        SearchFragment searchFragment = new SearchFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, searchFragment) //donde quiero insertar el fragment,homeFragment es el objeto
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null).commit();//para no tener problemas al regresar
                        break;
                }
            }
        });
    }
}
