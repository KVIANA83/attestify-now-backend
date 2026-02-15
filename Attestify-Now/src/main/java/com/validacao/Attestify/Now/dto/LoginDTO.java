package com.validacao.Attestify.Now.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {
    
    @NotBlank(message = "Login é um campo obrigatório!")
    private String login; 
    
    @NotBlank(message = "Senha é um campo obrigatório!")
    private String senha;
    
}