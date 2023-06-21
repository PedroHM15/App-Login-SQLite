package com.example.loginbanco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class BD extends SQLiteOpenHelper{
    public BD(Context context){
        super(context, "login.bd", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table usuarios(nome varchar(255),idade int, senha varchar(50))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop Table If exists usuarios");
    }

    public boolean novoUser(String nome,Integer idade, String senha){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("nome", nome);
        contentValues.put("idade", idade);
        contentValues.put("senha", senha);

        long resultado = db.insert("usuarios", null, contentValues);

        if (resultado == -1){
            return false;
        }else{
            return true;
        }
    }
    public Cursor pegarInfo(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from usuarios", null);
        return cursor;
    }

    public boolean alterar(){
        String nome_editar = Main.nome_inicial.getText().toString();
        String novo_nome = Alterar.novo_nome.getText().toString();
        Integer nova_idade = Integer.valueOf(Alterar.nova_idade.getText().toString());
        String nova_senha = Alterar.nova_senha.getText().toString();


        try{
            SQLiteDatabase db = this.getWritableDatabase();
            String sql = "UPDATE usuarios SET nome=?, idade=?, senha=? WHERE nome=?";
            SQLiteStatement stmt = db.compileStatement(sql);
            stmt.bindString(4,nome_editar);
            stmt.bindString(1,novo_nome);
            stmt.bindLong(2,nova_idade);
            stmt.bindString(3,nova_senha);
            stmt.executeUpdateDelete();
            db.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        /**/

    }
    public boolean delet(){
        String novo_nome = Login.nome_login.getText().toString();
        String nova_senha = Login.senha_login.getText().toString();

        try{
            SQLiteDatabase db = this.getWritableDatabase();
            String sql = "Delete from usuarios WHERE nome=? and senha=?";
            SQLiteStatement stmt = db.compileStatement(sql);
            stmt.bindString(1,novo_nome);
            stmt.bindString(2,nova_senha);
            stmt.executeUpdateDelete();
            db.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
