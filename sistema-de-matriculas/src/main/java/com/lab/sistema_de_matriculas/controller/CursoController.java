package com.lab.sistema_de_matriculas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lab.sistema_de_matriculas.model.Curso;
import com.lab.sistema_de_matriculas.service.CursoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<Curso> getAllCursos() {
        return cursoService.encontrarTodosOsCursos();
    }

    @GetMapping("/{id}")
    public Optional<Curso> getCursoById(@PathVariable Long id) {
        return cursoService.encontrarCursoPorId(id);
    }

    @PostMapping
    public Curso criarCurso(@RequestBody Curso curso) {
        return cursoService.salvarCurso(curso);
    }

    @PutMapping("/{id}")
    public Curso atualizarCurso(@PathVariable Long id, @RequestBody Curso cursoAtualizado) {
        return cursoService.atualizarCurso(id, cursoAtualizado);
    }

    @DeleteMapping("/{id}")
    public void deletarCurso(@PathVariable Long id) {
        cursoService.deletarCursoPorId(id);
    }
}
