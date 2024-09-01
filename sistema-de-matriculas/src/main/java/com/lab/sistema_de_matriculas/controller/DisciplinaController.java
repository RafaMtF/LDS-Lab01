package com.lab.sistema_de_matriculas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.lab.sistema_de_matriculas.model.Disciplina;
import com.lab.sistema_de_matriculas.service.DisciplinaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @GetMapping
    public List<Disciplina> getAllDisciplinas(){
        return disciplinaService.encontrarTodasAsDisciplinas();
    }

    @GetMapping("/{id}")
    public Optional<Disciplina> getDisciplinaById(@PathVariable Long id) {
        return disciplinaService.encontrarDisciplinaPorId(id);
    }

    @PostMapping
    public Disciplina criarDisciplina(@RequestBody Disciplina disciplina) {
        return disciplinaService.salvarDisciplina(disciplina);
    }

    @PutMapping("/{id}")
    public Disciplina atualizarDisciplina(@PathVariable Long id, @RequestBody Disciplina disciplinaAtualizada) {
        return disciplinaService.atualizarDisciplina(id, disciplinaAtualizada);
    }

    @DeleteMapping("/{id}")
    public void deletarDisciplina(@PathVariable Long id) {
        disciplinaService.deletarDisciplinaPorId(id);
    }
}
