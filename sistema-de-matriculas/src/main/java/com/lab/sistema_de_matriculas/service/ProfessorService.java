package com.lab.sistema_de_matriculas.service;

import com.lab.sistema_de_matriculas.model.Professor;
import com.lab.sistema_de_matriculas.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> getAllProfessores() {
        return professorRepository.findAll();
    }

    public Optional<Professor> getProfessorById(Long id) {
        return professorRepository.findById(id);
    }

    public Professor saveProfessor(Professor professor) {
        return professorRepository.save(professor);
    }

    public void deleteProfessor(Long id) {
        professorRepository.deleteById(id);
    }
    
    public Set<TurmaInfo> getTurmasByProfessorId(Long id) {
        return professorRepository.findById(id)
                .orElseThrow()
                .getTurmas().stream()
                .map(turma -> new TurmaInfo(turma.getIdTurma(), turma.getDisciplina().getNome()))
                .collect(Collectors.toSet());
    }

    // Classe interna para representar a estrutura de resposta
    public static class TurmaInfo {
        private Long idTurma;
        private String nomeDisciplina;

        public TurmaInfo(Long idTurma, String nomeDisciplina) {
            this.idTurma = idTurma;
            this.nomeDisciplina = nomeDisciplina;
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
    }
}