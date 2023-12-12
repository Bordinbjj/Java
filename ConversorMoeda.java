import java.util.Scanner;

public class ConversorMoedas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor em reais: ");
        double valorEmReais = scanner.nextDouble();

        System.out.print("Escolha a moeda de conversão (USD, EUR, GBP): ");
        String moedaDestino = scanner.next().toUpperCase();

        double taxaDeCambio = 0.0;

        switch (moedaDestino) {
            case "USD":
                taxaDeCambio = 5.50; // Exemplo de taxa de câmbio para dólar
                break;
            case "EUR":
                taxaDeCambio = 6.20; // Exemplo de taxa de câmbio para euro
                break;
            case "GBP":
                taxaDeCambio = 7.80; // Exemplo de taxa de câmbio para libra esterlina
                break;
            default:
                System.out.println("Moeda de destino inválida.");
                return;
        }

        double valorConvertido = valorEmReais / taxaDeCambio;

        System.out.println("Valor convertido para " + moedaDestino + ": " + valorConvertido);
    }
}
