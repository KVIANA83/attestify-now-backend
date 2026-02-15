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
@Table(name = "atestado")
public class Atestado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atestado")
    private Long idAtestado;
    
    @Column(name = "url_arquivo")
    private String urlArquivo;
    
    @Column
    private String status;
    
    @Column(name = "data_solicitacao")
    private LocalDate dataSolicitacao;
    
    @Column(name = "data_entrega")
    private LocalDate dataEntrega;

    // muitos atestados podem ser do mesmo profissional
    @ManyToOne
    @JoinColumn(name = "fk_profissional_id_profissional")
    private Profissional profissional;

    // muitos atestados podem ser do mesmo aluno
    @ManyToOne
    @JoinColumn(name = "fk_aluno_id_aluno")
    private Aluno aluno;
    
}