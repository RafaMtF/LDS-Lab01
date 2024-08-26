import java.util.List;

public class Disciplina {

    private int id;
    private String nome;
    private String ementa;
    private int creditos;
    private List<Turma> turmas;
    private List<Aluno> alunosMatriculados;

    public Disciplina(String nome, String ementa, int creditos) {}

    public boolean adicionarAluno(Aluno aluno) {}

    public void removerAluno(Aluno aluno) {}

    public boolean adicionarTurma(Turma turma) {}

    public void removerTurma(Turma turma) {}

    public boolean isAtiva() {}

    public List<Aluno> getAlunosMatriculados() {}

    public List<Turma> getTurmas() {}
}
