package com.validacao.Attestify.Now.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.validacao.Attestify.Now.model.Aluno;
import com.validacao.Attestify.Now.model.Atestado;
import com.validacao.Attestify.Now.model.Profissional;

@Repository
public interface AtestadoRepository extends JpaRepository<Atestado, Long> {

    List<Atestado> findByDataSolicitacao(LocalDate dataSolicitacao);

    List<Atestado> findByDataEntrega(LocalDate dataEntrega);

    List<Atestado> findByStatus(String status);

    List<Atestado> findByAluno(Aluno aluno);

    List<Atestado> findByProfissional(Profissional profissional);

}