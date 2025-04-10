public class AlunoFactory {
    public static Aluno criarAluno(int id, String nome) {
        return new Aluno(id, nome);
    }
}
