import java.util.List;
import java.util.UUID;

public class Professor {

    private String nome;
    private UUID codigoPessoa;
    private List<Turma> turmas;

    public Professor(String nome) {
        this.nome = nome;
        setCodigoPessoa();
    }

    public void adicionarTurma(Turma turma) {
        this.turmas.add(turma);
    }

    public List<Aluno> getAlunosPorTurma(Turma turma) {
        return turma.getAlunosMatriculados();
    }

    private void setCodigoPessoa() {
        this.codigoPessoa = java.util.UUID.randomUUID();
    }
}
