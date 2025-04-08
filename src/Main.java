import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criação dos DAOs compartilhados
        AlunoDAO alunoDAO = new AlunoDAO();
        ProfessorDAO professorDAO = new ProfessorDAO();
        TurmaDAO turmaDAO = new TurmaDAO();

        // Controllers com os DAOs compartilhados
        AlunoController alunoController = new AlunoController(alunoDAO);
        ProfessorController professorController = new ProfessorController(professorDAO);
        TurmaController turmaController = new TurmaController(turmaDAO, professorDAO);

        while (true) {
            System.out.println("\n1. Cadastrar Aluno");
            System.out.println("2. Cadastrar Professor");
            System.out.println("3. Cadastrar Turma");
            System.out.println("4. Listar Alunos");
            System.out.println("5. Listar Professores");
            System.out.println("6. Listar Turmas");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("ID: "); int id = scanner.nextInt();
                    scanner.nextLine(); System.out.print("Nome: "); String nome = scanner.nextLine();
                    alunoController.cadastrarAluno(id, nome);
                }
                case 2 -> {
                    System.out.print("ID: "); int id = scanner.nextInt();
                    scanner.nextLine(); System.out.print("Nome: "); String nome = scanner.nextLine();
                    professorController.cadastrarProfessor(id, nome);
                }
                case 3 -> {
                    System.out.print("ID: "); int id = scanner.nextInt();
                    scanner.nextLine(); System.out.print("Nome: "); String nome = scanner.nextLine();
                    System.out.print("ID do Professor: "); int idProf = scanner.nextInt();
                    turmaController.cadastrarTurma(id, nome, idProf);
                }
                case 4 -> alunoController.listarAlunos().forEach(System.out::println);
                case 5 -> professorController.listarProfessores().forEach(System.out::println);
                case 6 -> turmaController.listarTurmas().forEach(System.out::println);
                case 7 -> { System.out.println("Saindo..."); scanner.close(); System.exit(0); }
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}
