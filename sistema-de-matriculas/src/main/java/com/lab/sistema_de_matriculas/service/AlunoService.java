package com.lab.sistema_de_matriculas.service;

import com.lab.sistema_de_matriculas.model.Aluno;
import com.lab.sistema_de_matriculas.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> findById(Long matriculaDoAluno) {
        return alunoRepository.findById(matriculaDoAluno);
    }

    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    public void deleteById(Long matriculaDoAluno) {
        alunoRepository.deleteById(matriculaDoAluno);
    }
}
