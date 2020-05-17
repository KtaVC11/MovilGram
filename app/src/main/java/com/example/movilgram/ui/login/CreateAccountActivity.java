package com.example.movilgram.ui.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.movilgram.R;

public class CreateAccountActivity extends AppCompatActivity {
    Button createAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        createAccount = findViewById(R.id.joinUs);
        showToolbar(getResources().getString(R.string.toolbar_title_createaccount), true);//llamar un recurso, en este caso string y se llama al string que se creo, el true para que se vea
        createAccount.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(), "Cuenta creada", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void showToolbar(String title, boolean upButton) { //recibe un titulo, la mayoria y algunos botones
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); //para que se vea bien en versiones anteriores
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);//en caso de que tenga boton para que se vea el upButton osea un boton arriba en la jerarquia
    }

}
