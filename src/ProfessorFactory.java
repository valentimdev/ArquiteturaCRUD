public class  ProfessorFactory {
    public static Professor criarProfessor(int id, String nome) {
        return new Professor(id, nome);
    }
}
