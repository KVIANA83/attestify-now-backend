package com.validacao.Attestify.Now.repository;

import com.validacao.Attestify.Now.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    
    Optional<Aluno> findByNomeCompleto(String nomeCompleto);
    
    Optional<Aluno> findByTurma(String turma);
    
    Optional<Aluno> findByCurso(String curso);
    
}
