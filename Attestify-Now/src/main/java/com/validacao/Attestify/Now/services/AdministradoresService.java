package com.validacao.Attestify.Now.service;

import com.validacao.Attestify.Now.dto.AdministradoresDTO;
import com.validacao.Attestify.Now.exceptions.ValidacaoException;
import com.validacao.Attestify.Now.model.Administradores;
import com.validacao.Attestify.Now.repositories.AdministradoresRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AdministradoresService {

    private final AdministradoresRepository administradoresRepository;

    // Listar todos os administradores
    public List<AdministradoresDTO> listarTodos() {
        return administradoresRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Buscar administrador por ID
    public AdministradoresDTO buscarPorId(Long id) {
        Administradores administrador = administradoresRepository.findById(id)
                .orElseThrow(() -> new ValidacaoException("Administrador não encontrado com ID: " + id));
        return convertToDTO(administrador);
    }

    // Buscar administrador por nome
    public AdministradoresDTO buscarPorNome(String nome) {
        Administradores administrador = administradoresRepository.findByNome(nome)
                .orElseThrow(() -> new ValidacaoException("Administrador não encontrado com nome: " + nome));
        return convertToDTO(administrador);
    }

    // Buscar administrador por cargo
    public AdministradoresDTO buscarPorCargo(String cargo) {
        Administradores administrador = administradoresRepository.findByCargo(cargo)
                .orElseThrow(() -> new ValidacaoException("Administrador não encontrado com cargo: " + cargo));
        return convertToDTO(administrador);
    }

    // Buscar administrador por login
    public AdministradoresDTO buscarPorLogin(String login) {
        Administradores administrador = administradoresRepository.findByLogin(login)
                .orElseThrow(() -> new ValidacaoException("Administrador não encontrado com login: " + login));
        return convertToDTO(administrador);
    }

    // Método para converter a entidade Administradores para DTO
    private AdministradoresDTO convertToDTO(Administradores administrador) {
        return new AdministradoresDTO(
                administrador.getIdAdministradores(),
                administrador.getNomeCompleto(),
                administrador.getDataNascimento(),
                administrador.getEndereco(),
                administrador.getSexo(),
                administrador.getRg(),
                administrador.getCpf(),
                administrador.getContato(),
                administrador.getEmail(),
                administrador.getLogin(),
                administrador.getSenha(),
                administrador.getPerfilLogin(),
                administrador.getInstituicao(),
                administrador.getCargo()
        );
    }
}
