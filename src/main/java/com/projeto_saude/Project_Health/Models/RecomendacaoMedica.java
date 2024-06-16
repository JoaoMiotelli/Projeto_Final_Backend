package com.projeto_saude.Project_Health.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class RecomendacaoMedica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @NotNull
    private AtendimentoMedico atendimentoMedico;
    
    @NotEmpty
    private String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AtendimentoMedico getAtendimentoMedico() {
        return atendimentoMedico;
    }

    public void setAtendimentoMedico(AtendimentoMedico atendimentoMedico) {
        this.atendimentoMedico = atendimentoMedico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}