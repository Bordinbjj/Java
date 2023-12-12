import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AgendaContatos {
    public static void main(String[] args) {
        Map<String, String> agenda = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Agenda de Contatos ===");
            System.out.println("1. Adicionar Contato");
            System.out.println("2. Remover Contato");
            System.out.println("3. Mostrar Contatos");
            System.out.println("4. Sair");

            System.out.print("Escolha uma opção: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Digite o nome do contato: ");
                    scanner.nextLine(); // Consumir a quebra de linha pendente
                    String nomeContato = scanner.nextLine();
                    System.out.print("Digite o número do contato: ");
                    String numeroContato = scanner.nextLine();
                    agenda.put(nomeContato, numeroContato);
                    System.out.println("Contato adicionado com sucesso.");
                    break;
                case 2:
                    System.out.print("Digite o nome do contato a ser removido: ");
                    scanner.nextLine(); // Consumir a quebra de linha pendente
                    String nomeRemover = scanner.nextLine();
                    if (agenda.containsKey(nomeRemover)) {
                        agenda.remove(nomeRemover);
                        System.out.println("Contato removido com sucesso.");
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;
                case 3:
                    System.out.println("=== Lista de Contatos ===");
                    for (Map.Entry<String, String> entry : agenda.entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue());
                    }
                    break;
                case 4:
                    System.out.println("Saindo...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
