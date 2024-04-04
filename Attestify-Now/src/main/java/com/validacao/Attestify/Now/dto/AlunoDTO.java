package com.validacao.Attestify.Now.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDTO {
    
    private String nomeCompleto;
    private String sexo;
    private String contato;
    private String email;
    private String instituicao;
    private String modalidade;
    private String turma;
    private String turno;
}