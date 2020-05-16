package com.example.movilgram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.movilgram.view.ContainerActivity;
import com.example.movilgram.view.CreateAccountActivity;

public class LoginActivity extends AppCompatActivity {
    EditText usuario;
    EditText contasenia;
    Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usuario=findViewById(R.id.username);
        contasenia=findViewById(R.id.password);
        login= findViewById(R.id.login);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = usuario.getText().toString();
                String pass = contasenia.getText().toString();
                if(user.isEmpty()&& pass.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Campos vacios", Toast.LENGTH_LONG).show();
                }else{
                    goContainer();
                }
            }
        });

    }

    public void goCreateAccount(View view){
        Intent intent = new Intent(this, CreateAccountActivity.class);
        startActivity(intent);
    }

    public void goContainer(){
        Intent intent = new Intent(this, ContainerActivity.class);
        startActivity(intent);
    }
}
