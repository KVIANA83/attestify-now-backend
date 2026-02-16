package com.validacao.Attestify.Now.controller;

import com.validacao.Attestify.Now.dto.AdministradoresDTO;
import com.validacao.Attestify.Now.model.Administradores;
import com.validacao.Attestify.Now.services.AdministradoresService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/administradores")
public class AdministradoresController {
    
    private final AdministradoresService administradoresService = null;

    // Endpoint para listar todos os administradores
    @GetMapping("/listar")
    public ResponseEntity<List<AdministradoresDTO>> listarAdministradores() {
        List<AdministradoresDTO> administradores = administradoresService.listarTodos();
        return ResponseEntity.ok(administradores);
    }

    // Endpoint para buscar administrador por ID
    @GetMapping("/buscar/id/{id}")
    public ResponseEntity<AdministradoresDTO> getAdministradorPorId(@PathVariable Long id) {
        AdministradoresDTO administrador = administradoresService.pegarAdministradoresPeloId(id);
        return ResponseEntity.ok(administrador);
    }

    // Endpoint para buscar administradores por nome
    @GetMapping("/buscar/nome/{nome}")
    public ResponseEntity<List<AdministradoresDTO>> getAdministradorPorNome(@PathVariable String nome) {
        List<AdministradoresDTO> administradores = administradoresService.pegarAdministradoresPeloNome(nome);
        return ResponseEntity.ok(administradores);
    }

    // Endpoint para criar um novo administrador
    @PostMapping("/criar")
    public ResponseEntity<Void> criarAdministrador(@Valid @RequestBody CreateAdministradorDTO administradorDTO) {
        administradoresService.saveAdministrador(administradorDTO);
        return ResponseEntity.noContent().build();
    }

    // Endpoint para atualizar um administrador existente
    @PostMapping("/atualizar/{id}")
    public ResponseEntity<Void> atualizarAdministrador(@PathVariable Long id, @Valid @RequestBody CreateAdministradorDTO administradorAtualizar) {
        administradoresService.atualizarAdministrador(administradorAtualizar, id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint para deletar um administrador por ID
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarAdministrador(@PathVariable Long id) {
        administradoresService.deletarAdministradores(id);
        return ResponseEntity.noContent().build();
    }
}
