import java.util.Scanner;

public class SimuladorLabirinto {
    public static void main(String[] args) {
        char[][] labirinto = {
            {'S', ' ', ' ', '#', '#', ' ', '#', '#', ' ', 'E'},
            {'#', '#', ' ', '#', '#', ' ', '#', '#', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#'},
            {'#', ' ', '#', '#', '#', '#', ' ', '#', ' ', '#'},
            {'#', ' ', '#', '#', ' ', '#', ' ', '#', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', ' ', ' ', ' ', '#'},
            {'#', ' ', ' ', ' ', '#', '#', ' ', '#', '#', '#'},
            {'#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
        };

        int posicaoAtualLinha = 0;
        int posicaoAtualColuna = 0;

        exibirLabirinto(labirinto);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Digite o movimento (W, A, S, D) ou Q para sair: ");
            char movimento = scanner.next().charAt(0);

            if (movimento == 'Q' || movimento == 'q') {
                System.out.println("Saindo...");
                break;
            }

            moverJogador(labirinto, movimento, posicaoAtualLinha, posicaoAtualColuna);

            if (chegouAoFim(labirinto, posicaoAtualLinha, posicaoAtualColuna)) {
                System.out.println("Parabéns! Você chegou ao fim do labirinto!");
                break;
            }

            exibirLabirinto(labirinto);
        }
    }

    private static void exibirLabirinto(char[][] labirinto) {
        for (char[] linha : labirinto) {
            for (char celula : linha) {
                System.out.print(celula + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void moverJogador(char[][] labirinto, char direcao, int linhaAtual, int colunaAtual) {
        int novaLinha = linhaAtual;
        int novaColuna = colunaAtual;

        switch (direcao) {
            case 'W':
            case 'w':
                novaLinha--;
                break;
            case 'A':
            case 'a':
                novaColuna--;
                break;
            case 'S':
            case 's':
                novaLinha++;
                break;
            case 'D':
            case 'd':
                novaColuna++;
                break;
        }

        if (novaLinha >= 0 && novaLinha < labirinto.length &&
            novaColuna >= 0 && novaColuna < labirinto[0].length &&
            labirinto[novaLinha][novaColuna] != '#') {
            // Movimento válido, atualiza a posição do jogador
            labirinto[linhaAtual][colunaAtual] = ' ';
            labirinto[novaLinha][novaColuna] = 'S';
            linhaAtual = novaLinha;
            colunaAtual = novaColuna;
        } else {
            System.out.println("Movimento inválido. Tente novamente.");
        }
    }

    private static boolean chegouAoFim(char[][] labirinto, int linhaAtual, int colunaAtual) {
        return labirinto[linhaAtual][colunaAtual] == 'E';
    }
}
