package com.validacao.Attestify.Now.dto;

import com.validacao.Attestify.Now.exceptions.ValidacaoException;

public enum StatusEnum {
    
    EM_ANDAMENTO,
    PENDENTE,
    ACEITO,
    CANCELADO;


    public static StatusEnum pegarEnumPeloStatus(String status) {
        for (StatusEnum statusEnum : StatusEnum.values()) {
            if (status.equals(statusEnum.name())) {
                return statusEnum;
            }
        }
        throw new ValidacaoException("StatusEnum não encontrado!");
    }
}