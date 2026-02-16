package com.validacao.Attestify.Now.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateProfissionalDTO {
    
    @NotBlank(message = "Nome completo é um campo obrigatório!")
    private String nomeCompleto;
    
    @NotNull(message = "Data de nascimento é um campo obrigatório!")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dataNascimento;
    
    @NotBlank(message = "Endereço é um campo obrigatório!")
    private String endereco;
    
    @NotBlank(message = "sexo é um campo obrigatório!")
    private String sexo;
    
    @NotBlank(message = "RG é um campo obrigatório!")
    private String rg;
    
    @NotNull(message = "CPF é um campo obrigatório!")
    private Long cpf;
    
    @NotBlank(message = "Telefone é um campo obrigatório!")
    private String contato;
    
    @NotBlank(message = "E-mail é um campo obrigatório!")
    @Email(message = "")
    private String email;
    
    @NotBlank(message = "Criar login é um campo obrigatório!")
    private String login;
    
    @NotBlank(message = "Criar senha é um campo obrigatório!")
    private String senha;
    
    @NotBlank(message = "Tipo de perfil é um campo obrigatório!")
    private String perfilLogin;
    
    @NotBlank(message = "Instituição é um campo obrigatório!")
    private String instituicao;
    
    @NotBlank(message = "Cargo é um campo obrigatório!")
    private String cargo;
}