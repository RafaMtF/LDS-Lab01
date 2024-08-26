import java.util.List;

public class Turma {

    private int id;
    private String turno;
    private String semestreVigente;
    private Professor professor;
    private List<Aluno> alunosTurma;

    public Turma(Professor professor, String turno, String semestreVigente) {}

    public boolean adicionarAluno(Aluno aluno) {}

    public void removerAluno(Aluno aluno) {}

    public Professor getProfessor() {}

    public void alterarProfessor(Professor novoProfessor) {}

    public List<Aluno> getAlunos() {}
}
