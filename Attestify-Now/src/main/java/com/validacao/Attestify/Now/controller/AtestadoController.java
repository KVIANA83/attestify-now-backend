package com.validacao.Attestify.Now.controller;

import com.validacao.Attestify.Now.dto.CreateAtestadoDTO;
import com.validacao.Attestify.Now.dto.AtestadoDTO;
import com.validacao.Attestify.Now.model.Atestado;
import com.validacao.Attestify.Now.services.AtestadoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/atestados")
public class AtestadoController {

    private final AtestadoService atestadoService = null;

    // Endpoint para listar todos os atestados
    @GetMapping("/listar")
    public ResponseEntity<List<AtestadoDTO>> listarAtestados() {
        List<AtestadoDTO> atestados = atestadoService.listarTodos();
        return ResponseEntity.ok(atestados);
    }

    // Endpoint para buscar atestado por ID
    @GetMapping("/buscar/id/{id}")
    public ResponseEntity<AtestadoDTO> getAtestadoPorId(@PathVariable Long id) {
        AtestadoDTO atestado = atestadoService.pegarAtestadoPeloId(id);
        return ResponseEntity.ok(atestado);
    }

    // Endpoint para buscar atestados por nome do aluno
    @GetMapping("/buscar/nome-aluno/{nome}")
    public ResponseEntity<List<AtestadoDTO>> getAtestadoPorNomeAluno(@PathVariable String nome) {
        List<AtestadoDTO> atestados = atestadoService.pegarAtestadoPeloNomeAluno(nome);
        return ResponseEntity.ok(atestados);
    }

    // Endpoint para buscar atestados por turma
    @GetMapping("/buscar/turma/{turma}")
    public ResponseEntity<List<AtestadoDTO>> getAtestadoPorTurma(@PathVariable String turma) {
        List<AtestadoDTO> atestados = atestadoService.pegarAtestadoPorTurma(turma);
        return ResponseEntity.ok(atestados);
    }

    // Endpoint para buscar atestados por curso
    @GetMapping("/buscar/curso/{curso}")
    public ResponseEntity<List<AtestadoDTO>> getAtestadoPorCurso(@PathVariable String curso) {
        List<AtestadoDTO> atestados = atestadoService.pegarAtestadoPorCurso(curso);
        return ResponseEntity.ok(atestados);
    }

    // Endpoint para buscar atestados por nome do profissional
    @GetMapping("/buscar/nome-profissional/{nome}")
    public ResponseEntity<List<AtestadoDTO>> getAtestadoPorNomeProfissional(@PathVariable String nome) {
        List<AtestadoDTO> atestados = atestadoService.pegarAtestadoPeloNomeProfissional(nome);
        return ResponseEntity.ok(atestados);
    }

    // Endpoint para buscar atestados por cargo do profissional (educador ou não educador)
    @GetMapping("/buscar/cargo/{cargo}")
    public ResponseEntity<List<AtestadoDTO>> getAtestadoPorCargo(@PathVariable String cargo) {
        List<AtestadoDTO> atestados = atestadoService.pegarAtestadoPorCargo(cargo);
        return ResponseEntity.ok(atestados);
    }

    // Endpoint para buscar atestados sem administrador
    @GetMapping("/buscar/sem-administrador")
    public ResponseEntity<List<AtestadoDTO>> getAtestadoSemAdministrador() {
        List<AtestadoDTO> atestados = atestadoService.pegarAtestadoSemAdministrador();
        return ResponseEntity.ok(atestados);
    }

    // Endpoint para buscar atestados com administrador
    @GetMapping("/buscar/com-administrador")
    public ResponseEntity<List<AtestadoDTO>> getAtestadoComAdministrador() {
        List<AtestadoDTO> atestados = atestadoService.pegarAtestadoComAdministrador();
        return ResponseEntity.ok(atestados);
    }

    // Endpoint para criar um novo atestado
    @PostMapping("/criar")
    public ResponseEntity<Void> criarAtestado(@Valid @RequestBody CreateAtestadoDTO atestadoDTO) {
        atestadoService.saveAtestado(atestadoDTO);
        return ResponseEntity.noContent().build();
    }

    // Endpoint para deletar um atestado por ID
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarAtestado(@PathVariable Long id) {
        atestadoService.deletarAtestado(id);
        return ResponseEntity.noContent().build();
    }
}
