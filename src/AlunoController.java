import java.util.List;

public class AlunoController {
    private final AlunoDAO alunoDAO;

    public AlunoController(AlunoDAO alunoDAO) {
        this.alunoDAO = alunoDAO;
    }
    public void cadastrarAluno(int id, String nome) {
        validarDados(id, nome);
        alunoDAO.criar(new Aluno(id, nome));
    }

    public List<Aluno> listarAlunos() {
        return alunoDAO.listar();
    }

    private void validarDados(int id, String nome) {
        if (id <= 0) throw new IllegalArgumentException("ID inválido");
        if (nome == null || nome.trim().isEmpty()) throw new IllegalArgumentException("Nome inválido");
    }
}