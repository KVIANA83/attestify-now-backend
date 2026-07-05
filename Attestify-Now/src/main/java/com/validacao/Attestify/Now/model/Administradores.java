package com.validacao.Attestify.Now.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "administradores")
@PrimaryKeyJoinColumn(name = "usuario_id")
public class Administradores extends Usuario {
    
    @Column
    private String cargo;
    
    @ManyToOne
    @JoinColumn(name = "fk_atestado_id_atestado")
    private Atestado atestado;

}