package com.example.myapplication2.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication2.R;
import com.example.myapplication2.model.Registro;

import java.util.List;

public class RegistroAdapter extends RecyclerView.Adapter<RegistroAdapter.myViewHolder>{

    private List<Registro> listRegistro;

    public RegistroAdapter(List<Registro> lista ) {
        this.listRegistro = lista;

    }


    @Override
    public myViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                                                .inflate(R.layout.lista_registro_adapter, parent, false);


        return new myViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder( myViewHolder holder, int position) {

        Registro registro = listRegistro.get(position);
        holder.registro.setText(registro.getNomeRegistro() );

    }

    @Override
    public int getItemCount() {
        return this.listRegistro.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder{

            TextView registro;

        public myViewHolder( View itemView) {
            super(itemView);

            registro = itemView.findViewById(R.id.textRegistro);

        }
    }

}
