package com.validacao.Attestify.Now.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.validacao.Attestify.Now.dto.LoginDTO;
import com.validacao.Attestify.Now.model.Usuario;
import com.validacao.Attestify.Now.services.LoginService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    public ResponseEntity<Usuario> login(@Valid @RequestBody LoginDTO dto) {

        Usuario usuario = loginService.login(dto);

        return ResponseEntity.ok(usuario);
    }
}
