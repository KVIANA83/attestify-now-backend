package com.validacao.Attestify.Now.repositories;

import com.validacao.Attestify.Now.model.Aluno;
import com.validacao.Attestify.Now.model.Profissional;
import com.validacao.Attestify.Now.model.Administradores;
import com.validacao.Attestify.Now.model.Atestado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.time.LocalDateTime;
import java.util.List;

@Repository    
public interface AtestadoRepository extends JpaRepository<Atestado, Long> {
    
    Optional<Atestado> findByDataSolicitacao(LocalDateTime dataSolicitacao);
    
    Optional<Atestado> findByDataAEntrega(LocalDateTime dataEntrega);
    
    Optional<Atestado> findByDataFechamento(LocalDateTime dataFechamento);
    
    Optional<List<Atestado>> findByAluno(Aluno aluno);

    Optional<List<Atestado>> findByProfissional(Profissional profissional);

    Optional<List<Atestado>> findByAdministradores(Administradores admin);
    
}