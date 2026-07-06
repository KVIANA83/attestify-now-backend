package com.validacao.Attestify.Now.services;

import org.springframework.stereotype.Service;

import com.validacao.Attestify.Now.dto.LoginDTO;
import com.validacao.Attestify.Now.exceptions.ValidacaoException;
import com.validacao.Attestify.Now.model.Usuario;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoginService {

    private final UsuarioService usuarioService;

    public Usuario login(LoginDTO dto) {

        Usuario usuario = usuarioService.buscarPorLogin(dto.getLogin())
                .orElseThrow(() -> new ValidacaoException("Usuário não encontrado!"));

        if (!usuario.getSenha().equals(dto.getSenha())) {
            throw new ValidacaoException("Login ou senha incorretos!");
        }

        return usuario;
    }
}