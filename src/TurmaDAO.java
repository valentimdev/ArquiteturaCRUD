import java.util.ArrayList;
import java.util.List;

public class TurmaDAO {
    private final List<Turma> turmas = new ArrayList<>();

    public void criar(Turma turma) { turmas.add(turma); }
    public List<Turma> listar() { return new ArrayList<>(turmas); }
}