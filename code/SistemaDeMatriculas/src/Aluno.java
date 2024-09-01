import java.util.List;

public class Aluno {

    private String nome;
    private String matricula;
    private List<Disciplina> disciplinasMatriculadas;

    public Aluno(String nome, String matricula) {}

    public void matricularDisciplina(Disciplina disciplina) {}

    public void cancelarMatricula(Disciplina disciplina) {}
}
