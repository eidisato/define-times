package com.satobrothers.defineTimes.controller;

import com.satobrothers.defineTimes.model.Jogador;
import com.satobrothers.defineTimes.service.JogadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jogadores")
public class JogadorController {

    private final JogadorService jogadorService;

    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    // Create
    @PostMapping
    public ResponseEntity<Jogador> adicionarJogador(@RequestBody Jogador jogador) {
        return ResponseEntity.ok(jogadorService.adicionar(jogador));
    }

    @PostMapping("/adicionaLote")
    public ResponseEntity<List<Jogador>> adicionarVarios(@RequestBody List<Jogador> jogadores) {
        return ResponseEntity.ok(jogadorService.saveAll(jogadores));
    }

    // Read all
    @GetMapping
    public List<Jogador> listarJogadores() {
        return jogadorService.listar();
    }

    // Read by ID
    @GetMapping("/{id}")
    public ResponseEntity<Jogador> buscarPorId(@PathVariable Long id) {
        return jogadorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Jogador> atualizarJogador(@PathVariable Long id, @RequestBody Jogador jogador) {
        return jogadorService.atualizar(id, jogador)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerJogador(@PathVariable Long id) {
        if (jogadorService.remover(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Sortear times
    @GetMapping("/times")
    public List<List<Jogador>> sortearTimes() {
        return jogadorService.sortearTimes();
    }
}
