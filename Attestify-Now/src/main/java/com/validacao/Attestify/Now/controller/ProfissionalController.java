package com.validacao.Attestify.Now.controller;

import com.validacao.Attestify.Now.dto.CreateProfissionalDTO;
import com.validacao.Attestify.Now.dto.ProfissionalDTO;
import com.validacao.Attestify.Now.model.Profissional;
import com.validacao.Attestify.Now.service.ProfissionalService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/profissional")
public class ProfissionalController {
    
    private ProfissionalService profissionalService;

    // Endpoint para listar todos os profissionais
    @GetMapping("/listar")
    public ResponseEntity<List<ProfissionalDTO>> listarProfissionais() {
        List<ProfissionalDTO> profissionais = profissionalService.listarTodos();
        return ResponseEntity.ok(profissionais);
    }

    // Endpoint para buscar um profissional por ID
    @GetMapping("/buscar/id/{id}")
    public ResponseEntity<ProfissionalDTO> getProfissionalPorId(@PathVariable Long id) {
        ProfissionalDTO profissional = profissionalService.pegarProfissionalPeloId(id);
        return ResponseEntity.ok(profissional);
    }

    // Endpoint para buscar profissionais por nome
    @GetMapping("/buscar/nome/{nome}")
    public ResponseEntity<List<ProfissionalDTO>> getProfissionalPorNome(@PathVariable String nome) {
        List<ProfissionalDTO> profissionais = profissionalService.pegarProfissionalPeloNome(nome);
        return ResponseEntity.ok(profissionais);
    }

    // Endpoint para buscar profissionais por cargo
    @GetMapping("/buscar/cargo/{cargo}")
    public ResponseEntity<List<ProfissionalDTO>> getProfissionalPorCargo(@PathVariable String cargo) {
        List<ProfissionalDTO> profissionais = profissionalService.pegarProfissionalPorCargo(cargo);
        return ResponseEntity.ok(profissionais);
    }

    // Endpoint para criar um novo profissional
    @PostMapping("/criar")
    public ResponseEntity<Void> criarProfissional(@Valid @RequestBody CreateProfissionalDTO profissionalDTO) {
        profissionalService.saveProfissional(profissionalDTO);
        return ResponseEntity.noContent().build();
    }

    // Endpoint para atualizar um profissional existente
    @PostMapping("/atualizar/{id}")
    public ResponseEntity<Void> atualizarProfissional(@PathVariable Long id, @Valid @RequestBody CreateProfissionalDTO profissionalAtualizar) {
        profissionalService.atualizarProfissional(profissionalAtualizar, id);
        return ResponseEntity.noContent().build();
    }
    
    // Endpoint para deletar profissional por id
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarProfissional(@PathVariable Long id) {
        profissionalService.deletarProfissional(id);
        return ResponseEntity.noContent().build();
    }
}
