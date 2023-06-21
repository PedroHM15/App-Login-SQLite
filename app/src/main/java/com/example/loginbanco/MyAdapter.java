package com.example.loginbanco;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private ArrayList nome_id, idade_id;

    public MyAdapter(Context context, ArrayList nome_id, ArrayList idade_id) {
        this.context = context;
        this.nome_id = nome_id;
        this.idade_id = idade_id;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.listar,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nome_id.setText(String.valueOf(nome_id.get(position)));
        holder.idade_id.setText(String.valueOf(idade_id.get(position)));
    }

    @Override
    public int getItemCount() {
        return nome_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nome_id, idade_id;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nome_id = itemView.findViewById(R.id.nome_listar);
            idade_id = itemView.findViewById(R.id.idade_listar);
        }
    }
}
