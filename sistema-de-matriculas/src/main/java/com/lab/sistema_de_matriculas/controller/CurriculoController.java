package com.lab.sistema_de_matriculas.controller;

import com.lab.sistema_de_matriculas.model.Curriculo;
import com.lab.sistema_de_matriculas.service.CurriculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/curriculos")
public class CurriculoController {

    @Autowired
    private CurriculoService curriculoService;

    @GetMapping
    public List<Curriculo> getAllCurriculos() {
        return curriculoService.getAllCurriculos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curriculo> getCurriculoById(@PathVariable Long id) {
        Optional<Curriculo> curriculo = curriculoService.getCurriculoById(id);
        return curriculo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Curriculo createCurriculo(@RequestBody Curriculo curriculo) {
        return curriculoService.saveCurriculo(curriculo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curriculo> updateCurriculo(@PathVariable Long id, @RequestBody Curriculo curriculoDetails) {
        Optional<Curriculo> curriculo = curriculoService.getCurriculoById(id);
        if (curriculo.isPresent()) {
            Curriculo updatedCurriculo = curriculo.get();
            updatedCurriculo.setCurso(curriculoDetails.getCurso());
            updatedCurriculo.setSemestre(curriculoDetails.getSemestre());
            updatedCurriculo.setAno(curriculoDetails.getAno());
            curriculoService.saveCurriculo(updatedCurriculo);
            return ResponseEntity.ok(updatedCurriculo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurriculo(@PathVariable Long id) {
        if (curriculoService.getCurriculoById(id).isPresent()) {
            curriculoService.deleteCurriculo(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
