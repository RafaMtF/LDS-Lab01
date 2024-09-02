package com.lab.sistema_de_matriculas.service;

import com.lab.sistema_de_matriculas.model.ListaAlunosDaTurma;
import com.lab.sistema_de_matriculas.model.Turma;
import com.lab.sistema_de_matriculas.repository.ListaAlunosDaTurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListaAlunosDaTurmaService {

    @Autowired
    private ListaAlunosDaTurmaRepository listaAlunosDaTurmaRepository;

    public List<ListaAlunosDaTurma> findAll() {
        return listaAlunosDaTurmaRepository.findAll();
    }

    public Optional<ListaAlunosDaTurma> findById(Long idLista) {
        return listaAlunosDaTurmaRepository.findById(idLista);
    }

    public ListaAlunosDaTurma save(ListaAlunosDaTurma listaAlunosDaTurma) {
        return listaAlunosDaTurmaRepository.save(listaAlunosDaTurma);
    }

    public void deleteById(Long idLista) {
        listaAlunosDaTurmaRepository.deleteById(idLista);
    }

    public List<ListaAlunosDaTurma> findByTurma(Turma turma) {
        return listaAlunosDaTurmaRepository.findByTurma(turma);
    }
}
