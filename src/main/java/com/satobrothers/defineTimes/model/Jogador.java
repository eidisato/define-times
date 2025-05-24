package com.satobrothers.defineTimes.model;

public class Jogador {
    private Long id;
    private String nome;
    private int nota;

    public Jogador() {}

    public Jogador(Long id, String nome, int nota) {
        this.id = id;
        this.nome = nome;
        this.nota = nota;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return nome + " (" + nota + ")";
    }
}
