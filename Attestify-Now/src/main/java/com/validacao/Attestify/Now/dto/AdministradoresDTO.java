package com.validacao.Attestify.Now.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdministradoresDTO {
    
    private String nomeCompleto;
    private String sexo;
    private String contato;
    private String email;
    private String instituicao;
    private String cargo;
    
}