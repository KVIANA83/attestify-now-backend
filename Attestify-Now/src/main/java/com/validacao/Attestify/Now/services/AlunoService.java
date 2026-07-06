package com.validacao.Attestify.Now.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.validacao.Attestify.Now.dto.AlunoDTO;
import com.validacao.Attestify.Now.dto.CreateAlunoDTO;
import com.validacao.Attestify.Now.exceptions.ValidacaoException;
import com.validacao.Attestify.Now.model.Aluno;
import com.validacao.Attestify.Now.repository.AlunoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AlunoService {

    private final AlunoRepository repository;

    // Listar todos
    public List<AlunoDTO> listarTodos() {

        return repository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    // Buscar por ID
    public AlunoDTO buscarPorId(Long id) {

        Aluno aluno = repository.findById(id)
                .orElseThrow(() ->
                        new ValidacaoException("Aluno não encontrado."));

        return converterParaDTO(aluno);
    }

    // Buscar por nome
    public AlunoDTO buscarPorNome(String nomeCompleto) {

        Aluno aluno = repository.findByNomeCompleto(nomeCompleto)
                .orElseThrow(() ->
                        new ValidacaoException("Aluno não encontrado."));

        return converterParaDTO(aluno);
    }

    // Buscar por turma
    public AlunoDTO buscarPorTurma(String turma) {

        Aluno aluno = repository.findByTurma(turma)
                .orElseThrow(() ->
                        new ValidacaoException("Aluno não encontrado."));

        return converterParaDTO(aluno);
    }

    // Salvar
    public Aluno salvar(CreateAlunoDTO dto) {

        Aluno aluno = new Aluno();

        aluno.setNomeCompleto(dto.getNomeCompleto());
        aluno.setDataNascimento(dto.getDataNascimento());
        aluno.setEndereco(dto.getEndereco());
        aluno.setSexo(dto.getSexo());
        aluno.setRg(dto.getRg());
        aluno.setCpf(dto.getCpf().toString());

        aluno.setNomeResponsavel(dto.getNomeResponsavel());
        aluno.setGrauParentesco(dto.getGrauParentesco());
        aluno.setDataNascimentoResponsavel(dto.getDataNascimentoResponsavel());

        aluno.setContato(dto.getContato());
        aluno.setEmail(dto.getEmail());
        aluno.setLogin(dto.getLogin());
        aluno.setSenha(dto.getSenha());
        aluno.setPerfilLogin(dto.getPerfilLogin());
        aluno.setInstituicao(dto.getInstituicao());

        aluno.setModalidade(dto.getModalidade());
        aluno.setTurma(dto.getTurma());
        aluno.setTurno(dto.getTurno());

        return repository.save(aluno);
    }

    // Atualizar
    public Aluno atualizar(Long id, CreateAlunoDTO dto) {

        Aluno aluno = repository.findById(id)
                .orElseThrow(() ->
                        new ValidacaoException("Aluno não encontrado."));

        aluno.setNomeCompleto(dto.getNomeCompleto());
        aluno.setDataNascimento(dto.getDataNascimento());
        aluno.setEndereco(dto.getEndereco());
        aluno.setSexo(dto.getSexo());
        aluno.setRg(dto.getRg());
        aluno.setCpf(dto.getCpf().toString());

        aluno.setNomeResponsavel(dto.getNomeResponsavel());
        aluno.setGrauParentesco(dto.getGrauParentesco());
        aluno.setDataNascimentoResponsavel(dto.getDataNascimentoResponsavel());

        aluno.setContato(dto.getContato());
        aluno.setEmail(dto.getEmail());
        aluno.setLogin(dto.getLogin());
        aluno.setSenha(dto.getSenha());
        aluno.setPerfilLogin(dto.getPerfilLogin());
        aluno.setInstituicao(dto.getInstituicao());

        aluno.setModalidade(dto.getModalidade());
        aluno.setTurma(dto.getTurma());
        aluno.setTurno(dto.getTurno());

        return repository.save(aluno);
    }

    // Deletar
    public void deletar(Long id) {

        Aluno aluno = repository.findById(id)
                .orElseThrow(() ->
                        new ValidacaoException("Aluno não encontrado."));

        repository.delete(aluno);
    }

    // Converter para DTO
    private AlunoDTO converterParaDTO(Aluno aluno) {

        return AlunoDTO.builder()
                .nomeCompleto(aluno.getNomeCompleto())
                .sexo(aluno.getSexo())
                .contato(aluno.getContato())
                .email(aluno.getEmail())
                .instituicao(aluno.getInstituicao())
                .modalidade(aluno.getModalidade())
                .turma(aluno.getTurma())
                .turno(aluno.getTurno())
                .build();
    }

}