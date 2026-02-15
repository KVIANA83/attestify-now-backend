package com.validacao.Attestify.Now.controller;

import com.validacao.Attestify.Now.dto.CreateAdministradorDTO;
import com.validacao.Attestify.Now.dto.AdministradorDTO;
import com.validacao.Attestify.Now.model.Administrador;
import com.validacao.Attestify.Now.service.AdministradoresService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/administradores")
public class AdministradoresController {
    
    private final AdministradoresService administradoresService;

    // Endpoint para listar todos os administradores
    @GetMapping("/listar")
    public ResponseEntity<List<AdministradorDTO>> listarAdministradores() {
        List<AdministradorDTO> administradores = administradoresService.listarTodos();
        return ResponseEntity.ok(administradores);
    }

    // Endpoint para buscar administrador por ID
    @GetMapping("/buscar/id/{id}")
    public ResponseEntity<AdministradorDTO> getAdministradorPorId(@PathVariable Long id) {
        AdministradorDTO administrador = administradoresService.pegarAdministradorPeloId(id);
        return ResponseEntity.ok(administrador);
    }

    // Endpoint para buscar administradores por nome
    @GetMapping("/buscar/nome/{nome}")
    public ResponseEntity<List<AdministradorDTO>> getAdministradorPorNome(@PathVariable String nome) {
        List<AdministradorDTO> administradores = administradoresService.pegarAdministradorPeloNome(nome);
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
        AdministradoresService.deletarAdministrador(id);
        return ResponseEntity.noContent().build();
    }
}
