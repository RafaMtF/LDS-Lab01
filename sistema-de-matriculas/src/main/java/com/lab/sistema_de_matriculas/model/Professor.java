package com.lab.sistema_de_matriculas.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "professor")
public class Professor {
    @Id
    private int codigoPessoa;
    private String nome;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Turma> turmas;

    // Getters e setters
    public int getCodigoPessoa() {
        return codigoPessoa;
    }

    public void setCodigoPessoa(int codigoPessoa) {
        this.codigoPessoa = codigoPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Métodos
    void adicionarTurma(Turma turma) {
        this.turmas.add(turma);
    }

    List<Aluno> getAlunosPorTurma() {
        List<Aluno> alunos = new ArrayList<>();
        
        for (Turma turma : turmas) {
            alunos.addAll(turma.getAlunos());
        }
    
        return alunos;
    }
}
