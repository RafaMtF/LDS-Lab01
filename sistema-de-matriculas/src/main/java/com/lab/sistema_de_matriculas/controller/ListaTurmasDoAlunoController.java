package com.lab.sistema_de_matriculas.controller;

import com.lab.sistema_de_matriculas.model.ListaTurmasDoAluno;
import com.lab.sistema_de_matriculas.model.Aluno;
import com.lab.sistema_de_matriculas.service.AlunoService;
import com.lab.sistema_de_matriculas.service.ListaTurmasDoAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lista-turmas-do-aluno")
public class ListaTurmasDoAlunoController {

    @Autowired
    private ListaTurmasDoAlunoService listaTurmasDoAlunoService;

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<ListaTurmasDoAluno>> getAllListas() {
        List<ListaTurmasDoAluno> listas = listaTurmasDoAlunoService.findAll();
        return new ResponseEntity<>(listas, HttpStatus.OK);
    }

    @GetMapping("/{idLista}")
    public ResponseEntity<ListaTurmasDoAluno> getListaById(@PathVariable Long idLista) {
        Optional<ListaTurmasDoAluno> lista = listaTurmasDoAlunoService.findById(idLista);
        return lista.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ListaTurmasDoAluno> createLista(@RequestBody ListaTurmasDoAluno listaTurmasDoAluno) {
        ListaTurmasDoAluno savedLista = listaTurmasDoAlunoService.save(listaTurmasDoAluno);
        return new ResponseEntity<>(savedLista, HttpStatus.CREATED);
    }

    @PutMapping("/{idLista}")
    public ResponseEntity<ListaTurmasDoAluno> updateLista(@PathVariable Long idLista, @RequestBody ListaTurmasDoAluno listaTurmasDoAluno) {
        if (!listaTurmasDoAlunoService.findById(idLista).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        listaTurmasDoAluno.setIdLista(idLista);
        ListaTurmasDoAluno updatedLista = listaTurmasDoAlunoService.save(listaTurmasDoAluno);
        return new ResponseEntity<>(updatedLista, HttpStatus.OK);
    }

    @DeleteMapping("/{idLista}")
    public ResponseEntity<Void> deleteLista(@PathVariable Long idLista) {
        if (!listaTurmasDoAlunoService.findById(idLista).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        listaTurmasDoAlunoService.deleteById(idLista);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/aluno/{idAluno}")
    public ResponseEntity<List<ListaTurmasDoAluno>> getTurmasByAluno(@PathVariable Long idAluno) {
        Optional<Aluno> alunoOpt = alunoService.findById(idAluno);
        if (!alunoOpt.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        List<ListaTurmasDoAluno> listas = listaTurmasDoAlunoService.findByAluno(alunoOpt.get());
        return new ResponseEntity<>(listas, HttpStatus.OK);
    }
}
