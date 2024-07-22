package com.validacao.Attestify.Now.service;

import org.springframework.stereotype.Service;

import com.validacao.Attestify.Now.dto.LoginDTO;
import com.validacao.Attestify.Now.dto.LoginProfissionalDTO;
import com.validacao.Attestify.Now.dto.LoginAdminDTO;
import com.validacao.Attestify.Now.exceptions.ValidacaoException;
import com.validacao.Attestify.Now.model.Administradores;
import com.validacao.Attestify.Now.model.Profissional;
import com.validacao.Attestify.Now.model.Aluno;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class LoginService {
    
    private final AdministradoresService administradoresService;
    private final ProfissionalService profissionalService;    
    private final AlunoService alunoService;
    
    // login para administrador
    public Administradores validaLoginAdmin(LoginAdminDTO loginAdminDTO) {

        var adminOpt = administradoresService.getAdmin(loginAdminDTO.getUsername());

        if (adminOpt.isEmpty()) {
            throw new ValidacaoException("Administrador não cadastrado!");
        }

        var admin = adminOpt.get();
        if (!loginAdminDTO.getPassword().equals(admin.getSenha())) {
            throw new ValidacaoException("Login ou senha incorretos!");
        }

        return admin;
    }    
    
    // login para profissional educador e não educador
    public Profissional validaLoginProfissional(LoginProfissionalDTO loginProfissionalDTO) {

        var profissionalOpt = profissionalService.getProfissional(loginProfissionalDTO.getUsername());

        if (profissionalOpt.isEmpty()) {
            throw new ValidacaoException("Profissional não cadastrado!");
        }

        var profissional = profissionalOpt.get();
        
        // Verifica se o profissional é educador
        if (!"educador".equals(profissional.getCargo())) {
            throw new ValidacaoException("Somente Profissionais Educadores podem fazer login aqui!");
        }
        
        if (!loginProfissionalDTO.getPassword().equals(profissional.getSenha())) {
            throw new ValidacaoException("Login ou senha incorretos!");
        }

        return profissional;
    }    
    
    // login para alunos
    public Aluno validaLoginAluno(LoginDTO loginDTO) {

        var alunoOpt = alunoService.getAluno(loginDTO.getUsername());

        if (alunoOpt.isEmpty()) {
            throw new ValidacaoException("Aluno não encontrado. Favor entrar em contato com a secretaria!");
        }

        var aluno = alunoOpt.get();
        if (!loginDTO.getPassword().equals(aluno.getSenha())) {
            throw new ValidacaoException("Login ou senha incorretos!");
        }

        return aluno;
    }    
}
