package com.validacao.Attestify.Now.dto;

import com.validacao.Attestify.Now.exceptions.ValidacaoException;

public enum PerfilEnum {
    
    ADMINISTRADORES,
    ALUNO,
    PROFSSIONAL;


    public static PerfilEnum pegarEnumPeloPerfil(String perfil) {
        for (PerfilEnum perfilEnum : PerfilEnum.values()) {
            if (perfil.equals(perfilEnum.name())) {
                return perfilEnum;
            }
        }
        throw new ValidacaoException("PerfilEnum não encontrado!");
    }
}
