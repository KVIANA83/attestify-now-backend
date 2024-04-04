package com.validacao.Attestify.Now.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "profissional")
public class Profissional {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profissional")
    private Long idProfissional;
    
    @Column(name = "nome_completo")
    private String nomeCompleto;
    
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    
    @Column
    private String endereco;
    
    @Column
    private String sexo;
    
    @Column
    private String rg;
    
    @Column
    private Long cpf;
    
    @Column
    private String contato;
    
    @Column
    private String email;
    
    @Column
    private String login;
    
    @Column
    private String senha;
    
    @Column(name = "perfil_login")
    private String perfilLogin;
    
    @Column
    private String instituicao;
    
    @Column
    private String cargo;
}