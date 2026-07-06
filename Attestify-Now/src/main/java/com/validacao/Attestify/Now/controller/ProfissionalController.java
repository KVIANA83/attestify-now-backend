package com.validacao.Attestify.Now.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.validacao.Attestify.Now.dto.CreateProfissionalDTO;
import com.validacao.Attestify.Now.dto.ProfissionalDTO;
import com.validacao.Attestify.Now.model.Profissional;
import com.validacao.Attestify.Now.services.ProfissionalService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/profissionais")
public class ProfissionalController {

    private final ProfissionalService profissionalService;

    // Listar todos os profissionais
    @GetMapping("/listar")
    public ResponseEntity<List<ProfissionalDTO>> listarProfissionais() {

        return ResponseEntity.ok(profissionalService.listarTodos());
    }

    // Buscar profissional por ID
    @GetMapping("/buscar/id/{id}")
    public ResponseEntity<ProfissionalDTO> buscarPorId(@PathVariable Long id) {

        return ResponseEntity.ok(profissionalService.pegarProfissionalPeloId(id));
    }

    // Buscar profissional por nome
    @GetMapping("/buscar/nome/{nome}")
    public ResponseEntity<List<ProfissionalDTO>> buscarPorNome(@PathVariable String nome) {

        return ResponseEntity.ok(profissionalService.pegarProfissionalPeloNome(nome));
    }

    // Buscar profissional por cargo
    @GetMapping("/buscar/cargo/{cargo}")
    public ResponseEntity<List<ProfissionalDTO>> buscarPorCargo(@PathVariable String cargo) {

        return ResponseEntity.ok(profissionalService.pegarProfissionalPorCargo(cargo));
    }

    // Criar profissional
    @PostMapping("/criar")
    public ResponseEntity<Void> criarProfissional(
            @Valid @RequestBody CreateProfissionalDTO dto) {

        profissionalService.saveProfissional(dto);

        return ResponseEntity.noContent().build();
    }

    // Atualizar profissional
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Profissional> atualizarProfissional(
            @PathVariable Long id,
            @Valid @RequestBody CreateProfissionalDTO dto) {

        return ResponseEntity.ok(profissionalService.atualizarProfissional(dto, id));
    }

    // Deletar profissional
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarProfissional(@PathVariable Long id) {

        profissionalService.deletarProfissional(id);

        return ResponseEntity.noContent().build();
    }

}