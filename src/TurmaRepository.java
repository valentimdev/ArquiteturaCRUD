import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TurmaRepository {
    private static TurmaRepository instance;
    private Map<Integer, Turma> turmas;

    private TurmaRepository() {
        this.turmas = new HashMap<>();
    }

    public static TurmaRepository getInstance() {
        if (instance == null) {
            instance = new TurmaRepository();
        }
        return instance;
    }

    public void adicionarTurma(Turma turma) {
        turmas.put(turma.getId(), turma);
    }

    public Turma buscarTurma(int id) {
        return turmas.get(id);
    }

    public void atualizarTurma(int id, String novoNome) {
        if (turmas.containsKey(id)) {
            turmas.get(id).setNome(novoNome);
        }
    }

    public void removerTurma(int id) {
        turmas.remove(id);
    }
    public List<Turma> listarTurmas() {
        return new ArrayList<>(turmas.values());
    }
}
