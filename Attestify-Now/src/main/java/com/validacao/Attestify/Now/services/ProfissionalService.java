package com.validacao.Attestify.Now.services;

import com.validacao.Attestify.Now.dto.ProfissionalDTO;
import com.validacao.Attestify.Now.dto.CreateProfissionalDTO;
import com.validacao.Attestify.Now.exceptions.ValidacaoException;
import com.validacao.Attestify.Now.model.Profissional;
import com.validacao.Attestify.Now.repositories.ProfissionalRepository;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.validacao.Attestify.Now.repository.ProfissionalRepository;

@Service
@AllArgsConstructor
public class ProfissionalService {

    private final ProfissionalRepository repository = null;

    // Método para listar todos os profissionais
    public List<ProfissionalDTO> listarTodos() {
        return repository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    // Método para buscar um profissional pelo ID
    public ProfissionalDTO pegarProfissionalPeloId(Long id) {
        return repository.findById(id)
                .map(this::converterParaDTO)
                .orElseThrow(() -> new ValidacaoException("Profissional não encontrado!"));
    }


    // Método para buscar profissionais pelo nome completo
    public List<ProfissionalDTO> pegarProfissionalPeloNome(String nome) {
        return repository.findByNomeCompleto(nome)
                .stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    // Método para buscar profissionais pelo cargo
    public List<ProfissionalDTO> pegarProfissionalPorCargo(String cargo) {
        return repository.findByCargo(cargo)
                .stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    // Método para criar um novo profissional
    public void saveProfissional(CreateProfissionalDTO dto) {
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

        repository.save(profissional);
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
        if (!repository.existsById(id)) {
            throw new ValidacaoException("Profissional não encontrado!");
        }
        repository.deleteById(id);
    }

    // Método para converter a entidade Profissional para DTO
   private ProfissionalDTO converterParaDTO(Profissional p) {
        return ProfissionalDTO.builder()
                .idProfissional(p.getIdProfissional())
                .nomeCompleto(p.getNomeCompleto())
                .email(p.getEmail())
                .contato(p.getContato())
                .instituicao(p.getInstituicao())
                .perfilLogin(p.getPerfilLogin())
                .cargo(p.getCargo())
                .build();
    }
}
