package com.validacao.Attestify.Now.services;

import org.springframework.stereotype.Service;

import com.validacao.Attestify.Now.dto.LoginDTO;
import com.validacao.Attestify.Now.exceptions.ValidacaoException;
import com.validacao.Attestify.Now.model.Usuario;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoginService {

    private final UsuarioService usuarioService = null;

    public Usuario login(LoginDTO dto) {

        var usuarioOpt = usuarioService.buscarPorLogin(dto.getLogin());

        if (usuarioOpt.isEmpty()) {
            throw new ValidacaoException("Usuário não encontrado!");
        }

        var usuario = usuarioOpt.get();

        if (!usuario.getSenha().equals(dto.getSenha())) {
            throw new ValidacaoException("Login ou senha incorretos!");
        }

        return usuario;
    }
}
