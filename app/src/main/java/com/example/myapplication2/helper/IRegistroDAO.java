package com.example.myapplication2.helper;

import com.example.myapplication2.model.Registro;

import java.util.List;

public interface IRegistroDAO {

    public boolean salvar(Registro registro);
    public boolean atualizar(Registro registro);
    public boolean deletar(Registro registro);
    public List<Registro> lista();

}
