package com.example.loginbanco;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    public static TextView nome_login, senha_login, idade_login;
    Button btn_voltar_login;

    BD bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        iniciarComponentes();

        String textNome = Main.nome_inicial.getText().toString();
        String textSenha = Main.senha_inicial.getText().toString();
        Cursor dados = bd.pegarInfo();
    int i=0;
        while (dados.moveToNext()){
            if (dados.getString(0).equals(textNome) && dados.getString(2).equals(textSenha)){
                String textIdade = dados.getString(1);
                nome_login.setText(textNome);
                senha_login.setText(textSenha);
                idade_login.setText(textIdade);
                i=1;
            }
        }
        if (i==0){
            Toast.makeText(this, "Usuario não encontrado", Toast.LENGTH_SHORT).show();
            Intent ir_main = new Intent(this, Main.class);
            startActivity(ir_main);
        }

    }

    public void voltar(View v){
        Intent ir_voltar = new Intent(this, Main.class);
        startActivity(ir_voltar);
    }

    public void atualizar(View v){
        Intent ir_atualizar = new Intent(this, Alterar.class);
        startActivity(ir_atualizar);
    }

    public void deletar(View v){
        boolean resultado = bd.delet();
        if (resultado){
            Toast.makeText(Login.this, "Usuario Deletado", Toast.LENGTH_SHORT).show();
            Intent ir_main = new Intent(this, Main.class);
            startActivity(ir_main);
        }
        else{
            Toast.makeText(Login.this, "Algo Deu Merda", Toast.LENGTH_SHORT).show();
        }
    }

    private void iniciarComponentes() {
        nome_login = findViewById(R.id.nome_login);
        senha_login = findViewById(R.id.senha_login);
        idade_login = findViewById(R.id.idade_login);

        btn_voltar_login = findViewById(R.id.btn_voltar_login);

        bd = new BD(this);
    }
}