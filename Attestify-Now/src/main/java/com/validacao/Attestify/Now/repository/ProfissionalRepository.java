package com.validacao.Attestify.Now.repository;

import java.util.List;

import com.validacao.Attestify.Now.model.Profissional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Long>{
    
    List<Profissional> findByNomeCompleto(String nomeCompleto);
    
    List<Profissional> findByCargo(String cargo);

}