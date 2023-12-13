import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CarrinhoDeCompras {
    public static void main(String[] args) {
        Map<String, Double> catalogo = new HashMap<>();
        Map<String, Integer> carrinho = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        catalogo.put("Produto A", 20.0);
        catalogo.put("Produto B", 30.0);
        catalogo.put("Produto C", 15.0);

        while (true) {
            System.out.println("\n=== Carrinho de Compras ===");
            System.out.println("1. Adicionar Produto ao Carrinho");
            System.out.println("2. Remover Produto do Carrinho");
            System.out.println("3. Ver Carrinho");
            System.out.println("4. Finalizar Compra");
            System.out.println("5. Sair");

            System.out.print("Escolha uma opção: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("=== Catálogo de Produtos ===");
                    for (Map.Entry<String, Double> entry : catalogo.entrySet()) {
                        System.out.println(entry.getKey() + ": R$" + entry.getValue());
                    }
                    System.out.print("Digite o nome do produto a ser adicionado: ");
                    scanner.nextLine(); // Consumir a quebra de linha pendente
                    String produto = scanner.nextLine();
                    if (catalogo.containsKey(produto)) {
                        carrinho.put(produto, carrinho.getOrDefault(produto, 0) + 1);
                        System.out.println("Produto adicionado ao carrinho.");
                    } else {
                        System.out.println("Produto não encontrado no catálogo.");
                    }
                    break;
                case 2:
                    System.out.println("=== Seu Carrinho ===");
                    for (Map.Entry<String, Integer> entry : carrinho.entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue() + " unidades");
                    }
                    System.out.print("Digite o nome do produto a ser removido: ");
                    scanner.nextLine(); // Consumir a quebra de linha pendente
                    String produtoRemover = scanner.nextLine();
                    if (carrinho.containsKey(produtoRemover)) {
                        int quantidadeAtual = carrinho.get(produtoRemover);
                        if (quantidadeAtual > 1) {
                            carrinho.put(produtoRemover, quantidadeAtual - 1);
                        } else {
                            carrinho.remove(produtoRemover);
                        }
                        System.out.println("Produto removido do carrinho.");
                    } else {
                        System.out.println("Produto não encontrado no carrinho.");
                    }
                    break;
                case 3:
                    System.out.println("=== Seu Carrinho ===");
                    for (Map.Entry<String, Integer> entry : carrinho.entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue() + " unidades");
                    }
                    break;
                case 4:
                    double total = 0.0;
                    System.out.println("=== Resumo da Compra ===");
                    for (Map.Entry<String, Integer> entry : carrinho.entrySet()) {
                        String produtoCompra = entry.getKey();
                        int quantidadeCompra = entry.getValue();
                        double precoUnitario = catalogo.get(produtoCompra);
                        double subtotal = quantidadeCompra * precoUnitario;
                        total += subtotal;
                        System.out.println(produtoCompra + ": " + quantidadeCompra + " unidades - R$" + subtotal);
                    }
                    System.out.println("Total da compra: R$" + total);
                    carrinho.clear();
                    System.out.println("Compra finalizada com sucesso.");
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
