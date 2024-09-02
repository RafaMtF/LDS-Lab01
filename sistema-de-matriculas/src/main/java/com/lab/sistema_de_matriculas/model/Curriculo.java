package com.lab.sistema_de_matriculas.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "curriculo")
public class Curriculo {

    @Id
    @Column(name = "id_curriculo", nullable = false)
    private Long idCurriculo;

    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;

    @Column(name = "semestre", nullable = false)
    private Integer semestre;

    @Column(name = "ano", nullable = false)
    private Integer ano;

    public Long getIdCurriculo() {
        return idCurriculo;
    }

    public void setIdCurriculo(Long idCurriculo) {
        this.idCurriculo = idCurriculo;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }
}