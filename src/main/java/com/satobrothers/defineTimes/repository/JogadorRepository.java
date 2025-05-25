package com.satobrothers.defineTimes.repository;

import com.satobrothers.defineTimes.model.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long> {

    // Consulta customizada: jogadores que confirmaram presença
    List<Jogador> findByConfirmadoTrue();

    // Consulta customizada: jogadores que NÃO confirmaram presença
    List<Jogador> findByConfirmadoFalse();
}
