package com.validacao.Attestify.Now.service;

import com.validacao.Attestify.Now.dto.ProfissionalDTO;
import com.validacao.Attestify.Now.dto.CreateProfissionalDTO;
import com.validacao.Attestify.Now.exceptions.ValidacaoException;
import com.validacao.Attestify.Now.model.Profissional;
import com.validacao.Attestify.Now.repositories.ProfissionalRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ProfissionalService {

    private final ProfissionalRepository profissionalRepository;

    // Método para listar todos os profissionais
    public List<ProfissionalDTO> listarTodos() {
        return profissionalRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Método para buscar um profissional pelo ID
    public ProfissionalDTO pegarProfissionalPeloId(Long id) {
        return profissionalRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new ValidacaoException("Profissional não encontrado com ID: " + id));
    }

    // Método para buscar profissionais pelo nome completo
    public List<ProfissionalDTO> pegarProfissionalPeloNome(String nomeCompleto) {
        return profissionalRepository.findByNomeCompleto(nomeCompleto)
                .map(List::of)
                .orElse(List.of()).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Método para buscar profissionais pelo cargo
    public List<ProfissionalDTO> pegarProfissionalPorCargo(String cargo) {
        return profissionalRepository.findByCargo(cargo)
                .map(List::of)
                .orElse(List.of()).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Método para criar um novo profissional
    public Profissional saveProfissional(CreateProfissionalDTO profissionalDTO) {
        Profissional profissional = new Profissional();
        profissional.setNomeCompleto(profissionalDTO.getNomeCompleto());
        profissional.setDataNascimento(profissionalDTO.getDataNascimento());
        profissional.setEndereco(profissionalDTO.getEndereco());
        profissional.setSexo(profissionalDTO.getSexo());
        profissional.setRg(profissionalDTO.getRg());
        profissional.setCpf(profissionalDTO.getCpf());
        profissional.setContato(profissionalDTO.getContato());
        profissional.setEmail(profissionalDTO.getEmail());
        profissional.setLogin(profissionalDTO.getLogin());
        profissional.setSenha(profissionalDTO.getSenha());
        profissional.setPerfilLogin(profissionalDTO.getPerfilLogin());
        profissional.setInstituicao(profissionalDTO.getInstituicao());
        profissional.setCargo(profissionalDTO.getCargo());
        return profissionalRepository.save(profissional);
    }

    // Método para atualizar um profissional existente
    public Profissional atualizarProfissional(CreateProfissionalDTO profissionalDTO, Long id) {
        Profissional profissional = profissionalRepository.findById(id)
                .orElseThrow(() -> new ValidacaoException("Profissional não encontrado com ID: " + id));
        
        profissional.setNomeCompleto(profissionalDTO.getNomeCompleto());
        profissional.setDataNascimento(profissionalDTO.getDataNascimento());
        profissional.setEndereco(profissionalDTO.getEndereco());
        profissional.setSexo(profissionalDTO.getSexo());
        profissional.setRg(profissionalDTO.getRg());
        profissional.setCpf(profissionalDTO.getCpf());
        profissional.setContato(profissionalDTO.getContato());
        profissional.setEmail(profissionalDTO.getEmail());
        profissional.setLogin(profissionalDTO.getLogin());
        profissional.setSenha(profissionalDTO.getSenha());
        profissional.setPerfilLogin(profissionalDTO.getPerfilLogin());
        profissional.setInstituicao(profissionalDTO.getInstituicao());
        profissional.setCargo(profissionalDTO.getCargo());
        return profissionalRepository.save(profissional);
    }

    // Método para deletar um profissional pelo ID
    public void deletarProfissional(Long id) {
        if (!profissionalRepository.existsById(id)) {
            throw new ValidacaoException("Profissional não encontrado com ID: " + id);
        }
        profissionalRepository.deleteById(id);
    }

    // Método para converter a entidade Profissional para DTO
    private ProfissionalDTO convertToDTO(Profissional profissional) {
        return new ProfissionalDTO(
                profissional.getIdProfissional(),
                profissional.getNomeCompleto(),
                profissional.getDataNascimento(),
                profissional.getEndereco(),
                profissional.getSexo(),
                profissional.getRg(),
                profissional.getCpf(),
                profissional.getContato(),
                profissional.getEmail(),
                profissional.getLogin(),
                profissional.getSenha(),
                profissional.getPerfilLogin(),
                profissional.getInstituicao(),
                profissional.getCargo()
        );
    }
}
