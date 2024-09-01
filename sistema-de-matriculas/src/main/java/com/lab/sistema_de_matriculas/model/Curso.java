package com.lab.sistema_de_matriculas.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "curso")
public class Curso {
    @Id
    private long idCurso;
    private String nome;
    private String descricao;
    private int creditosPraFormar;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Disciplina> disciplinas;

    // Getters e setters
    public Long getIdCurso() {
        return idCurso;
    }
    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public int getCreditosPraFormar() {
        return creditosPraFormar;
    }
    public void setCreditosPraFormar(int creditosPraFormar) {
        this.creditosPraFormar = creditosPraFormar;
    }
    public Set<Disciplina> getDisciplinas() {
        return disciplinas;
    }
    public void setDisciplinas(Set<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
}
