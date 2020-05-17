package com.example.movilgram.ui;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.example.movilgram.R;
import com.example.movilgram.adapter.PagerAdapter;
import com.example.movilgram.ui.fragments.HomeFragment;
import com.example.movilgram.ui.fragments.SearchFragment;
import com.example.movilgram.ui.fragments.ShoppingCartFragment;
import com.example.movilgram.ui.login.LoginActivity;
import com.example.movilgram.ui.profile.ProfileActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;


public class ContainerActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;

    //es mejor declarar las variables por fuera de los métodos para que todos tengan acceso a esas variables
    // y se pueda tener mejor organizado el código
    BottomNavigationView bottomNavigationView;
    FrameLayout container;
    ViewPager viewPager;

    HomeFragment home;
    SearchFragment search;
    ShoppingCartFragment shoppingCartFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        navigationView = findViewById(R.id.navView);
        drawerLayout = findViewById(R.id.drawer_layout);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        container = findViewById(R.id.container);
        viewPager=findViewById(R.id.viewPager);

        //Aqui se declaran todos los fragments que se van a usar
        home = new HomeFragment();
        search = new SearchFragment();
        shoppingCartFragment = new ShoppingCartFragment();

        //llamar un recurso, en este caso string y se llama al string que se creo, el true para que se vea
        showToolbar(getResources().getString(R.string.tab_home), true);
        setNavView();
        setBottomNav();
        setUpViewPager(getPagerAdpater());

        //Con este método se le dice cual item del menú está seleccionado
        bottomNavigationView.setSelectedItemId(R.id.mn_home);
    }
//evento que muestra las opciones del menu, entre las cuales se puede navegar a sus respectivas fragments
    private void setNavView() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.menu_home:
                        break;

                    case R.id.menu_configuracion:
                        break;

                    case R.id.menu_user:
                        Intent profile = new Intent(getApplicationContext(), ProfileActivity.class);
                        startActivity(profile);
                        //setFragment(profile);
                        break;
                    case R.id.menu_salir:
                        Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                        startActivity(intent);
                        break;
                }

                invalidateOptionsMenu();
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    //Este método implementa el ClickListener e identifica cada fragment con el ID que se le dio en el menu
    private void setBottomNav() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.mn_home:
                        viewPager.setCurrentItem(0);
                        return true;
                    case R.id.mn_search:
                        viewPager.setCurrentItem(1);
                        return true;
                    case R.id.menu_cart:
                        viewPager.setCurrentItem(2);
                        return true;
                }
                return false;
            }
        });
    }

    public void showToolbar(String title, boolean upButton) { //recibe un titulo, la mayoria y algunos botones
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); //para que se vea bien en versiones anteriores
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);//en caso de que tenga boton para que se vea el upButton osea un boton arriba en la jerarquia
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    //Asignar el click de menu hamburguesa por defecto de android
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: //home
                //abre e menu lateral
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Instancia del pagerAdapter y añadir fragments a la lista
   public PagerAdapter getPagerAdpater(){
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        adapter.addFragment(home);
        adapter.addFragment(search);
        adapter.addFragment(shoppingCartFragment);
        return adapter;
   }

   //Asignar fragment de la lista a su posición en el bottom Nav
   public void setUpViewPager(PagerAdapter pagerAdapter){
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.mn_home).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.mn_search).setChecked(true);
                        break;
                    case 2:
                        bottomNavigationView.getMenu().findItem(R.id.menu_cart).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
   }
}


