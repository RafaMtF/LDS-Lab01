package com.lab.sistema_de_matriculas.service;

import com.lab.sistema_de_matriculas.model.ListaTurmasDoAluno;
import com.lab.sistema_de_matriculas.model.Aluno;
import com.lab.sistema_de_matriculas.repository.ListaTurmasDoAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListaTurmasDoAlunoService {

    @Autowired
    private ListaTurmasDoAlunoRepository listaTurmasDoAlunoRepository;

    public List<ListaTurmasDoAluno> findAll() {
        return listaTurmasDoAlunoRepository.findAll();
    }

    public Optional<ListaTurmasDoAluno> findById(Long idLista) {
        return listaTurmasDoAlunoRepository.findById(idLista);
    }

    public ListaTurmasDoAluno save(ListaTurmasDoAluno listaTurmasDoAluno) {
        return listaTurmasDoAlunoRepository.save(listaTurmasDoAluno);
    }

    public void deleteById(Long idLista) {
        listaTurmasDoAlunoRepository.deleteById(idLista);
    }

    public List<ListaTurmasDoAluno> findByAluno(Aluno aluno) {
        return listaTurmasDoAlunoRepository.findByAluno(aluno);
    }
}