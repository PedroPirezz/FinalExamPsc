import java.util.Scanner;

public class EmpresaDeEntregas {

    public static void main(String[] args) {
        GerenciadorDeEntregas gerenciador = new GerenciadorDeEntregas();
        gerenciador.carregarEntregas();
        
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        
        do {
            System.out.println("1. Adicionar nova entrega");
            System.out.println("2. Listar entregas");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcao) {
                case 1:
                    System.out.print("Digite o código do pedido: ");
                    String codigoPedido = scanner.nextLine();
                    System.out.print("Digite o nome do destinatário: ");
                    String destinatario = scanner.nextLine();
                    System.out.print("Digite o endereço: ");
                    String endereco = scanner.nextLine();
                    System.out.print("Digite a data de entrega: ");
                    String dataEntrega = scanner.nextLine();
                    
                    try {
                        gerenciador.adicionarEntrega(new Entrega(codigoPedido, destinatario, endereco, dataEntrega));
                    } catch (Exception e) {
                        System.out.println("Erro ao adicionar entrega: " + e.getMessage());
                    }
                    break;
                case 2:
                    gerenciador.listarEntregas();
                    break;
                case 3:
                    gerenciador.salvarEntregas();
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 3);
        
        scanner.close();
    }
}
