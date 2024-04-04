package com.validacao.Attestify.Now.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ErrorBody {
    
    private String mensagem;
}