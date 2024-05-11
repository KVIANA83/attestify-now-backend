package com.validacao.Attestify.Now.repositories;

import com.validacao.Attestify.Now.model.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfissionalRepository extends JpaRepository<Profissional, Long>{
    
    Optional<Profissional> findByNomeCompleto(String nomeCompleto);
    
    Optional<Profissional> findByCargo (String cargo);
}