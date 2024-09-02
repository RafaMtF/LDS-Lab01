package com.lab.sistema_de_matriculas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lab.sistema_de_matriculas.model.Turma;
import java.util.List;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
    List<Turma> findAll();
}
