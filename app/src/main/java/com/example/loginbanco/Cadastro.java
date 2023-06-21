package com.example.loginbanco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Cadastro extends AppCompatActivity {
    EditText nome_cadastrar, senha_cadastrar, idade_cadastrar;
    Button btn_cad, btn_voltar;

    BD bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        iniciarComponentes();

        btn_cad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textNome = nome_cadastrar.getText().toString();
                String textSenha = senha_cadastrar.getText().toString();
                Integer textIdade = Integer.valueOf(idade_cadastrar.getText().toString());

                boolean retorno = bd.novoUser(textNome, textIdade, textSenha);

                if(retorno){
                    Toast.makeText(Cadastro.this, "Usuario Cadastrado", Toast.LENGTH_SHORT).show();
                    Intent ir_inicio = new Intent(Cadastro.this, Main.class);
                    startActivity(ir_inicio);
                }else{
                    Toast.makeText(Cadastro.this, "Deu Merda", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }


    public void voltar(View v){
        Intent ir_inicio = new Intent(this, Main.class);
        startActivity(ir_inicio);
    }

    private void iniciarComponentes() {
        nome_cadastrar = findViewById(R.id.nome_cadastro);
        senha_cadastrar = findViewById(R.id.senha_cadastro);
        idade_cadastrar = findViewById(R.id.idade_cadastro);
        btn_cad = findViewById(R.id.btn_cad);
        btn_voltar = findViewById(R.id.btn_voltar);

        bd = new BD(this);
    }
}