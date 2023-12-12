import java.util.Scanner;

public class JogoDaForca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] palavras = {"java", "programacao", "desenvolvimento", "computador", "algoritmo"};
        String palavraSecreta = palavras[(int) (Math.random() * palavras.length)];
        char[] palavraAtual = new char[palavraSecreta.length()];

        for (int i = 0; i < palavraAtual.length; i++) {
            palavraAtual[i] = '_';
        }

        int tentativas = 6;

        while (tentativas > 0) {
            System.out.println("Palavra: " + String.valueOf(palavraAtual));
            System.out.println("Tentativas restantes: " + tentativas);
            System.out.print("Digite uma letra: ");
            char letra = scanner.next().charAt(0);

            boolean acertou = false;

            for (int i = 0; i < palavraSecreta.length(); i++) {
                if (palavraSecreta.charAt(i) == letra) {
                    palavraAtual[i] = letra;
                    acertou = true;
                }
            }

            if (!acertou) {
                tentativas--;
            }

            if (String.valueOf(palavraAtual).equals(palavraSecreta)) {
                System.out.println("Parabéns! Você acertou a palavra: " + palavraSecreta);
                break;
            }
        }

        if (tentativas == 0) {
            System.out.println("Você perdeu! A palavra era: " + palavraSecreta);
        }
    }
}
