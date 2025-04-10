import java.util.List;
import java.util.ArrayList;

public class Turma {
    private int id;
    private String nome;
    private List<Aluno> alunos;
    private Professor professor;

    public Turma(int id, String nome, Professor professor) {
        this.id = id;
        this.nome = nome;
        this.professor = professor;
        this.alunos = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public Professor getProfessor() { return professor; }
    public List<Aluno> getAlunos() { return alunos; }

    public void setNome(String nome) { this.nome = nome; }
    public void setProfessor(Professor professor) { this.professor = professor; }

    public void adicionarAluno(Aluno aluno) { alunos.add(aluno); }
    public void removerAluno(Aluno aluno) { alunos.remove(aluno); }

    @Override
    public String toString() {
        return "Turma{id=" + id + ", nome='" + nome + "', professor=" + professor.getNome() + ", alunos=" + alunos.size() + "}";
    }
}
