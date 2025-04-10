import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlunoRepository {
    private static AlunoRepository instance;
    private Map<Integer, Aluno> alunos;

    private AlunoRepository() {
        this.alunos = new HashMap<>();
    }

    public static AlunoRepository getInstance() {
        if (instance == null) {
            instance = new AlunoRepository();
        }
        return instance;
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.put(aluno.getId(), aluno);
    }

    public Aluno buscarAluno(int id) {
        return alunos.get(id);
    }

    public void atualizarAluno(int id, String novoNome) {
        if (alunos.containsKey(id)) {
            alunos.get(id).setNome(novoNome);
        }
    }

    public void removerAluno(int id) {
        alunos.remove(id);
    }
    public List<Aluno> listarAlunos() {
        return new ArrayList<>(alunos.values());
    }
}
