import java.util.List;

public class ProfessorController {
    private ProfessorRepository professorRepository = ProfessorRepository.getInstance();

    public ProfessorController() {
        this.professorRepository = ProfessorRepository.getInstance();
    }
    public void criarProfessor(int id, String nome) {
        Professor professor = ProfessorFactory.criarProfessor(id, nome);
        professorRepository.adicionarProfessor(professor);
    }

    public Professor buscarProfessor(int id) {
        return professorRepository.buscarProfessor(id);
    }

    public void atualizarProfessor(int id, String novoNome) {
        professorRepository.atualizarProfessor(id, novoNome);
    }

    public void deletarProfessor(int id) {
        professorRepository.removerProfessor(id);
    }

    public List<Professor> listarProfessores() {
        return professorRepository.listarProfessores();
    }
}
