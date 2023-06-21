package com.example.loginbanco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Alterar extends AppCompatActivity {

    public static EditText nome_alterar, novo_nome, nova_senha, nova_idade;
    Button btn_voltar_atualizar, btn_atualizar;
    BD bd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar);

        iniciarComponentes();


    }
    public void atualizar(View v){
        boolean update = bd.alterar();
        if (update){
            Toast.makeText(Alterar.this, "Dados Alterados Com Sucesso", Toast.LENGTH_SHORT).show();
            Intent ir_main = new Intent(this, Main.class);
            startActivity(ir_main);
        }
        else {
            Toast.makeText(Alterar.this, "Algo Deu Merda", Toast.LENGTH_SHORT).show();
        }
    }
    public void voltar(View v){
        Intent ir_voltar = new Intent(this, Main.class);
        startActivity(ir_voltar);
    }

    private void iniciarComponentes() {
        novo_nome = findViewById(R.id.novo_nome);
        nova_senha = findViewById(R.id.nova_senha);
        nova_idade = findViewById(R.id.nova_idade);

        btn_atualizar = findViewById(R.id.btn_atualiza);
        btn_voltar_atualizar = findViewById(R.id.btn_voltar_atualizar);

        bd = new BD(this);
    }
}