public class TurmaFactory {
    public static Turma criarTurma(int id, String nome, Professor professor) {
        return new Turma(id, nome, professor);
    }
}
