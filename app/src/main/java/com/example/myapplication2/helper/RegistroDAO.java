package com.example.myapplication2.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.myapplication2.model.Registro;

import java.util.ArrayList;
import java.util.List;

public class RegistroDAO implements IRegistroDAO {

    private SQLiteDatabase escreve;
    private SQLiteDatabase ler;

    public RegistroDAO(Context context) {
        DbHelper db = new DbHelper(context);
        escreve = db.getWritableDatabase();
        ler = db.getReadableDatabase();
    }

    @Override
    public boolean salvar(Registro registro) {
        ContentValues cv = new ContentValues();
        cv.put("nome",registro.getNomeRegistro());

        try{

            escreve.insert(DbHelper.TABELA_REGISTROS,null,cv);
            Log.i("INFO","Registro salvo com sucesso");
        }catch (Exception e){
            Log.e("INFO","Error ao salvar registro" + e.getMessage());
            return false;

        }



        return true;
    }

    @Override
    public boolean atualizar(Registro registro) {

        ContentValues cv = new ContentValues();
        cv.put("nome",registro.getNomeRegistro());

        try{
                String[] args = {registro.getId().toString()};
            escreve.update(DbHelper.TABELA_REGISTROS,cv,"id=?",args);
            Log.i("INFO","Registro atualizado com sucesso");
        }catch (Exception e){
            Log.e("INFO","Error ao atualizar registro" + e.getMessage());
            return false;

        }


        return true;
    }

    @Override
    public boolean deletar(Registro registro) {

        try{
                String[] args = {registro.getId().toString()};
            escreve.delete(DbHelper.TABELA_REGISTROS,"id=?",args);
            Log.i("INFO","Registro removido com sucesso");
        }catch (Exception e){
            Log.e("INFO","Error ao remover registro" + e.getMessage());
            return false;

        }

        return true;
    }

    @Override
    public List<Registro> lista() {

        List<Registro> registros = new ArrayList<>();

        String sql = "SELECT * FROM " + DbHelper.TABELA_REGISTROS + " ; ";
        Cursor c = ler.rawQuery(sql,null);

        while(c.moveToNext()){

            Registro registro = new Registro();

            Long id = c.getLong( c.getColumnIndex("id") );
            String nomeRegistro = c.getString( c.getColumnIndex("nome") );


            registro.setId(id);
            registro.setNomeRegistro(nomeRegistro);

            registros.add(registro);


        }

        return registros;


    }
}
