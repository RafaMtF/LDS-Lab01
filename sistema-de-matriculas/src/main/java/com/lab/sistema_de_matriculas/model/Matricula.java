package com.lab.sistema_de_matriculas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "matricula")
public class Matricula {

    @Id
    @Column(name = "id_matricula", nullable = false)
    private Long idMatricula;

    @ManyToOne
    @JoinColumn(name = "id_aluno", nullable = false)
    private Aluno aluno;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    public Long getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(Long idMatricula) {
        this.idMatricula = idMatricula;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
