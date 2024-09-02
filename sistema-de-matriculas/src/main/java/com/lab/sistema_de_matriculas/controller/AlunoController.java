package com.lab.sistema_de_matriculas.controller;

import com.lab.sistema_de_matriculas.model.Aluno;
import com.lab.sistema_de_matriculas.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>> getAllAlunos() {
        List<Aluno> alunos = alunoService.findAll();
        return new ResponseEntity<>(alunos, HttpStatus.OK);
    }

    @GetMapping("/{matriculaDoAluno}")
    public ResponseEntity<Aluno> getAlunoById(@PathVariable Long matriculaDoAluno) {
        Optional<Aluno> aluno = alunoService.findById(matriculaDoAluno);
        return aluno.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Aluno> createAluno(@RequestBody Aluno aluno) {
        Aluno savedAluno = alunoService.save(aluno);
        return new ResponseEntity<>(savedAluno, HttpStatus.CREATED);
    }

    @PutMapping("/{matriculaDoAluno}")
    public ResponseEntity<Aluno> updateAluno(@PathVariable Long matriculaDoAluno, @RequestBody Aluno aluno) {
        if (!alunoService.findById(matriculaDoAluno).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        aluno.setMatriculaDoAluno(matriculaDoAluno);
        Aluno updatedAluno = alunoService.save(aluno);
        return new ResponseEntity<>(updatedAluno, HttpStatus.OK);
    }

    @DeleteMapping("/{matriculaDoAluno}")
    public ResponseEntity<Void> deleteAluno(@PathVariable Long matriculaDoAluno) {
        if (!alunoService.findById(matriculaDoAluno).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        alunoService.deleteById(matriculaDoAluno);
        return ResponseEntity.noContent().build();
    }
}
