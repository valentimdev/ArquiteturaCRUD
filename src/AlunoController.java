import java.util.List;

public class AlunoController {
    private AlunoRepository alunoRepository = AlunoRepository.getInstance();

    public AlunoController() {
        this.alunoRepository = AlunoRepository.getInstance();
    }

    public void criarAluno(int id, String nome) {
        Aluno aluno = AlunoFactory.criarAluno(id, nome);
        alunoRepository.adicionarAluno(aluno);
    }

    public Aluno buscarAluno(int id) {
        return alunoRepository.buscarAluno(id);
    }

    public void atualizarAluno(int id, String novoNome) {
        alunoRepository.atualizarAluno(id, novoNome);
    }

    public void deletarAluno(int id) {
        alunoRepository.removerAluno(id);
    }

    public List<Aluno> listarTodosAlunos() {
        return alunoRepository.listarAlunos();
    }
}
