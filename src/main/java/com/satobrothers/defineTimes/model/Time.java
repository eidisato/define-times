package com.satobrothers.defineTimes.model;

import java.util.ArrayList;
import java.util.List;

public class Time {
    private List<Jogador> jogadores = new ArrayList<>();

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void adicionarJogador(Jogador jogador) {
        jogadores.add(jogador);
    }

    @Override
    public String toString() {
        return jogadores.toString();
    }
}
