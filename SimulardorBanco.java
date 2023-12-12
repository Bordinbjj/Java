import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SimuladorBancario {
    public static void main(String[] args) {
        Map<String, Double> contas = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Simulador Bancário ===");
            System.out.println("1. Criar Conta");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Verificar Saldo");
            System.out.println("5. Sair");

            System.out.print("Escolha uma opção: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Digite o nome do titular: ");
                    scanner.nextLine(); // Consumir a quebra de linha pendente
                    String titular = scanner.nextLine();
                    contas.put(titular, 0.0);
                    System.out.println("Conta criada com sucesso para " + titular);
                    break;
                case 2:
                    System.out.print("Digite o nome do titular: ");
                    scanner.nextLine(); // Consumir a quebra de linha pendente
                    titular = scanner.nextLine();
                    if (contas.containsKey(titular)) {
                        System.out.print("Digite o valor a ser depositado: ");
                        double deposito = scanner.nextDouble();
                        contas.put(titular, contas.get(titular) + deposito);
                        System.out.println("Depósito realizado com sucesso.");
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;
                case 3:
                    System.out.print("Digite o nome do titular: ");
                    scanner.nextLine(); // Consumir a quebra de linha pendente
                    titular = scanner.nextLine();
                    if (contas.containsKey(titular)) {
                        System.out.print("Digite o valor a ser sacado: ");
                        double saque = scanner.nextDouble();
                        double saldoAtual = contas.get(titular);
                        if (saque <= saldoAtual) {
                            contas.put(titular, saldoAtual - saque);
                            System.out.println("Saque realizado com sucesso.");
                        } else {
                            System.out.println("Saldo insuficiente.");
                        }
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;
                case 4:
                    System.out.print("Digite o nome do titular: ");
                    scanner.nextLine(); // Consumir a quebra de linha pendente
                    titular = scanner.nextLine();
                    if (contas.containsKey(titular)) {
                        System.out.println("Saldo atual: " + contas.get(titular));
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    break;
                case 5:
                    System.out.println("Saindo...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
