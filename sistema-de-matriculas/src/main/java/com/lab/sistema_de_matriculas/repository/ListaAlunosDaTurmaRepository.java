package com.lab.sistema_de_matriculas.repository;

import com.lab.sistema_de_matriculas.model.ListaAlunosDaTurma;
import com.lab.sistema_de_matriculas.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface  ListaAlunosDaTurmaRepository extends JpaRepository<ListaAlunosDaTurma, Long> {
    List<ListaAlunosDaTurma> findByTurma(Turma turma);
}
