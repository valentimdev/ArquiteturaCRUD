import java.util.List;

public class TurmaController {
    private final TurmaDAO turmaDAO;
    private final ProfessorDAO professorDAO;

    public TurmaController(TurmaDAO turmaDAO, ProfessorDAO professorDAO) {
        this.turmaDAO = turmaDAO;
        this.professorDAO = professorDAO;
    }
    public void cadastrarTurma(int id, String nome, int idProfessor) {
        validarDados(id, nome, idProfessor);
        turmaDAO.criar(TurmaFactory.criarTurma(id, nome, idProfessor));
    }

    public List<Turma> listarTurmas() {
        return turmaDAO.listar();
    }

    private void validarDados(int id, String nome, int idProfessor) {
        if (id <= 0) throw new IllegalArgumentException("ID turma inválido");
        if (nome == null || nome.trim().isEmpty()) throw new IllegalArgumentException("Nome turma inválido");
        if (professorDAO.buscarPorId(idProfessor) == null) {
            throw new IllegalArgumentException("Professor não encontrado");
        }
    }
}