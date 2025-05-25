package com.satobrothers.defineTimes.model;

import jakarta.persistence.*;

@Entity
@Table(name = "M_JOGADOR")
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private int nota;

    private boolean confirmado;

    public Jogador() {}

    public Jogador(Long id, String nome, int nota, boolean confirmado) {
        this.id = id;
        this.nome = nome;
        this.nota = nota;
        this.confirmado = confirmado;
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

    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    @Override
    public String toString() {
        return nome + " (" + nota + ")" + (confirmado ? " [Confirmado]" : "");
    }
}
