package com.example.mestrado2kellyv10.modelo;

import java.io.Serializable;

public class Usuario implements Serializable {
    private long id;
    private String nome;
    private String senha;

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() { return senha; }

    public void setSenha(String senha) { this.senha = senha; }

}
