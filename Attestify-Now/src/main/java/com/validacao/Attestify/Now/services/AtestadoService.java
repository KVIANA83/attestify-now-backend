package com.validacao.Attestify.Now.services;

import com.validacao.Attestify.Now.dto.AtestadoDTO;
import com.validacao.Attestify.Now.exceptions.ValidacaoException;
import com.validacao.Attestify.Now.model.Atestado;
import com.validacao.Attestify.Now.model.Administradores;
import com.validacao.Attestify.Now.model.Aluno;
import com.validacao.Attestify.Now.model.Profissional;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.validacao.Attestify.Now.repository.AtestadoRepository;

@       
@Service
public class AtestadoService {

    private final AtestadoRepository atestadoRepository;

    // Método para listar todos os atestados
    public List<AtestadoDTO> listarTodos() {
        return atestadoRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Buscar atestados por nome do aluno
    public List<AtestadoDTO> buscarPorAluno(Aluno aluno) {
        return atestadoRepository.findByAluno(aluno)
                .orElseThrow(() -> new ValidacaoException("Nenhum atestado encontrado para o aluno: " + aluno.getNomeCompleto()))
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Buscar atestados por turma do aluno
    public List<AtestadoDTO> buscarPorTurma(String turma) {
        List<Atestado> atestados = atestadoRepository.findByAlunoTurma(turma)
                .orElseThrow(() -> new ValidacaoException("Nenhum atestado encontrado para a turma: " + turma));
        return atestados.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Buscar atestados por curso do aluno
    public List<AtestadoDTO> buscarPorCurso(String curso) {
        List<Atestado> atestados = atestadoRepository.findByAlunoCurso(curso)
                .orElseThrow(() -> new ValidacaoException("Nenhum atestado encontrado para o curso: " + curso));
        return atestados.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Buscar atestados por nome do profissional
    public List<AtestadoDTO> buscarPorProfissional(Profissional profissional) {
        return atestadoRepository.findByProfissional(profissional)
                .orElseThrow(() -> new ValidacaoException("Nenhum atestado encontrado para o profissional: " + profissional.getNomeCompleto()))
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Buscar atestados por cargo do profissional
    public List<AtestadoDTO> buscarPorCargoProfissional(String cargo) {
        List<Atestado> atestados = atestadoRepository.findByProfissionalCargo(cargo)
                .orElseThrow(() -> new ValidacaoException("Nenhum atestado encontrado para o cargo: " + cargo));
        return atestados.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Buscar atestados sem administrador
    public List<AtestadoDTO> buscarSemAdministrador() {
        List<Atestado> atestados = atestadoRepository.findByAdministradoresIsNull()
                .orElseThrow(() -> new ValidacaoException("Nenhum atestado encontrado sem administrador."));
        return atestados.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Buscar atestados com administrador
    public List<AtestadoDTO> buscarComAdministrador(Administradores administrador) {
        return atestadoRepository.findByAdministradores(administrador)
                .orElseThrow(() -> new ValidacaoException("Nenhum atestado encontrado para o administrador: " + administrador.getNome()))
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Método para converter a entidade Atestado para DTO
    private AtestadoDTO convertToDTO(Atestado atestado) {
        return new AtestadoDTO(
                atestado.getIdAtestado(),
                atestado.getUrlArquivo(),
                atestado.getStatus(),
                atestado.getDataSolicitacao(),
                atestado.getDataEntrega(),
                atestado.getDataValidacao(),
                atestado.getAluno() != null ? atestado.getAluno().getNomeCompleto() : null,
                atestado.getProfissional() != null ? atestado.getProfissional().getNomeCompleto() : null,
                atestado.getAdministradores().stream().map(Administradores::getNome).collect(Collectors.toSet())
        );
    }
}
