import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        Sistema s = Sistema.getInstance();

        s.init(); 
        
        int opcao = 0;
        do {
            System.out.println("\n=== SISTEMA LOJA DE INFORMATICA ===");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Cadastrar Produto");
            System.out.println("4. Listar Produtos");
            System.out.println("5. Registrar Nova Venda");
            System.out.println("6. Listar Historico de Vendas");
            System.out.println("7. Cadastrar Vendedor");
            System.out.println("8. Listar Vendedores");
            System.out.println("9 - Obter salário de um vendedor"); //funcionalidade 1?
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
                        s.addCliente(nomeC, telC, descC);

                        // Cliente novoCliente = Cliente.getInstance(nomeC, telC, descC);
                        // Sistema.getInstance().inserirCliente(novoCliente);

                        System.out.println("Cliente cadastrado com sucesso!");
                    } catch (LojaInformaticaException e) {
                        System.out.println("Nao foi possivel cadastrar: " + e.getMessage());
                    }
                    break;
                    
                case 2:
                    System.out.println("\n--- LISTA DE CLIENTES ---");
                    s.obterListaClientes();
                    break;

                case 3:
                    System.out.println("\n--- CADASTRO DE PRODUTO ---");
                    System.out.print("Nome do Produto: ");
                    String nomeP = leitor.nextLine();
                    System.out.print("Preco: R$ ");
                    float precoP = leitor.nextFloat();
                    System.out.print("Tipo de produto: ");
                    String tipoP = leitor.nextLine();
                    
                    try {
                        s.addProduto(nomeP, precoP, tipoP);

                        // Produto novoProduto = Produto.getInstance(nomeP, precoP, estoqueP);
                        // Sistema.getInstance().inserirProduto(novoProduto);

                        System.out.println("Produto cadastrado com sucesso!");
                    } catch (LojaInformaticaException e) {
                        System.out.println("Erro no produto: " + e.getMessage());
                    }
                    break;
                    
                case 4:
                    System.out.println("\n--- LISTA DE PRODUTOS ---");
                    s.listarProdutos();
                    break;

                case 5:
                    System.out.println("\n--- REGISTRAR VENDA ---");
                    System.out.println("Clientes Disponiveis:");
                    s.obterListaClientes();
                    
                    System.out.print("\nDigite o Cliente: ");
                    int idCliente = leitor.nextInt();
                    Cliente c = s.getClientes()[idCliente-1];

                    System.out.println("Vendedores Disponiveis:");
                    s.obterListaVendedor();

                    System.out.print("\nDigite o Vendedor: ");
                    int idVendedor = leitor.nextInt();
                    Vendedor vn = s.getVendedores()[idVendedor-1];

                    System.out.println("digite a data atual");
                    String data = leitor.nextLine();

                    int adicionarProduto;

                    Venda v =s.addVenda(0, data, s.getClientes()[idCliente-1], s.getVendedores()[idVendedor-1]);

                    float precoCompra = 0;
                    do {
                        System.out.println("\nProdutos Disponíveis:");
                        s.listarProdutos();

                        System.out.print("\nDigite o Produto: ");
                        int idProduto = leitor.nextInt();
                        Produto p = (s.getProdutos()[idProduto-1]);

                        System.out.print("Quantidade desejada: ");
                        int qtdVenda = leitor.nextInt();

                        System.out.println("Deseja comprar mais um item?");
                        System.out.println("1 - Sim");
                        System.out.println("2 - Não");
                        adicionarProduto = leitor.nextInt();

                        s.addVendaProduto(v, p, qtdVenda,p.getPrecop());

                        precoCompra = v.getPrecoTotal()+(p.getPrecop()*qtdVenda);

                    } while (adicionarProduto == 1);

                        //operações finais da venda
                        float precofinal = precoCompra*c.desconto();
                        v.setPrecoTotal(precofinal);
                        c.adicionairaohistoricocompras(v);
                        vn.adicionairaohistovendas(v);
                        vn.setComissao(vn.getComissao()+(vn.getPorcentualcomissao()*precofinal));
                    
                        try {
                            // s.efetuarVenda(idCliente, idProduto, qtdVenda);
                        System.out.println("Venda realizada com sucesso!");
                    } catch (LojaInformaticaException e) {
                        System.out.println("Falha na Venda: " + e.getMessage());
                    }
                    break;
                    
                case 6:
                    System.out.println("\n--- HISTORICO GERAL DE VENDAS ---");
                    s.obterListaVendas();
                    break;

                case 7:
                    System.out.println("\n--- CADASTRO DE Vendedor ---");
                    String nomeVendedor = leitor.nextLine();
                    String telVendedor = leitor.nextLine();
                    s.addVendedor(nomeVendedor, telVendedor);

                    break;
                    
                case 8:
                    s.obterListaVendedor();

                    break;
                    
                case 9:
                    System.out.println("SELECIONE O VENDEDOR");
                    s.obterListaVendedor();
                    int icvendedor = leitor.nextInt();
                    Vendedor vd = s.getVendedores()[icvendedor-1];
                    System.out.println("O Salário do vendedor "+vd.getNome()+" no momento é de: "+(vd.getSalario()+vd.getComissao())+", tendo recebido "+vd.getComissao()+" de comissão");

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
