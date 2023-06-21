package com.example.loginbanco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Main extends AppCompatActivity {
    public static EditText nome_inicial, senha_inicial;
    CheckBox mostrar_senha;
    Button btn_login, btn_cadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciarComponentes();

    }
    public void m_senha(View v){
        if (mostrar_senha.isChecked()){
            senha_inicial.setInputType(1);
        }
        else{
            senha_inicial.setInputType(129);
        }
    }
    public void login(View v){
        Intent ir_login = new Intent(this, Login.class);
        startActivity(ir_login);
    }
    public void cadastro(View v){
        Intent ir_cadastro = new Intent(this, Cadastro.class);
        startActivity(ir_cadastro);
    }
    public void listar(View v){
        Intent ir_listar = new Intent(this, ListarUsuarios.class);
        startActivity(ir_listar);
    }


    private void iniciarComponentes() {
        nome_inicial = findViewById(R.id.nome_inicial);
        senha_inicial = findViewById(R.id.senha_inicial);
        mostrar_senha = findViewById(R.id.mostrar_senha);
        btn_cadastro = findViewById(R.id.btn_cadastro);
        btn_login = findViewById(R.id.btn_login);
    }
}