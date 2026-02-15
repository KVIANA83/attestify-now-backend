package com.validacao.Attestify.Now.controller;

import com.validacao.Attestify.Now.dto.LoginDTO;
import com.validacao.Attestify.Now.model.Usuario;
import com.validacao.Attestify.Now.services.LoginService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private final LoginService service = null;

    @PostMapping
    public ResponseEntity<Usuario> login(@Valid @RequestBody LoginDTO dto) {
        return ResponseEntity.ok(service.login(dto));
    }
}
