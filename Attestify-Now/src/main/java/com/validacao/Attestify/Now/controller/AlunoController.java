package com.validacao.Attestify.Now.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.validacao.Attestify.Now.dto.AlunoDTO;
import com.validacao.Attestify.Now.dto.CreateAlunoDTO;
import com.validacao.Attestify.Now.model.Aluno;
import com.validacao.Attestify.Now.services.AlunoService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    // Listar todos os alunos
    @GetMapping("/listar")
    public ResponseEntity<List<AlunoDTO>> listarAlunos() {

        return ResponseEntity.ok(alunoService.listarTodos());
    }

    // Buscar aluno por ID
    @GetMapping("/buscar/id/{id}")
    public ResponseEntity<AlunoDTO> buscarPorId(@PathVariable Long id) {

        return ResponseEntity.ok(alunoService.pegarAlunoPeloId(id));
    }

    // Buscar aluno por nome
    @GetMapping("/buscar/nome/{nome}")
    public ResponseEntity<List<AlunoDTO>> buscarPorNome(@PathVariable String nome) {

        return ResponseEntity.ok(alunoService.pegarAlunoPeloNome(nome));
    }

    // Buscar aluno por turma
    @GetMapping("/buscar/turma/{turma}")
    public ResponseEntity<List<AlunoDTO>> buscarPorTurma(@PathVariable String turma) {

        return ResponseEntity.ok(alunoService.pegarAlunoPorTurma(turma));
    }

    // Criar aluno
    @PostMapping("/criar")
    public ResponseEntity<Void> criarAluno(@Valid @RequestBody CreateAlunoDTO dto) {

        alunoService.saveAluno(dto);

        return ResponseEntity.noContent().build();
    }

    // Atualizar aluno
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Aluno> atualizarAluno(
            @PathVariable Long id,
            @Valid @RequestBody CreateAlunoDTO dto) {

        return ResponseEntity.ok(alunoService.atualizarAluno(dto, id));
    }

    // Deletar aluno
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarAluno(@PathVariable Long id) {

        alunoService.deletarAluno(id);

        return ResponseEntity.noContent().build();
    }

}