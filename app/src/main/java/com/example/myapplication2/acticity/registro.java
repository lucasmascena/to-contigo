package com.example.myapplication2.acticity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication2.R;
import com.example.myapplication2.helper.RegistroDAO;
import com.example.myapplication2.model.Registro;

public class registro extends AppCompatActivity {

    private EditText editRegistro;
    private Registro registroAtual;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

            editRegistro = findViewById(R.id.textRegistrar);

            //recuperar registro em caso de edicao
            registroAtual = (Registro) getIntent().getSerializableExtra("registroSelecionado");

            //Configurar a caixa de edicao
            if (registroAtual != null){
                editRegistro.setText(registroAtual.getNomeRegistro());


            }

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RegistroDAO registroDAO = new RegistroDAO(getApplicationContext());

                if (registroAtual != null){//edicao

                    String editRegistros = editRegistro.getText().toString();
                    if ( !editRegistros.isEmpty()){

                        Registro registro = new Registro();
                        registro.setNomeRegistro(editRegistros);
                        registro.setId(registroAtual.getId());

                        //atualizando o banco de dados
                        if (registroDAO.atualizar(registro)){
                            Toast.makeText(registro.this,
                                    "Registro atualizado",
                                    Toast.LENGTH_SHORT).show();
                            finish();
                        }else{
                            Toast.makeText(registro.this,
                                    "Erro ao atualizar registro",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }

                }else {//salvar




                    String editRegistros = editRegistro.getText().toString();
                    if ( !editRegistros.isEmpty()){
                        Registro registro = new Registro();
                        registro.setNomeRegistro(editRegistros);


                        if (registroDAO.salvar(registro)){
                            Toast.makeText(registro.this,
                                    "Seu registro foi salvo",
                                    Toast.LENGTH_SHORT).show();
                            finish();
                        }else{
                            Toast.makeText(registro.this,
                                    "Erro ao salvar seu registro",
                                    Toast.LENGTH_SHORT).show();

                        }




                    }

                }

            }
        });
    }

}
