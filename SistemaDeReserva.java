import java.util.Scanner;

public class ReservasPassagensAereas {
    public static void main(String[] args) {
        boolean[] assentos = new boolean[10]; // Assentos numerados de 1 a 10

        Scanner scanner = new Scanner(System.in);

        while (true) {
            exibirMenu();
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    exibirAssentosDisponiveis(assentos);
                    break;
                case 2:
                    reservarAssento(assentos);
                    break;
                case 3:
                    cancelarReserva(assentos);
                    break;
                case 4:
                    System.out.println("Saindo...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void exibirMenu() {
        System.out.println("\n=== Menu ===");
        System.out.println("1. Exibir Assentos Disponíveis");
        System.out.println("2. Reservar Assento");
        System.out.println("3. Cancelar Reserva");
        System.out.println("4. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void exibirAssentosDisponiveis(boolean[] assentos) {
        System.out.println("\nAssentos Disponíveis:");

        for (int i = 0; i < assentos.length; i++) {
            if (!assentos[i]) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();
    }

    private static void reservarAssento(boolean[] assentos) {
        Scanner scanner = new Scanner(System.in);
        exibirAssentosDisponiveis(assentos);

        System.out.print("Digite o número do assento desejado: ");
        int numeroAssento = scanner.nextInt();

        if (numeroAssento >= 1 && numeroAssento <= 10) {
            if (!assentos[numeroAssento - 1]) {
                assentos[numeroAssento - 1] = true;
                System.out.println("Assento " + numeroAssento + " reservado com sucesso.");
            } else {
                System.out.println("Assento já reservado. Escolha outro assento.");
            }
        } else {
            System.out.println("Número de assento inválido.");
        }
    }

    private static void cancelarReserva(boolean[] assentos) {
        Scanner scanner = new Scanner(System.in);
        exibirAssentosDisponiveis(assentos);

        System.out.print("Digite o número do assento a ser cancelado: ");
        int numeroAssento = scanner.nextInt();

        if (numeroAssento >= 1 && numeroAssento <= 10) {
            if (assentos[numeroAssento - 1]) {
                assentos[numeroAssento - 1] = false;
                System.out.println("Reserva do assento " + numeroAssento + " cancelada com sucesso.");
            } else {
                System.out.println("Assento não reservado. Escolha outro assento.");
            }
        } else {
            System.out.println("Número de assento inválido.");
        }
    }
}
