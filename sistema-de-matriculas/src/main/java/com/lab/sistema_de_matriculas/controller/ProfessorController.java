package com.lab.sistema_de_matriculas.controller;

import com.lab.sistema_de_matriculas.model.Professor;
import com.lab.sistema_de_matriculas.service.ProfessorService;
import com.lab.sistema_de_matriculas.service.ProfessorService.TurmaInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.Optional;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public List<Professor> getAllProfessores() {
        return professorService.getAllProfessores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> getProfessorById(@PathVariable("id") Long id) {
        Optional<Professor> professor = professorService.getProfessorById(id);
        return professor.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/turmas")
    public ResponseEntity<Set<TurmaInfo>> getTurmasByProfessorId(@PathVariable("id") Long id) {
        Set<TurmaInfo> turmas = professorService.getTurmasByProfessorId(id);
        return ResponseEntity.ok(turmas);
    }

    @PostMapping
    public ResponseEntity<Professor> createProfessor(@RequestBody Professor professor) {
        Professor savedProfessor = professorService.saveProfessor(professor);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProfessor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> updateProfessor(@PathVariable("id") Long id, @RequestBody Professor professor) {
        if (!professorService.getProfessorById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        professor.setIdProfessor(id);
        Professor updatedProfessor = professorService.saveProfessor(professor);
        return ResponseEntity.ok(updatedProfessor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfessor(@PathVariable("id") Long id) {
        if (!professorService.getProfessorById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        professorService.deleteProfessor(id);
        return ResponseEntity.noContent().build();
    }
}