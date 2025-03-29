import java.util.List;

public class ProfessorController {
    private final ProfessorDAO professorDAO = new ProfessorDAO();

    public void cadastrarProfessor(int id, String nome) {
        validarDados(id, nome);
        professorDAO.criar(new Professor(id, nome));
    }

    public List<Professor> listarProfessores() {
        return professorDAO.listar();
    }

    private void validarDados(int id, String nome) {
        if (id <= 0) throw new IllegalArgumentException("ID inválido");
        if (nome == null || nome.trim().isEmpty()) throw new IllegalArgumentException("Nome inválido");
    }
}