package com.lab.sistema_de_matriculas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.lab.sistema_de_matriculas.model.Turma;
import com.lab.sistema_de_matriculas.service.TurmaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @PostMapping
    public Turma createTurma(@RequestBody Turma turma) {
        return turmaService.salvarTurma(turma);
    }

    @GetMapping
    public ResponseEntity<List<TurmaResponse>> getAllTurmas() {
        List<Turma> turmas = turmaService.getAllTurmas();
        List<TurmaResponse> response = turmas.stream()
                .map(turma -> new TurmaResponse(
                        turma.getIdTurma(),
                        turma.getDisciplina().getNome(),
                        turma.getProfessor() != null ? turma.getProfessor().getNome() : "N/A"
                ))
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTurmaById(@PathVariable Long id) {
        Turma turma = turmaService.getTurmaById(id);
        if (turma == null) {
            return ResponseEntity.notFound().build();
        }

        TurmaResponse response = new TurmaResponse(
                turma.getIdTurma(),
                turma.getDisciplina().getNome(),
                turma.getProfessor() != null ? turma.getProfessor().getNome() : "N/A"
        );

        return ResponseEntity.ok(response);
    }

    public static class TurmaResponse {
        private Long idTurma;
        private String nomeDisciplina;
        private String nomeProfessor;

        public TurmaResponse(Long idTurma, String nomeDisciplina, String nomeProfessor) {
            this.idTurma = idTurma;
            this.nomeDisciplina = nomeDisciplina;
            this.nomeProfessor = nomeProfessor;
        }

        public Long getIdTurma() {
            return idTurma;
        }

        public void setIdTurma(Long idTurma) {
            this.idTurma = idTurma;
        }

        public String getNomeDisciplina() {
            return nomeDisciplina;
        }

        public void setNomeDisciplina(String nomeDisciplina) {
            this.nomeDisciplina = nomeDisciplina;
        }

        public String getNomeProfessor() {
            return nomeProfessor;
        }

        public void setNomeProfessor(String nomeProfessor) {
            this.nomeProfessor = nomeProfessor;
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTurma(@PathVariable Long id) {
        turmaService.deleteTurma(id);
        return ResponseEntity.noContent().build();
    }
}
