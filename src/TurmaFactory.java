public class TurmaFactory {
    public static Turma criarTurma(int id, String nome, int idProfessor) {
        return new Turma(id, nome, idProfessor);
    }
}