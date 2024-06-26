package com.validacao.Attestify.Now.controller;

import com.validacao.Attestify.Now.dto.LoginDTO;
import com.validacao.Attestity.Now.service.LoginService;
import com.validacao.Attestify.Now.model.Profissional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.net.http.HttpClient;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/login")
public class LoginController {
    
    private final LoginService service;
    
    // login para administrador
    @PostMapping("/login/admin")
    public ResponseEntity<?> loginAdmin(@Valid @RequestBody LoginAdminDTO loginAdminDTO) {

        var admin = loginService.validaLoginAdmin(loginAdminDTO);

        return ResponseEntity.ok().body(admin);
    }    

    // login para profissional educador e não educador
    @PostMapping("/login/profissional")
    public ResponseEntity<?> loginProfissional(@Valid @RequestBody LoginProfissionalDTO loginProfissionalDTO) {

        var profissional = loginService.validaLoginProfissional(loginProfissionalDTO);

        // Verifica se o profissional é educador ou não educador
        if ("educador".equals(profissional.getCargo())) {
            
            return ResponseEntity.ok().body("Seu perfil é Educador!");
        } else {
            return ResponseEntity.ok().body("Seu perfil não é Educador!");
        }
        
        return ResponseEntity.ok().body(profissional);
    }

    // login para aluno 
    @PostMapping("/login/aluno")
    public ResponseEntity<?> loginAluno(@Valid @RequestBody LoginDTO loginDTO) {
        
        var aluno = loginService.validaLoginAluno(loginDTO);
        
        return ResponseEntity.ok().body(aluno);
    }
    
        }
