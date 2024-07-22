package com.validacao.Attestify.Now.service;

import com.validacao.Attestify.Now.dto.AlunoDTO;
import com.validacao.Attestify.Now.dto.CreateAlunoDTO;
import com.validacao.Attestify.Now.exceptions.ValidacaoException;
import com.validacao.Attestify.Now.model.Aluno;
import com.validacao.Attestify.Now.repositories.AlunoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    // Método para listar todos os alunos
    public List<AlunoDTO> listarTodos() {
        return alunoRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Método para buscar alunos pelo nome completo
    public List<AlunoDTO> pegarAlunoPeloNome(String nomeCompleto) {
        return alunoRepository.findByNomeCompleto(nomeCompleto)
                .map(List::of)
                .orElse(List.of()).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Método para buscar alunos pela turma
    public List<AlunoDTO> pegarAlunoPorTurma(String turma) {
        return alunoRepository.findByTurma(turma)
                .map(List::of)
                .orElse(List.of()).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Método para buscar alunos pelo curso
    public List<AlunoDTO> pegarAlunoPorCurso(String curso) {
        return alunoRepository.findByCurso(curso)
                .map(List::of)
                .orElse(List.of()).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Método para criar um novo aluno
    public Aluno saveAluno(CreateAlunoDTO alunoDTO) {
        Aluno aluno = new Aluno();
        aluno.setNomeCompleto(alunoDTO.getNomeCompleto());
        aluno.setDataNascimento(alunoDTO.getDataNascimento());
        aluno.setEndereco(alunoDTO.getEndereco());
        aluno.setSexo(alunoDTO.getSexo());
        aluno.setRg(alunoDTO.getRg());
        aluno.setCpf(alunoDTO.getCpf());
        aluno.setNomeResponsavel(alunoDTO.getNomeResponsavel());
        aluno.setGrauParentesco(alunoDTO.getGrauParentesco());
        aluno.setDataNascimentoResponsavel(alunoDTO.getDataNascimentoResponsavel());
        aluno.setContato(alunoDTO.getContato());
        aluno.setEmail(alunoDTO.getEmail());
        aluno.setLogin(alunoDTO.getLogin());
        aluno.setSenha(alunoDTO.getSenha());
        aluno.setPerfilLogin(alunoDTO.getPerfilLogin());
        aluno.setInstituicao(alunoDTO.getInstituicao());
        aluno.setModalidade(alunoDTO.getModalidade());
        aluno.setTurma(alunoDTO.getTurma());
        aluno.setTurno(alunoDTO.getTurno());
        return alunoRepository.save(aluno);
    }

    // Método para atualizar um aluno existente
    public Aluno atualizarAluno(CreateAlunoDTO alunoDTO, Long id) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new ValidacaoException("Aluno não encontrado com ID: " + id));
        
        aluno.setNomeCompleto(alunoDTO.getNomeCompleto());
        aluno.setDataNascimento(alunoDTO.getDataNascimento());
        aluno.setEndereco(alunoDTO.getEndereco());
        aluno.setSexo(alunoDTO.getSexo());
        aluno.setRg(alunoDTO.getRg());
        aluno.setCpf(alunoDTO.getCpf());
        aluno.setNomeResponsavel(alunoDTO.getNomeResponsavel());
        aluno.setGrauParentesco(alunoDTO.getGrauParentesco());
        aluno.setDataNascimentoResponsavel(alunoDTO.getDataNascimentoResponsavel());
        aluno.setContato(alunoDTO.getContato());
        aluno.setEmail(alunoDTO.getEmail());
        aluno.setLogin(alunoDTO.getLogin());
        aluno.setSenha(alunoDTO.getSenha());
        aluno.setPerfilLogin(alunoDTO.getPerfilLogin());
        aluno.setInstituicao(alunoDTO.getInstituicao());
        aluno.setModalidade(alunoDTO.getModalidade());
        aluno.setTurma(alunoDTO.getTurma());
        aluno.setTurno(alunoDTO.getTurno());
        return alunoRepository.save(aluno);
    }

    // Método para deletar um aluno pelo ID
    public void deletarAluno(Long id) {
        if (!alunoRepository.existsById(id)) {
            throw new ValidacaoException("Aluno não encontrado com ID: " + id);
        }
        alunoRepository.deleteById(id);
    }

    // Método para converter a entidade Aluno para DTO
    private AlunoDTO convertToDTO(Aluno aluno) {
        return new AlunoDTO(
                aluno.getIdAluno(),
                aluno.getNomeCompleto(),
                aluno.getDataNascimento(),
                aluno.getEndereco(),
                aluno.getSexo(),
                aluno.getRg(),
                aluno.getCpf(),
                aluno.getNomeResponsavel(),
                aluno.getGrauParentesco(),
                aluno.getDataNascimentoResponsavel(),
                aluno.getContato(),
                aluno.getEmail(),
                aluno.getLogin(),
                aluno.getSenha(),
                aluno.getPerfilLogin(),
                aluno.getInstituicao(),
                aluno.getModalidade(),
                aluno.getTurma(),
                aluno.getTurno()
        );
    }
}
