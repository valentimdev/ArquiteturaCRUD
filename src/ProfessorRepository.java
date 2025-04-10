import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProfessorRepository {
    private static ProfessorRepository instance;
    private Map<Integer, Professor> professores;

    private ProfessorRepository() {
        this.professores = new HashMap<>();
    }

    public static ProfessorRepository getInstance() {
        if (instance == null) {
            instance = new ProfessorRepository();
        }
        return instance;
    }

    public void adicionarProfessor(Professor professor) {
        professores.put(professor.getId(), professor);
    }

    public Professor buscarProfessor(int id) {
        return professores.get(id);
    }

    public void atualizarProfessor(int id, String novoNome) {
        if (professores.containsKey(id)) {
            professores.get(id).setNome(novoNome);
        }
    }

    public void removerProfessor(int id) {
        professores.remove(id);
    }
    public List<Professor> listarProfessores() {
        return new ArrayList<>(professores.values());
    }
}
