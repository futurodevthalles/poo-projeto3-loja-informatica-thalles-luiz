import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        
        Sistema.getInstance().init(); 
        
        int opcao = 0;
        do {
            System.out.println("\n=== SISTEMA LOJA DE INFORMATICA ===");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Cadastrar Produto");
            System.out.println("4. Listar Produtos");
            System.out.println("5. Registrar Nova Venda");
            System.out.println("6. Listar Historico de Vendas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: ");
            
            try {
                opcao = leitor.nextInt();
                leitor.nextLine(); 
            } catch (Exception e) {
                System.out.println("Erro: Digite apenas numeros validos.");
                leitor.nextLine(); 
                opcao = -1; 
                continue;
            }
            
            switch (opcao) {
                case 1:
                    System.out.println("\n--- CADASTRO DE CLIENTE ---");
                    System.out.print("Nome do Cliente: ");
                    String nomeC = leitor.nextLine();
                    System.out.print("Telefone: ");
                    String telC = leitor.nextLine();
                    System.out.print("Desconto (%): ");
                    float descC = leitor.nextFloat();
                    
                    try {
                        Cliente novoCliente = Cliente.getInstance(nomeC, telC, descC);
                        Sistema.getInstance().inserirCliente(novoCliente);
                        System.out.println("Cliente cadastrado com sucesso!");
                    } catch (LojaInformaticaException e) {
                        System.out.println("Nao foi possivel cadastrar: " + e.getMessage());
                    }
                    break;
                    
                case 2:
                    System.out.println("\n--- LISTA DE CLIENTES ---");
                    System.out.print(Sistema.getInstance().obterListaClientes());
                    break;

                case 3:
                    System.out.println("\n--- CADASTRO DE PRODUTO ---");
                    System.out.print("Nome do Produto: ");
                    String nomeP = leitor.nextLine();
                    System.out.print("Preco: R$ ");
                    double precoP = leitor.nextDouble();
                    System.out.print("Quantidade em Estoque: ");
                    int estoqueP = leitor.nextInt();
                    
                    try {
                        Produto novoProduto = Produto.getInstance(nomeP, precoP, estoqueP);
                        Sistema.getInstance().inserirProduto(novoProduto);
                        System.out.println("Produto cadastrado com sucesso!");
                    } catch (LojaInformaticaException e) {
                        System.out.println("Erro no produto: " + e.getMessage());
                    }
                    break;
                    
                case 4:
                    System.out.println("\n--- LISTA DE PRODUTOS ---");
                    System.out.print(Sistema.getInstance().obterListaProdutos());
                    break;

                case 5:
                    System.out.println("\n--- REGISTRAR VENDA ---");
                    System.out.println("Clientes Disponiveis:");
                    System.out.print(Sistema.getInstance().obterListaClientes());
                    
                    System.out.print("\nDigite o ID do Cliente: ");
                    int idCliente = leitor.nextInt();
                    
                    System.out.println("\nProdutos Disponiveis:");
                    System.out.print(Sistema.getInstance().obterListaProdutos());
                    
                    System.out.print("\nDigite o ID do Produto: ");
                    long idProduto = leitor.nextLong();
                    System.out.print("Quantidade desejada: ");
                    int qtdVenda = leitor.nextInt();
                    
                    try {
                        Sistema.getInstance().efetuarVenda(idCliente, idProduto, qtdVenda);
                        System.out.println("Venda realizada com sucesso!");
                    } catch (LojaInformaticaException e) {
                        System.out.println("Falha na Venda: " + e.getMessage());
                    }
                    break;
                    
                case 6:
                    System.out.println("\n--- HISTORICO GERAL DE VENDAS ---");
                    System.out.print(Sistema.getInstance().obterListaVendas());
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                    
                default:
                    if (opcao != -1) {
                        System.out.println("Opcao invalida!");
                    }
            }
        } while (opcao != 0);
        
        leitor.close();
    }
}