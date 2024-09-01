package com.lab.sistema_de_matriculas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lab.sistema_de_matriculas.model.Disciplina;
import com.lab.sistema_de_matriculas.repository.DisciplinaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Transactional
    public Disciplina salvarDisciplina(Disciplina disciplina){
        return disciplinaRepository.save(disciplina);
    }

    public Optional<Disciplina> encontrarDisciplinaPorId(Long id) {
        return disciplinaRepository.findById(id);
    }

    public List<Disciplina> encontrarTodasAsDisciplinas() {
        return disciplinaRepository.findAll();
    }
    
    @Transactional
    public Disciplina atualizarDisciplina(Long id, Disciplina disciplinaAtualizada) {
        Optional<Disciplina> disciplinaExistente = disciplinaRepository.findById(id);

        if(disciplinaExistente.isPresent()){
            Disciplina disciplina = disciplinaExistente.get();
            disciplina.setNome(disciplinaAtualizada.getNome());
            disciplina.setEmenta(disciplinaAtualizada.getEmenta());
            disciplina.setCreditos(disciplinaAtualizada.getCreditos());
            disciplina.setCurso(disciplinaAtualizada.getCurso());
            return disciplinaRepository.save(disciplina);
        }else{
            throw new RuntimeException("Disciplina com ID " + id + " não encontrada.");
        }
    }

    @Transactional
    public void deletarDisciplinaPorId(Long id){
        if(disciplinaRepository.existsById(id)){
            disciplinaRepository.deleteById(id);
        }else{
            throw new RuntimeException("Disicplina com ID " + id + " não encontrada.");
        }
    }
}
