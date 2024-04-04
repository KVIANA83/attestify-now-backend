package com.validacao.Attestify.Now.dto;

import com.validacao.Attestify.Now.model.Profissional;
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
public class Profissional {
    
    private String nomeCompleto;
    private String sexo;
    private String contato;
    private String email;
    private String instituicao;
    private String cargo;
}