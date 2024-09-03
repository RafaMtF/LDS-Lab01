package com.lab.sistema_de_matriculas.repository;

import com.lab.sistema_de_matriculas.model.ListaTurmasDoAluno;
import com.lab.sistema_de_matriculas.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListaTurmasDoAlunoRepository extends JpaRepository<ListaTurmasDoAluno, Long> {
    List<ListaTurmasDoAluno> findByAluno(Aluno aluno);
}