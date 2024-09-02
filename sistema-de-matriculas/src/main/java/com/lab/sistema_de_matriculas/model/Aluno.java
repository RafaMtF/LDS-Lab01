package com.lab.sistema_de_matriculas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "aluno")
public class Aluno {

    @Id
    @Column(name = "matricula_do_aluno", nullable = false)
    private Long matriculaDoAluno;

    @Column(name = "nome", nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "idCurso", nullable = false)
    private Curso curso;

    public Long getMatriculaDoAluno() {
        return matriculaDoAluno;
    }

    public void setMatriculaDoAluno(Long idAluno) {
        this.matriculaDoAluno = idAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
