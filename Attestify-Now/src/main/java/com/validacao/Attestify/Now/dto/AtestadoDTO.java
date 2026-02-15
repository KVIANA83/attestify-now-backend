package com.validacao.Attestify.Now.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AtestadoDTO {
    
    private Long idAtestado;
    private String urlArquivo;
    private String status;
    private LocalDate dataSolicitacao;
    private LocalDate dataEntrega;
}