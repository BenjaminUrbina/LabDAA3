package com.example.pruebasbd;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListaContrasAdaptador extends RecyclerView.Adapter<ListaContrasAdaptador.ContactoViewHolder> {

    ArrayList<ExtraccionRegistros> ListaContras;
    public ListaContrasAdaptador(ArrayList<ExtraccionRegistros> ListaContras){
        this.ListaContras = ListaContras;
    }

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { //Diseño elemento lista
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_contras, null,false);
        return new ContactoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder holder, int position) {
        holder.plataforma.setText(ListaContras.get(position).getPlataforma());
        holder.contrasena.setText(ListaContras.get(position).getContrasenas());
    }

    @Override
    public int getItemCount() {
        return ListaContras.size();
    }

    public class ContactoViewHolder extends RecyclerView.ViewHolder {
        TextView plataforma,contrasena;
        public ContactoViewHolder(@NonNull View itemView) {
            super(itemView);
            plataforma = itemView.findViewById(R.id.platafo);
            contrasena = itemView.findViewById(R.id.contra);
        }
    }
}
