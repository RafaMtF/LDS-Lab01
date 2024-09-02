import java.util.List;

public class Curso {

    private int id;
    private String nome;
    private String descricao;
    private int creditosParaFormar;
    private List<Disciplina> disciplinas;

    public Curso(String nome, String descricao, int creditosParaFormar) {}

    public void adicionarDisciplina(Disciplina disciplina) {}

    public List<Disciplina> getDisciplinas() {}

    public void removerDisciplina(Disciplina disciplina) {}
}
