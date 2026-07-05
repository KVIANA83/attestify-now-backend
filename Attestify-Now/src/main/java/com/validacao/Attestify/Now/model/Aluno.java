package com.validacao.Attestify.Now.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "aluno")
@PrimaryKeyJoinColumn(name = "usuario_id")
public class Aluno extends Usuario {
    
    @Column(name = "nome_responsavel")
    private String nomeResponsavel;
    
    @Column(name = "grau_parentesco")
    private String grauParentesco;
    
    @Column(name = "data_nasc_responsavel")
    private LocalDate dataNascimentoResponsavel;
    
    @Column
    private String modalidade;
    
    @Column
    private String turma;
    
    @Column
    private String turno;
    
}