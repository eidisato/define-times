package com.satobrothers.defineTimes.service;

import com.satobrothers.defineTimes.model.Jogador;
import com.satobrothers.defineTimes.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;

    public Jogador adicionar(Jogador jogador) {
        return jogadorRepository.save(jogador);
    }

    public List<Jogador> listar() {
        return jogadorRepository.findAll();
    }

    public Optional<Jogador> buscarPorId(Long id) {
        return jogadorRepository.findById(id);
    }

    public Optional<Jogador> atualizar(Long id, Jogador jogadorAtualizado) {
        return jogadorRepository.findById(id).map(j -> {
            jogadorAtualizado.setId(id);
            return jogadorRepository.save(jogadorAtualizado);
        });
    }

    public boolean remover(Long id) {
        if (jogadorRepository.existsById(id)) {
            jogadorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<List<Jogador>> sortearTimes() {
        List<Jogador> jogadoresConfirmados = jogadorRepository.findByConfirmadoTrue();
        jogadoresConfirmados.sort(Comparator.comparingInt(Jogador::getNota).reversed());

        List<Jogador> time1 = new ArrayList<>();
        List<Jogador> time2 = new ArrayList<>();
        List<Jogador> time3 = new ArrayList<>();

        for (int i = 0; i < jogadoresConfirmados.size(); i++) {
            switch (i % 3) {
                case 0 -> time1.add(jogadoresConfirmados.get(i));
                case 1 -> time2.add(jogadoresConfirmados.get(i));
                case 2 -> time3.add(jogadoresConfirmados.get(i));
            }
        }

        return List.of(time1, time2, time3);
    }

    public List<Jogador> saveAll(List<Jogador> jogadores) {
        return jogadorRepository.saveAll(jogadores);
    }
}
