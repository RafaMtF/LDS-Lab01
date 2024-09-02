package com.lab.sistema_de_matriculas.controller;

import com.lab.sistema_de_matriculas.model.ListaDisciplinasDoCurriculo;
import com.lab.sistema_de_matriculas.service.ListaDisciplinasDoCurriculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/lista-disciplinas-curriculo")
public class ListaDisciplinasDoCurriculoController {

    @Autowired
    private ListaDisciplinasDoCurriculoService listaDisciplinaDoCurriculoService;

    @GetMapping
    public List<ListaDisciplinasDoCurriculo> getAllCurriculoDisciplinas() {
        return listaDisciplinaDoCurriculoService.getAllCurriculoDisciplinas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListaDisciplinasDoCurriculo> getCurriculoDisciplinaById(@PathVariable Long id) {
        Optional<ListaDisciplinasDoCurriculo> listaDisciplinaDoCurriculo = listaDisciplinaDoCurriculoService.getCurriculoDisciplinaById(id);
        return listaDisciplinaDoCurriculo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

     @GetMapping("/curriculo/{curriculoId}")
    public ResponseEntity<List<ListaDisciplinasDoCurriculo>> getDisciplinasByCurriculoId(@PathVariable Long curriculoId) {
        List<ListaDisciplinasDoCurriculo> disciplinas = listaDisciplinaDoCurriculoService.getDisciplinasByCurriculoId(curriculoId);
        if (disciplinas.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(disciplinas);
        }
    }

    @PostMapping
    public ListaDisciplinasDoCurriculo createCurriculoDisciplina(@RequestBody ListaDisciplinasDoCurriculo curriculoDisciplina) {
        return listaDisciplinaDoCurriculoService.saveCurriculoDisciplina(curriculoDisciplina);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ListaDisciplinasDoCurriculo> updateCurriculoDisciplina(@PathVariable Long id, @RequestBody ListaDisciplinasDoCurriculo curriculoDisciplinaDetails) {
        Optional<ListaDisciplinasDoCurriculo> listaDisciplinaDoCurriculo = listaDisciplinaDoCurriculoService.getCurriculoDisciplinaById(id);
        if (listaDisciplinaDoCurriculo.isPresent()) {
            ListaDisciplinasDoCurriculo updatedListaDisciplinaDoCurriculo = listaDisciplinaDoCurriculo.get();
            updatedListaDisciplinaDoCurriculo.setCurriculo(curriculoDisciplinaDetails.getCurriculo());
            updatedListaDisciplinaDoCurriculo.setDisciplina(curriculoDisciplinaDetails.getDisciplina());
            listaDisciplinaDoCurriculoService.saveCurriculoDisciplina(updatedListaDisciplinaDoCurriculo);
            return ResponseEntity.ok(updatedListaDisciplinaDoCurriculo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurriculoDisciplina(@PathVariable Long id) {
        if (listaDisciplinaDoCurriculoService.getCurriculoDisciplinaById(id).isPresent()) {
            listaDisciplinaDoCurriculoService.deleteCurriculoDisciplina(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
