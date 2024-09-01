import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Turma {

    private UUID id;
    private String turno;
    private String semestreVigente;
    private Professor professor;
    private List<Aluno> alunosTurma;
    private Status status;

    public Turma(Professor professor, String turno, String semestreVigente) {
        setId();
        setTurno(turno);
        setProfessor(professor);
        setStatus(Status.INATIVA);
        setSemestreVigente(semestreVigente);
        alunosTurma = new ArrayList<>();
    }

    public boolean adicionarAluno(Aluno aluno) {
        if (alunosTurma.size() <= 60) {
            if (!alunosTurma.contains(aluno)) {
                alunosTurma.add(aluno);
                return true;
            }
        }
        return false;
    }

    public void removerAluno(Aluno aluno) {
        alunosTurma.remove(aluno);
    }

    public void alterarProfessor(Professor novoProfessor) {
        if (status != Status.ATIVA && status != Status.CONCLUIDA) {
            this.professor = novoProfessor;
        } else {
            throw new RuntimeException("Nao foi possivel alterar o professor, disciplina esta com status: " + status);
        }
    }

    public Professor getProfessor() {
        return this.professor;
    }

    public List<Aluno> getAlunosMatriculados() {
        return alunosTurma;
    }

    public UUID getId() {
        return id;
    }

    public String getTurno() {
        return turno;
    }

    public String getSemestreVigente() {
        return semestreVigente;
    }

    public Status getStatus() {
        return status;
    }

    private void setProfessor(Professor professor) {
        this.professor = professor;
    }

    private void setTurno(String turno) {
        this.turno = turno;
    }

    private void setSemestreVigente(String semestreVigente) {
        this.semestreVigente = semestreVigente;
    }

    public void setStatus(Status status) {
        if (getStatus() == Status.EM_OFERTA && status == Status.ATIVA) {
            if (getAlunosMatriculados().size() < 3 || getAlunosMatriculados().size() > 60) {
                return;
            }
        }
        this.status = status;
    }

    private void setId() {
        this.id = java.util.UUID.randomUUID();
    }
}
