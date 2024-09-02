package com.lab.sistema_de_matriculas.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "disciplina")
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String ementa;
    private int creditos;
    private boolean isObrigatoria;

    @ManyToOne
    @JsonManagedReference
    private Curso curso;

    @OneToMany(mappedBy = "disciplina")
    private Set<Turma> turmas;

    // Getters e setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmenta() {
        return ementa;
    }
    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }
    public int getCreditos() {
        return creditos;
    }
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }
    public Curso getCurso() {
        return curso;
    }
    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public boolean isObrigatoria() {
        return isObrigatoria;
    }

    public void setObrigatoria(boolean isObrigatoria) {
        this.isObrigatoria = isObrigatoria;
    }

    // Metodos
    void adicionarTurma(Turma turma) {
        this.turmas.add(turma);
    }
}
