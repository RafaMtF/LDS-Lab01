package com.lab.sistema_de_matriculas.repository;

import com.lab.sistema_de_matriculas.model.ListaDisciplinasDoCurriculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListaDisciplinasDoCurriculoRepository extends JpaRepository<ListaDisciplinasDoCurriculo, Long> {
    List<ListaDisciplinasDoCurriculo> findByCurriculoIdCurriculo(Long curriculoId);
}
