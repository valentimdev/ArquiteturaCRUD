import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    private final List<Aluno> alunos = new ArrayList<>();

    public void criar(Aluno aluno) { alunos.add(aluno); }
    public List<Aluno> listar() { return new ArrayList<>(alunos); }
}

