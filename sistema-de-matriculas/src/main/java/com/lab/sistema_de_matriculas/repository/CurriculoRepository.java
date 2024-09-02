package com.lab.sistema_de_matriculas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lab.sistema_de_matriculas.model.Curriculo;

public interface CurriculoRepository extends JpaRepository<Curriculo, Long> {
    
}