package com.lab.sistema_de_matriculas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lab.sistema_de_matriculas.model.Curso;
import com.lab.sistema_de_matriculas.repository.CursoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Transactional
    public Curso salvarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Optional<Curso> encontrarCursoPorId(Long id) {
        return cursoRepository.findById(id);
    }

    public List<Curso> encontrarTodosOsCursos() {
        return cursoRepository.findAll();
    }

    @Transactional
    public Curso atualizarCurso(Long id, Curso cursoAtualizado) {
        Optional<Curso> cursoExistente = cursoRepository.findById(id);
        if (cursoExistente.isPresent()) {
            Curso curso = cursoExistente.get();
            curso.setNome(cursoAtualizado.getNome());
            curso.setDescricao(cursoAtualizado.getDescricao());
            curso.setCreditosPraFormar(cursoAtualizado.getCreditosPraFormar());
            curso.setDisciplinas(cursoAtualizado.getDisciplinas());
            return cursoRepository.save(curso);
        } else {
            throw new RuntimeException("Curso com ID " + id + " não encontrado.");
        }
    }

    @Transactional
    public void deletarCursoPorId(Long id) {
        if (cursoRepository.existsById(id)) {
            cursoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Curso com ID " + id + " não encontrado.");
        }
    }
}
