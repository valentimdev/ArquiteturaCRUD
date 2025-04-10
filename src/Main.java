import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AlunoController alunoController = new AlunoController();
    private static final ProfessorController professorController = new ProfessorController();
    private static final TurmaController turmaController = new TurmaController();

    public static void main(String[] args) {
        exibirCabecalho();

        while (true) {
            exibirMenuPrincipal();
            int opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1 -> cadastrarAluno();
                case 2 -> atualizarAluno();
                case 3 -> deletarAluno();
                case 4 -> listarAlunos();
                case 5 -> cadastrarProfessor();
                case 6 -> atualizarProfessor();
                case 7 -> deletarProfessor();
                case 8 -> listarProfessores();
                case 9 -> criarTurma();
                case 10 -> atualizarTurma();
                case 11 -> deletarTurma();
                case 12 -> adicionarAlunoTurma();
                case 13 -> removerAlunoTurma();
                case 14 -> listarTurmas();
                case 0 -> sair();
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    // ========== MÉTODOS DE EXIBIÇÃO ==========
    private static void exibirCabecalho() {
        System.out.println("\n====================================");
        System.out.println("    SISTEMA DE GESTÃO ESCOLAR 1.0    ");
        System.out.println("====================================");
    }

    private static void exibirMenuPrincipal() {
        System.out.println("\n---------- MENU PRINCIPAL ----------");
        System.out.println("1. Cadastrar Aluno");
        System.out.println("2. Atualizar Aluno");
        System.out.println("3. Deletar Aluno");
        System.out.println("4. Listar Alunos");
        System.out.println("5. Cadastrar Professor");
        System.out.println("6. Atualizar Professor");
        System.out.println("7. Deletar Professor");
        System.out.println("8. Listar Professores");
        System.out.println("9. Criar Turma");
        System.out.println("10. Atualizar Turma");
        System.out.println("11. Deletar Turma");
        System.out.println("12. Adicionar Aluno à Turma");
        System.out.println("13. Remover Aluno da Turma");
        System.out.println("14. Listar Turmas");
        System.out.println("0. Sair");
    }

    // ========== OPERAÇÕES DE ALUNOS ==========
    private static void cadastrarAluno() {
        System.out.print("\nID do aluno: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        alunoController.criarAluno(id, nome);
    }

    private static void atualizarAluno() {
        System.out.print("\nID do aluno: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();
        alunoController.atualizarAluno(id, nome);
    }

    private static void deletarAluno() {
        System.out.print("\nID do aluno: ");
        int id = scanner.nextInt();
        alunoController.deletarAluno(id);
    }

    private static void listarAlunos() {
        System.out.println("\n----- LISTA DE ALUNOS -----");
        alunoController.listarTodosAlunos().forEach(aluno ->
                System.out.println("ID: " + aluno.getId() + " | Nome: " + aluno.getNome())
        );
    }

    // ========== OPERAÇÕES DE PROFESSORES ==========
    private static void cadastrarProfessor() {
        System.out.print("\nID do professor: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        professorController.criarProfessor(id, nome);
    }

    private static void atualizarProfessor() {
        System.out.print("\nID do professor: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();
        professorController.atualizarProfessor(id, nome);
    }

    private static void deletarProfessor() {
        System.out.print("\nID do professor: ");
        int id = scanner.nextInt();
        professorController.deletarProfessor(id);
    }

    private static void listarProfessores() {
        System.out.println("\n----- LISTA DE PROFESSORES -----");
        professorController.listarProfessores().forEach(professor ->
                System.out.println("ID: " + professor.getId() + " | Nome: " + professor.getNome())
        );
    }

    // ========== OPERAÇÕES DE TURMAS ==========
    private static void criarTurma() {
        System.out.print("\nID da turma: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nome da turma: ");
        String nome = scanner.nextLine();
        System.out.print("ID do professor: ");
        int idProf = scanner.nextInt();
        Professor prof = professorController.buscarProfessor(idProf);

        if (prof != null) {
            turmaController.criarTurma(id, nome, prof);
            System.out.println("Turma criada com sucesso!");
        } else {
            System.out.println("Professor não encontrado!");
        }
    }

    private static void atualizarTurma() {
        System.out.print("\nID da turma: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();
        turmaController.atualizarTurma(id, nome);
    }

    private static void deletarTurma() {
        System.out.print("\nID da turma: ");
        int id = scanner.nextInt();
        turmaController.deletarTurma(id);
    }

    private static void adicionarAlunoTurma() {
        System.out.print("\nID da turma: ");
        int turmaId = scanner.nextInt();
        System.out.print("ID do aluno: ");
        int alunoId = scanner.nextInt();
        Aluno aluno = alunoController.buscarAluno(alunoId);

        if (aluno != null) {
            turmaController.adicionarAlunoNaTurma(turmaId, aluno);
            System.out.println("Aluno adicionado!");
        } else {
            System.out.println("Aluno não encontrado!");
        }
    }

    private static void removerAlunoTurma() {
        System.out.print("\nID da turma: ");
        int turmaId = scanner.nextInt();
        System.out.print("ID do aluno: ");
        int alunoId = scanner.nextInt();
        Aluno aluno = alunoController.buscarAluno(alunoId);

        if (aluno != null) {
            turmaController.removerAlunoDaTurma(turmaId, aluno);
            System.out.println("Aluno removido!");
        } else {
            System.out.println("Aluno não encontrado!");
        }
    }

    private static void listarTurmas() {
        System.out.println("\n----- LISTA DE TURMAS -----");
        turmaController.listarTurmas().forEach(turma -> {
            System.out.println(
                    "ID: " + turma.getId() +
                            " | Nome: " + turma.getNome() +
                            " | Professor: " + turma.getProfessor().getNome() +
                            " | Alunos: " + turma.getAlunos().stream()
                            .map(Aluno::getNome).collect(Collectors.joining(", "))
            );
        });
    }

    // ========== UTILITÁRIOS ==========
    private static int lerInteiro(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Digite um número válido!");
                scanner.nextLine();
            }
        }
    }

    private static void sair() {
        System.out.println("\nEncerrando sistema...");
        scanner.close();
        System.exit(0);
    }
}