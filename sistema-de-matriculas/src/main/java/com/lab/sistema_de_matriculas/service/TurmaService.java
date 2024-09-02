package com.lab.sistema_de_matriculas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lab.sistema_de_matriculas.model.Turma;
import com.lab.sistema_de_matriculas.repository.TurmaRepository;

import java.util.List;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    public Turma salvarTurma(Turma turma) {
        return turmaRepository.save(turma);
    }

    public List<Turma> getAllTurmas() {
        return turmaRepository.findAll();
    }

    public Turma getTurmaById(Long id) {
        return turmaRepository.findById(id).orElse(null);
    }

    public void deleteTurma(Long id) {
        turmaRepository.deleteById(id);
    }
}

