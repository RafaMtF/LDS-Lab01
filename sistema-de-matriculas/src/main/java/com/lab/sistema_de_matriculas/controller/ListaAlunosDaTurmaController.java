package com.lab.sistema_de_matriculas.controller;

import com.lab.sistema_de_matriculas.model.ListaAlunosDaTurma;
import com.lab.sistema_de_matriculas.model.Turma;
import com.lab.sistema_de_matriculas.service.ListaAlunosDaTurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/lista-alunos-da-turma")
public class ListaAlunosDaTurmaController {

    @Autowired
    private ListaAlunosDaTurmaService listaAlunosDaTurmaService;

    @GetMapping
    public ResponseEntity<List<ListaAlunosDaTurma>> getAllListas() {
        List<ListaAlunosDaTurma> listas = listaAlunosDaTurmaService.findAll();
        return new ResponseEntity<>(listas, HttpStatus.OK);
    }

    @GetMapping("/{idLista}")
    public ResponseEntity<ListaAlunosDaTurma> getListaById(@PathVariable Long idLista) {
        Optional<ListaAlunosDaTurma> lista = listaAlunosDaTurmaService.findById(idLista);
        return lista.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ListaAlunosDaTurma> createLista(@RequestBody ListaAlunosDaTurma listaAlunosDaTurma) {
        ListaAlunosDaTurma savedLista = listaAlunosDaTurmaService.save(listaAlunosDaTurma);
        return new ResponseEntity<>(savedLista, HttpStatus.CREATED);
    }

    @PutMapping("/{idLista}")
    public ResponseEntity<ListaAlunosDaTurma> updateLista(@PathVariable Long idLista, @RequestBody ListaAlunosDaTurma listaAlunosDaTurma) {
        if (!listaAlunosDaTurmaService.findById(idLista).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        listaAlunosDaTurma.setIdLista(idLista);
        ListaAlunosDaTurma updatedLista = listaAlunosDaTurmaService.save(listaAlunosDaTurma);
        return new ResponseEntity<>(updatedLista, HttpStatus.OK);
    }

    @DeleteMapping("/{idLista}")
    public ResponseEntity<Void> deleteLista(@PathVariable Long idLista) {
        if (!listaAlunosDaTurmaService.findById(idLista).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        listaAlunosDaTurmaService.deleteById(idLista);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/turma/{idTurma}")
    public ResponseEntity<List<ListaAlunosDaTurma>> getAlunosByTurma(@PathVariable Long idTurma) {
        Turma turma = new Turma(); 
        turma.setIdTurma(idTurma);
        List<ListaAlunosDaTurma> listas = listaAlunosDaTurmaService.findByTurma(turma);
        return new ResponseEntity<>(listas, HttpStatus.OK);
    }
}
