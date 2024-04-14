package com.validacao.Attestify.Now.service;

import org.springframework.stereotype.Service;

import com.validacao.Attestify.Now.dto.LoginDTO;
import com.validacao.Attestify.Now.exceptions.ValidacaoException;
import com.validacao.Attestify.Now.model.Administrador;
import com.validacao.Attestify.Now.model.Profissional;    
import com.validacao.Attestify.Now.model.Aluno;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class LoginService {
    
    private final AdministradorService administradorService;
    private final ProfissionalService profissionalService;    
    private final AlunoService alunoService;
    
    // login para administrador
    public Administrador validaLoginAdmin(LoginAdminDTO loginAdminDTO) {

        var adminOpt = administradorService.getAdmin(loginAdminDTO.getUsername());

        if (!adminOpt.isPresent()) {
            throw new ValidacaoException("Administrador não cadastrado!");
        }

        var admin = adminOpt.get();
        if (!loginAdminDTO.getPassword().equals(admin.getSenha())) {
            throw new ValidacaoException("Login ou senha incorretos!");
        }

        return admin;
    }    
    
    // login para profissional educador e nao educador
    public Profissional validaLoginProfissional(LoginDTO loginDTO) {

        var profissionalOpt = profissionalService.getProfissional(loginDTO.getUsername());

        if (!profissionalOpt.isPresent()) {
            throw new ValidacaoException("Profissional não cadastrado!");
        }

        var profissional = profissionalOpt.get();
        
        // Verifica se o profissional é educador
        if (!"educador".equals(profissional.getCargo())) {
            throw new ValidacaoException("Somente Profissional Educador podem fazer login aqui!");
        }
        
        if (!loginDTO.getPassword().equals(profissional.getSenha())) {
            throw new ValidacaoException("Login ou senha incorretos!");
        }

        return profissional;
    }    
    
    // login para alunos
    public Aluno validaLoginAluno(LoginDTO loginDTO) {

        var alunoOpt = alunoService.getAluno(loginDTO.getUsername());

        if (!alunoOpt.isPresent()) {
            throw new ValidacaoException("Aluno não encontrado. Favor entre em contato com a secretaria!");
        }

        var aluno = alunoOpt.get();
        if (!loginDTO.getPassword().equals(aluno.getSenha())) {
            throw new ValidacaoException("Login ou senha incorretos!");
        }

        return aluno;
    }    
    
}