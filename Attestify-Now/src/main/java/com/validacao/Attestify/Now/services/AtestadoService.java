package com.validacao.Attestify.Now.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.validacao.Attestify.Now.dto.AtestadoDTO;
import com.validacao.Attestify.Now.dto.CreateAtestadoDTO;
import com.validacao.Attestify.Now.exceptions.ValidacaoException;
import com.validacao.Attestify.Now.model.Atestado;
import com.validacao.Attestify.Now.repository.AtestadoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AtestadoService {

    private final AtestadoRepository repository;

    public List<AtestadoDTO> listarTodos() {

        return repository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    public AtestadoDTO buscarPorId(Long id) {

        Atestado atestado = repository.findById(id)
                .orElseThrow(() ->
                        new ValidacaoException("Atestado não encontrado."));

        return converterParaDTO(atestado);
    }

    public void salvar(CreateAtestadoDTO dto) {

        Atestado atestado = new Atestado();

        atestado.setUrlArquivo(dto.getUrlArquivo());
        atestado.setStatus("PENDENTE");
        atestado.setDataSolicitacao(dto.getDataSolicitacao());
        atestado.setDataEntrega(dto.getDataEntrega());

        repository.save(atestado);
    }

    public Atestado atualizar(Long id, CreateAtestadoDTO dto) {

        Atestado atestado = repository.findById(id)
                .orElseThrow(() ->
                        new ValidacaoException("Atestado não encontrado."));

        atestado.setUrlArquivo(dto.getUrlArquivo());
        atestado.setDataSolicitacao(dto.getDataSolicitacao());
        atestado.setDataEntrega(dto.getDataEntrega());

        return repository.save(atestado);
    }

    public void deletar(Long id) {

        if (!repository.existsById(id)) {
            throw new ValidacaoException("Atestado não encontrado.");
        }

        repository.deleteById(id);
    }

    private AtestadoDTO converterParaDTO(Atestado atestado) {

        return AtestadoDTO.builder()
                .idAtestado(atestado.getIdAtestado())
                .urlArquivo(atestado.getUrlArquivo())
                .status(atestado.getStatus())
                .dataSolicitacao(atestado.getDataSolicitacao())
                .dataEntrega(atestado.getDataEntrega())
                .build();
    }

}