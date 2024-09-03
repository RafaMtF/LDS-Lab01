package com.lab.sistema_de_matriculas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;

import java.util.List;

@Entity
public class ListaTurmasDoAluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLista;

    @ManyToOne
    @JoinColumn(name = "idAluno", nullable = false)
    private Aluno aluno;

    @ManyToMany
    @JoinTable(
        name = "lista_turmas",
        joinColumns = @JoinColumn(name = "idLista"),
        inverseJoinColumns = @JoinColumn(name = "idTurma")
    )
    private List<Turma> turmas;

    // Getters and Setters

    public Long getIdLista() {
        return idLista;
    }

    public void setIdLista(Long idLista) {
        this.idLista = idLista;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }
}
