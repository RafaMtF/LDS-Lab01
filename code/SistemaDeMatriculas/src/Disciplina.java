import java.util.List;
import java.util.UUID;

public class Disciplina {

    private UUID id;
    private String nome;
    private String ementa;
    private int creditos;
    private List<Aluno> alunosMatriculados;

    public Disciplina(String nome, String ementa, int creditos) {
        this.nome = nome;
        this.ementa = ementa;
        this.creditos = creditos;
        setId();
    }

    private void setId() {
        this.id = java.util.UUID.randomUUID();
    }
}
