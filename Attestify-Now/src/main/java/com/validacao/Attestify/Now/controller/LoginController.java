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
    public ResponseEntity<?> loginAdmin(@Valid @RequestBody LoginDTO loginDTO) {

        var admin = loginService.validaLoginAdmin(loginDTO);

        return ResponseEntity.ok().body(admin);
    }    

    // login para profissional educador e não educador
    @PostMapping("/login/profissional")
    public ResponseEntity<?> loginProfissional(@Valid @RequestBody LoginDTO loginDTO) {

        var profissional = loginService.validaLoginProfissional(loginDTO);

        // Verifica se o profissional é educador ou não educador
        if ("educador".equals(profissional.getCargo())) {
            
        } else {
            
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