import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {
    private final List<Professor> professores = new ArrayList<>();

    public void criar(Professor professor) { professores.add(professor); }
    public List<Professor> listar() { return new ArrayList<>(professores); }
    public Professor buscarPorId(int id) {
        return professores.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }
}