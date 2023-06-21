package com.example.loginbanco;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class ListarUsuarios extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<String> nome, idade;
    BD bd;
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_usuarios);

        bd = new BD(this);
        nome = new ArrayList<>();
        idade = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new MyAdapter(this, nome, idade);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displaydata();


    }

    private void displaydata() {
        Cursor cursor = bd.pegarInfo();
        if (cursor.getCount()==0){
            Toast.makeText(ListarUsuarios.this,"Deu Merdaaaaaa", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            while(cursor.moveToNext()){
                nome.add("Nome: "+cursor.getString(0));
                idade.add("Idade: "+cursor.getString(1));

            }
        }
    }

}