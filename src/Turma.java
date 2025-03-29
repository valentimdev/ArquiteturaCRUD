public class Turma {
    private final int id;
    private String nome;
    private final int idProfessor;

    public Turma(int id, String nome, int idProfessor) {
        this.id = id;
        this.nome = nome;
        this.idProfessor = idProfessor;
    }

    // Getters
    public int getId() { return id; }
    public String getNome() { return nome; }
    public int getIdProfessor() { return idProfessor; }

    // Setter apenas para nome
    public void setNome(String nome) { this.nome = nome; }

    @Override
    public String toString() {
        return "Turma [ID: " + id + ", Nome: " + nome + ", ID Professor: " + idProfessor + "]";
    }
}