import java.util.List;

public class TurmaController {
    private final TurmaRepository turmaRepository;

    public TurmaController() {
        this.turmaRepository = TurmaRepository.getInstance();
    }

    public void criarTurma(int id, String nome, Professor professor) {
        Turma turma = TurmaFactory.criarTurma(id, nome, professor);
        turmaRepository.adicionarTurma(turma);
    }

    public Turma buscarTurma(int id) {
        return turmaRepository.buscarTurma(id);
    }

    public void atualizarTurma(int id, String novoNome) {
        turmaRepository.atualizarTurma(id, novoNome);
    }

    public void deletarTurma(int id) {
        turmaRepository.removerTurma(id);
    }

    public void adicionarAlunoNaTurma(int turmaId, Aluno aluno) {
        Turma turma = turmaRepository.buscarTurma(turmaId);
        if (turma != null) {
            turma.adicionarAluno(aluno);
        }
    }

    public void removerAlunoDaTurma(int turmaId, Aluno aluno) {
        Turma turma = turmaRepository.buscarTurma(turmaId);
        if (turma != null) {
            turma.removerAluno(aluno);
        }
    }
    public List<Turma> listarTurmas() {
        return turmaRepository.listarTurmas();
    }
}
