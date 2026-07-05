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
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "profissional")
@PrimaryKeyJoinColumn(name = "usuario_id")
public class Profissional extends Usuario {
    
    @Column
    private String cargo;

}