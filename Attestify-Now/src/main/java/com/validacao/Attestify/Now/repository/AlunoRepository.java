package com.validacao.Attestify.Now.repository;

import com.validacao.Attestify.Now.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    
    List<Aluno> findByNomeCompletoContainingIgnoreCase(String nomeCompleto);
    
    List<Aluno> findByTurma(String turma);

    List<Aluno> findByModalidade(String modalidade);
    
    List<Aluno> findByTurno(String turno);
    
}
