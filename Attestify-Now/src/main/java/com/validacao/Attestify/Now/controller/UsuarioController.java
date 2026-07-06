package com.validacao.Attestify.Now.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.validacao.Attestify.Now.model.Usuario;
import com.validacao.Attestify.Now.repository.UsuarioRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UsuarioController {

    private final UsuarioRepository repository;

    public Optional<Usuario> buscarPorLogin(String login) {
        return repository.findByLogin(login);
    }

    public Usuario salvar(Usuario usuario) {
        return repository.save(usuario);
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}