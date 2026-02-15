package com.validacao.Attestify.Now.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateAtestadoDTO {
    
    @NotBlank(message = "Arquivo é um campo obrigatório!")
    private String urlArquivo;
    
    // Data que o atestado foi impresso pelo prestador de serviço de saúde
    @NotNull(message = "Data de Solicitação é um campo obrigatório!")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataSolicitacao;
    
    // Data que o arquivo foi anexado no Attestify Now para realizar a entrega
    @NotNull(message = "Data de Entrega é um campo obrigatório!")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataEntrega;
    
}