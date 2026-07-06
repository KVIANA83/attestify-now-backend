package com.validacao.Attestify.Now.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.validacao.Attestify.Now.dto.CreateProfissionalDTO;
import com.validacao.Attestify.Now.dto.ProfissionalDTO;
import com.validacao.Attestify.Now.exceptions.ValidacaoException;
import com.validacao.Attestify.Now.model.Profissional;
import com.validacao.Attestify.Now.repository.ProfissionalRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProfissionalService {

    private final ProfissionalRepository repository;

    // Listar todos
    public List<ProfissionalDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    // Buscar por ID
    public ProfissionalDTO buscarPorId(Long id) {

        Profissional profissional = repository.findById(id)
                .orElseThrow(() ->
                        new ValidacaoException("Profissional não encontrado."));

        return converterParaDTO(profissional);
    }

    // Buscar por nome
    public List<ProfissionalDTO> buscarPorNome(String nomeCompleto) {

        return repository.findByNomeCompleto(nomeCompleto)
                .stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    // Buscar por cargo
    public List<ProfissionalDTO> buscarPorCargo(String cargo) {

        return repository.findByCargo(cargo)
                .stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    // Salvar
    public Profissional salvar(CreateProfissionalDTO dto) {

        Profissional profissional = new Profissional();

        profissional.setNomeCompleto(dto.getNomeCompleto());
        profissional.setDataNascimento(dto.getDataNascimento());
        profissional.setEndereco(dto.getEndereco());
        profissional.setSexo(dto.getSexo());
        profissional.setRg(dto.getRg());
        profissional.setCpf(dto.getCpf().toString());
        profissional.setContato(dto.getContato());
        profissional.setEmail(dto.getEmail());
        profissional.setLogin(dto.getLogin());
        profissional.setSenha(dto.getSenha());
        profissional.setPerfilLogin(dto.getPerfilLogin());
        profissional.setInstituicao(dto.getInstituicao());
        profissional.setCargo(dto.getCargo());

        return repository.save(profissional);
    }

    // Atualizar
    public Profissional atualizar(Long id, CreateProfissionalDTO dto) {

        Profissional profissional = repository.findById(id)
                .orElseThrow(() ->
                        new ValidacaoException("Profissional não encontrado."));

        profissional.setNomeCompleto(dto.getNomeCompleto());
        profissional.setDataNascimento(dto.getDataNascimento());
        profissional.setEndereco(dto.getEndereco());
        profissional.setSexo(dto.getSexo());
        profissional.setRg(dto.getRg());
        profissional.setCpf(dto.getCpf().toString());
        profissional.setContato(dto.getContato());
        profissional.setEmail(dto.getEmail());
        profissional.setLogin(dto.getLogin());
        profissional.setSenha(dto.getSenha());
        profissional.setPerfilLogin(dto.getPerfilLogin());
        profissional.setInstituicao(dto.getInstituicao());
        profissional.setCargo(dto.getCargo());

        return repository.save(profissional);
    }

    // Deletar
    public void deletar(Long id) {

        Profissional profissional = repository.findById(id)
                .orElseThrow(() ->
                        new ValidacaoException("Profissional não encontrado."));

        repository.delete(profissional);
    }

    // Converter para DTO
    private ProfissionalDTO converterParaDTO(Profissional profissional) {

        return ProfissionalDTO.builder()
                .nomeCompleto(profissional.getNomeCompleto())
                .sexo(profissional.getSexo())
                .contato(profissional.getContato())
                .email(profissional.getEmail())
                .instituicao(profissional.getInstituicao())
                .cargo(profissional.getCargo())
                .perfilLogin(profissional.getPerfilLogin())
                .build();
    }

}