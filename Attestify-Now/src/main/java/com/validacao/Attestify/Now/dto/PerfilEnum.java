package com.validacao.Attestify.Now.dto;

import com.validacao.Attestify.Now.exceptions.ValidacaoException;

public enum PerfilEnum {
    
    ADMINISTRADORES,
    ALUNO,
    PROFISSIONAL;


    public static PerfilEnum pegarEnumPeloPerfil(String perfil) {
        for (PerfilEnum perfilEnum : PerfilEnum.values()) {
            if (perfil.equalsIgnoreCase(perfilEnum.name())) {
                return perfilEnum;
            }
        }
        throw new ValidacaoException("PerfilEnum não encontrado!");
    }
}
