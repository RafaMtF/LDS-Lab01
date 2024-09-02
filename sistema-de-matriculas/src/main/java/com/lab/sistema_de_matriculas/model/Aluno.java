package com.lab.sistema_de_matriculas.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "curso")
public class Aluno {

    @Id
    @Column(name = "matricula_do_aluno", nullable = false)
    private String matriculaDoAluno;

    @Column(name = "nome", nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;

    public String getMatriculaDoAluno() {
        return matriculaDoAluno;
    }

    public void setMatriculaDoAluno(String matriculaDoAluno) {
        this.matriculaDoAluno = matriculaDoAluno;
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
