package com.example.myapplication2.acticity;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.myapplication2.R;
import com.example.myapplication2.adapter.RegistroAdapter;
import com.example.myapplication2.helper.DbHelper;
import com.example.myapplication2.helper.RecyclerItemClickListener;
import com.example.myapplication2.helper.RegistroDAO;
import com.example.myapplication2.model.Registro;

import java.util.ArrayList;
import java.util.List;

public class EnviarRegistros extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RegistroAdapter registroAdapter;
    private List<Registro> listaRegistro = new ArrayList<>();
    private Registro registroSelecionadoExcluir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviar_registros);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Configuracao do recycler
        recyclerView = findViewById(R.id.recyclerView);





        //Adicionando evento de clique
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                //Recuperando registros para edicao
                                Registro registroSelecionado = listaRegistro.get(position);

                                //Enviando o registro para tela de edicao
                                //em getapplication era pra ser Enviarregistros.this

                                Intent registroEditar = new Intent(EnviarRegistros.this,registro.class);
                                registroEditar.putExtra("registroSelecionado",registroSelecionado);


                                startActivity(registroEditar);



                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                                //descobrindo o registro para exclusao
                                registroSelecionadoExcluir = listaRegistro.get(position);

                                AlertDialog.Builder dialog = new AlertDialog.Builder(EnviarRegistros.this);


                                //definindo titulo e mensagem
                                dialog.setTitle("Confirmar exclusão");
                                dialog.setMessage("Deseja excluir o registro ? : "+ registroSelecionadoExcluir.getNomeRegistro());

                                dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                        RegistroDAO registroDAO = new RegistroDAO(getApplicationContext());
                                        if (registroDAO.deletar(registroSelecionadoExcluir)){
                                            carregarlista();
                                            Toast.makeText(getApplicationContext(),
                                                    "Registro excluído",
                                                    Toast.LENGTH_SHORT).show();
                                        }else{
                                            Toast.makeText(getApplicationContext(),
                                                    "Erro ao excluir registro",
                                                    Toast.LENGTH_SHORT).show();

                                        }

                                    }
                                });

                                dialog.setNegativeButton("Não", null);

                                dialog.create();
                                dialog.show();


                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();


            }
        });
    }

    public void carregarlista(){

        //Listar Registros
        RegistroDAO registroDAO = new RegistroDAO(getApplicationContext());
        listaRegistro = registroDAO.lista();




        /*
        Exibir lista de registros
         */


        //Configurar o Adapter
        registroAdapter = new RegistroAdapter(listaRegistro);



        //Configurar o RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        recyclerView.setAdapter(  registroAdapter);


    }

    @Override
    protected void onStart() {
        carregarlista();
        super.onStart();
    }
}
