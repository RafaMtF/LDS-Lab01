package com.lab.sistema_de_matriculas.repository;

import com.lab.sistema_de_matriculas.model.Matricula;
import com.lab.sistema_de_matriculas.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
    
    List<Matricula> findByAluno(Aluno aluno);

    List<Matricula> findByIsActive(Boolean isActive);
}
