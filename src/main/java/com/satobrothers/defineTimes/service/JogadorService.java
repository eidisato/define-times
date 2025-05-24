package com.satobrothers.defineTimes.service;

import com.satobrothers.defineTimes.model.Jogador;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JogadorService {
    private final Map<Long, Jogador> jogadorMap = new HashMap<>();
    private long nextId = 1;

    public Jogador adicionar(Jogador jogador) {
        jogador.setId(nextId++);
        jogadorMap.put(jogador.getId(), jogador);
        return jogador;
    }

    public List<Jogador> listar() {
        return new ArrayList<>(jogadorMap.values());
    }

    public Optional<Jogador> buscarPorId(Long id) {
        return Optional.ofNullable(jogadorMap.get(id));
    }

    public Optional<Jogador> atualizar(Long id, Jogador jogadorAtualizado) {
        if (jogadorMap.containsKey(id)) {
            jogadorAtualizado.setId(id);
            jogadorMap.put(id, jogadorAtualizado);
            return Optional.of(jogadorAtualizado);
        }
        return Optional.empty();
    }

    public boolean remover(Long id) {
        return jogadorMap.remove(id) != null;
    }

    public List<List<Jogador>> sortearTimes() {
        List<Jogador> copia = new ArrayList<>(jogadorMap.values());
        copia.sort(Comparator.comparingInt(Jogador::getNota).reversed());

        List<Jogador> time1 = new ArrayList<>();
        List<Jogador> time2 = new ArrayList<>();
        List<Jogador> time3 = new ArrayList<>();

        int i = 0;
        for (Jogador jogador : copia) {
            switch (i % 3) {
                case 0 -> time1.add(jogador);
                case 1 -> time2.add(jogador);
                case 2 -> time3.add(jogador);
            }
            i++;
        }

        return List.of(time1, time2, time3);
    }

    public List<Jogador> saveAll(List<Jogador> jogadores) {
        List<Jogador> adicionados = new ArrayList<>();
        for (Jogador jogador : jogadores) {
            jogador.setId(nextId++);
            jogadorMap.put(jogador.getId(), jogador);
            adicionados.add(jogador);
        }
        return adicionados;
    }
}
