package com.validacao.Attestify.Now.controller;

import com.validacao.Attestify.Now.dto.CreateAlunoDTO;
import com.validacao.Attestify.Now.dto.AlunoDTO;
import com.validacao.Attestify.Now.model.Aluno;
import com.validacao.Attestify.Now.service.AlunoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import java.util.List;

@RestControler
@AllArgsConstructor
@RequestMapping("/alunos")
public class AlunoController {
    
    private AlunoService alunoService;

    @GetMapping("/listar")
    public ResponseEntity<list<AlunoDTO>> listarAlunos() {

            return ResponseEntity.ok(usuarioService.listarTodos());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Aluno> getAluno(@PathVariable Long id) {

        return ResponseEntity.ok(alunoService.pegarAlunoPeloId(id));
        
    }

    @PostMapping("/criar")
    public ResponseEntity<Void> criarAluno(@Valid @RequestBody CreateAlunoDTO alunoDTO) {

        alunoService.saveAluno(alunoDTO);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/atualizar/{id}")
    public ResponseEntity<Void> atualizarAluno(@PathVariable Long id, @Valid @RequestBody CreateAlunoDTO alunoAtualizar) {
        
        alunoService.atualizarAluno(alunoAtualizar, id);

        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarAluno(@PathVariable Long id) {
        
        alunoService.deletarAluno(id);
        
        return ResponseEntity.noContent().build();
    }

}