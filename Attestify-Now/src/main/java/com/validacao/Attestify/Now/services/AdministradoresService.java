package com.validacao.Attestify.Now.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.validacao.Attestify.Now.dto.AdministradoresDTO;
import com.validacao.Attestify.Now.dto.CreateAdministradorDTO;
import com.validacao.Attestify.Now.exceptions.ValidacaoException;
import com.validacao.Attestify.Now.model.Administradores;
import com.validacao.Attestify.Now.repository.AdministradoresRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AdministradoresService {

    private final AdministradoresRepository repository;

    public List<AdministradoresDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    public AdministradoresDTO buscarPorId(Long id) {

        Administradores administrador = repository.findById(id)
                .orElseThrow(() ->
                        new ValidacaoException("Administrador não encontrado."));

        return converterParaDTO(administrador);
    }

    public AdministradoresDTO buscarPorNome(String nomeCompleto) {

        Administradores administrador = repository.findByNomeCompleto(nome)
                .orElseThrow(() ->
                        new ValidacaoException("Administrador não encontrado."));

        return converterParaDTO(administrador);
    }

    public AdministradoresDTO buscarPorCargo(String cargo) {

        Administradores administrador = repository.findByCargo(cargo)
                .orElseThrow(() ->
                        new ValidacaoException("Administrador não encontrado."));

        return converterParaDTO(administrador);
    }

    public void salvar(CreateAdministradorDTO dto) {

        Administradores administrador = new Administradores();

        administrador.setNomeCompleto(dto.getNomeCompleto());
        administrador.setDataNascimento(dto.getDataNascimento());
        administrador.setEndereco(dto.getEndereco());
        administrador.setSexo(dto.getSexo());
        administrador.setRg(dto.getRg());
        administrador.setCpf(dto.getCpf().toString());
        administrador.setContato(dto.getContato());
        administrador.setEmail(dto.getEmail());
        administrador.setLogin(dto.getLogin());
        administrador.setSenha(dto.getSenha());
        administrador.setPerfilLogin(dto.getPerfilLogin());
        administrador.setInstituicao(dto.getInstituicao());

        administrador.setCargo(dto.getCargo());

        repository.save(administrador);
    }

    public Administradores atualizar(Long id, CreateAdministradorDTO dto) {

        Administradores administrador = repository.findById(id)
                .orElseThrow(() ->
                        new ValidacaoException("Administrador não encontrado."));

        administrador.setNomeCompleto(dto.getNomeCompleto());
        administrador.setDataNascimento(dto.getDataNascimento());
        administrador.setEndereco(dto.getEndereco());
        administrador.setSexo(dto.getSexo());
        administrador.setRg(dto.getRg());
        administrador.setCpf(dto.getCpf().toString());
        administrador.setContato(dto.getContato());
        administrador.setEmail(dto.getEmail());
        administrador.setLogin(dto.getLogin());
        administrador.setSenha(dto.getSenha());
        administrador.setPerfilLogin(dto.getPerfilLogin());
        administrador.setInstituicao(dto.getInstituicao());

        administrador.setCargo(dto.getCargo());

        return repository.save(administrador);
    }

    public void deletar(Long id) {

        if (!repository.existsById(id)) {
            throw new ValidacaoException("Administrador não encontrado.");
        }

        repository.deleteById(id);
    }

    private AdministradoresDTO converterParaDTO(Administradores administrador) {

        return AdministradoresDTO.builder()
                .nomeCompleto(administrador.getNomeCompleto())
                .sexo(administrador.getSexo())
                .contato(administrador.getContato())
                .email(administrador.getEmail())
                .instituicao(administrador.getInstituicao())
                .cargo(administrador.getCargo())
                .build();
    }

}