package com.example.myapplication2.model;

import java.io.Serializable;

public class Registro implements Serializable {

    private Long id;
    private String nomeRegistro;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeRegistro() {
        return nomeRegistro;
    }

    public void setNomeRegistro(String nomeRegistro) {
        this.nomeRegistro = nomeRegistro;
    }
}
