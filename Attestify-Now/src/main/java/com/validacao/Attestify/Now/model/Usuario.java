package com.validacao.Attestify.Now.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = jakarta.persistence.InheritanceType.JOINED)
@Table(name = "usuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

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
    private String cpf;

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

}
