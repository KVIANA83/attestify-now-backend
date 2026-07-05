package com.validacao.Attestify.Now.repository;

import com.validacao.Attestify.Now.model.Administradores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
    
@Repository
public interface AdministradoresRepository extends JpaRepository<Administradores, Long>{
    
    List<Administradores> findByNomeContainingIgnoreCase(String nome);

    List<Administradores> findByCargo(String cargo);

    Optional<Administradores> findByLogin(String login);
}