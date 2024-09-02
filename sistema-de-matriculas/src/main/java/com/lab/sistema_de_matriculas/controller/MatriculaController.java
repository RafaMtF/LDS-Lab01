package com.lab.sistema_de_matriculas.controller;

import com.lab.sistema_de_matriculas.model.Matricula;
import com.lab.sistema_de_matriculas.model.Aluno;
import com.lab.sistema_de_matriculas.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @GetMapping
    public ResponseEntity<List<Matricula>> getAllMatriculas() {
        List<Matricula> matriculas = matriculaService.findAll();
        return new ResponseEntity<>(matriculas, HttpStatus.OK);
    }

    @GetMapping("/{idMatricula}")
    public ResponseEntity<Matricula> getMatriculaById(@PathVariable Long idMatricula) {
        Optional<Matricula> matricula = matriculaService.findById(idMatricula);
        return matricula.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Matricula> createMatricula(@RequestBody Matricula matricula) {
        Matricula savedMatricula = matriculaService.save(matricula);
        return new ResponseEntity<>(savedMatricula, HttpStatus.CREATED);
    }

    @PutMapping("/{idMatricula}")
    public ResponseEntity<Matricula> updateMatricula(@PathVariable Long idMatricula, @RequestBody Matricula matricula) {
        if (!matriculaService.findById(idMatricula).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        matricula.setIdMatricula(idMatricula);
        Matricula updatedMatricula = matriculaService.save(matricula);
        return new ResponseEntity<>(updatedMatricula, HttpStatus.OK);
    }

    @DeleteMapping("/{idMatricula}")
    public ResponseEntity<Void> deleteMatricula(@PathVariable Long idMatricula) {
        if (!matriculaService.findById(idMatricula).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        matriculaService.deleteById(idMatricula);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/aluno/{idAluno}")
    public ResponseEntity<List<Matricula>> getMatriculasByAluno(@PathVariable Long idAluno) {
        Aluno aluno = new Aluno();  // Crie a instância do Aluno com o id apropriado
        aluno.setMatriculaDoAluno(idAluno);
        List<Matricula> matriculas = matriculaService.findByAluno(aluno);
        return new ResponseEntity<>(matriculas, HttpStatus.OK);
    }

    @GetMapping("/active/{isActive}")
    public ResponseEntity<List<Matricula>> getMatriculasByIsActive(@PathVariable Boolean isActive) {
        List<Matricula> matriculas = matriculaService.findByIsActive(isActive);
        return new ResponseEntity<>(matriculas, HttpStatus.OK);
    }
}
