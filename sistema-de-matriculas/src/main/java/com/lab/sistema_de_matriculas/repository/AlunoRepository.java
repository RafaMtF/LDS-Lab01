package com.lab.sistema_de_matriculas.repository;

import com.lab.sistema_de_matriculas.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, String> {
}
