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
@Table(name = "administradores")
public class Administradores {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_administradores")
    private Long idAdministradores;
    
    @Column(name = "nome_completo")
    private String nomeCompleto;
    
   
    @Column
    private String cargo;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "fk_atestado_id_atestado")
    private Atestado atestado;

}