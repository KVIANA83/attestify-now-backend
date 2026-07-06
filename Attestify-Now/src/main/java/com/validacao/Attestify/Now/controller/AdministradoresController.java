package com.validacao.Attestify.Now.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.validacao.Attestify.Now.dto.AdministradoresDTO;
import com.validacao.Attestify.Now.dto.CreateAdministradorDTO;
import com.validacao.Attestify.Now.model.Administradores;
import com.validacao.Attestify.Now.services.AdministradoresService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/administradores")
public class AdministradoresController {

    private final AdministradoresService administradoresService;

    // Listar todos
    @GetMapping("/listar")
    public ResponseEntity<List<AdministradoresDTO>> listarAdministradores() {

        return ResponseEntity.ok(administradoresService.listarTodos());
    }

    // Buscar por ID
    @GetMapping("/buscar/id/{id}")
    public ResponseEntity<AdministradoresDTO> buscarPorId(@PathVariable Long id) {

        return ResponseEntity.ok(administradoresService.buscarPorId(id));
    }

    // Buscar por nome
    @GetMapping("/buscar/nome/{nome}")
    public ResponseEntity<AdministradoresDTO> buscarPorNome(@PathVariable String nome) {

        return ResponseEntity.ok(administradoresService.buscarPorNome(nome));
    }

    // Buscar por cargo
    @GetMapping("/buscar/cargo/{cargo}")
    public ResponseEntity<AdministradoresDTO> buscarPorCargo(@PathVariable String cargo) {

        return ResponseEntity.ok(administradoresService.buscarPorCargo(cargo));
    }

    // Criar administrador
    @PostMapping("/criar")
    public ResponseEntity<Void> criarAdministrador(
            @Valid @RequestBody CreateAdministradorDTO dto) {

        administradoresService.salvar(dto);

        return ResponseEntity.noContent().build();
    }

    // Atualizar administrador
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Administradores> atualizarAdministrador(
            @PathVariable Long id,
            @Valid @RequestBody CreateAdministradorDTO dto) {

        return ResponseEntity.ok(administradoresService.atualizar(id, dto));
    }

    // Deletar administrador
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarAdministrador(@PathVariable Long id) {

        administradoresService.deletar(id);

        return ResponseEntity.noContent().build();
    }

}