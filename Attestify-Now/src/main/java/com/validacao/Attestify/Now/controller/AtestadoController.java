package com.validacao.Attestify.Now.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.validacao.Attestify.Now.dto.AtestadoDTO;
import com.validacao.Attestify.Now.dto.CreateAtestadoDTO;
import com.validacao.Attestify.Now.model.Atestado;
import com.validacao.Attestify.Now.services.AtestadoService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/atestados")
public class AtestadoController {

    private final AtestadoService atestadoService;

    // Listar todos
    @GetMapping("/listar")
    public ResponseEntity<List<AtestadoDTO>> listarTodos() {

        return ResponseEntity.ok(atestadoService.listarTodos());
    }

    // Buscar por ID
    @GetMapping("/buscar/id/{id}")
    public ResponseEntity<AtestadoDTO> buscarPorId(@PathVariable Long id) {

        return ResponseEntity.ok(atestadoService.buscarPorId(id));
    }

    // Criar atestado
    @PostMapping("/criar")
    public ResponseEntity<Void> criarAtestado(
            @Valid @RequestBody CreateAtestadoDTO dto) {

        atestadoService.salvar(dto);

        return ResponseEntity.noContent().build();
    }

    // Atualizar atestado
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Atestado> atualizarAtestado(
            @PathVariable Long id,
            @Valid @RequestBody CreateAtestadoDTO dto) {

        return ResponseEntity.ok(atestadoService.atualizar(id, dto));
    }

    // Deletar atestado
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarAtestado(@PathVariable Long id) {

        atestadoService.deletar(id);

        return ResponseEntity.noContent().build();
    }

}