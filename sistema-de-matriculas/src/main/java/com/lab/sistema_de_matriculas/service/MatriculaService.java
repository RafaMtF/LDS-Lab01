package com.lab.sistema_de_matriculas.service;

import com.lab.sistema_de_matriculas.model.Matricula;
import com.lab.sistema_de_matriculas.model.Aluno;
import com.lab.sistema_de_matriculas.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    public List<Matricula> findAll() {
        return matriculaRepository.findAll();
    }

    public Optional<Matricula> findById(Long idMatricula) {
        return matriculaRepository.findById(idMatricula);
    }

    public Matricula save(Matricula matricula) {
        return matriculaRepository.save(matricula);
    }

    public void deleteById(Long idMatricula) {
        matriculaRepository.deleteById(idMatricula);
    }

    public List<Matricula> findByAluno(Aluno aluno) {
        return matriculaRepository.findByAluno(aluno);
    }

    public List<Matricula> findByIsActive(Boolean isActive) {
        return matriculaRepository.findByIsActive(isActive);
    }
}
