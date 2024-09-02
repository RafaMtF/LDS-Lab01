package com.lab.sistema_de_matriculas.service;

import com.lab.sistema_de_matriculas.model.ListaDisciplinasDoCurriculo;
import com.lab.sistema_de_matriculas.repository.ListaDisciplinasDoCurriculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListaDisciplinasDoCurriculoService {

    @Autowired
    private ListaDisciplinasDoCurriculoRepository listaDisciplinaDoCurriculoRepository;

    public List<ListaDisciplinasDoCurriculo> getAllCurriculoDisciplinas() {
        return listaDisciplinaDoCurriculoRepository.findAll();
    }

    public Optional<ListaDisciplinasDoCurriculo> getCurriculoDisciplinaById(Long id) {
        return listaDisciplinaDoCurriculoRepository.findById(id);
    }

    public List<ListaDisciplinasDoCurriculo> getDisciplinasByCurriculoId(Long curriculoId) {
        return listaDisciplinaDoCurriculoRepository.findByCurriculoIdCurriculo(curriculoId);
    }

    public ListaDisciplinasDoCurriculo saveCurriculoDisciplina(ListaDisciplinasDoCurriculo curriculoDisciplina) {
        return listaDisciplinaDoCurriculoRepository.save(curriculoDisciplina);
    }

    public void deleteCurriculoDisciplina(Long id) {
        listaDisciplinaDoCurriculoRepository.deleteById(id);
    }
}
