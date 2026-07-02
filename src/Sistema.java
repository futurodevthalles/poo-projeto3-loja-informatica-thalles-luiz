public class Sistema {
    private static Sistema instancia;
    private Cliente[] clientes = new Cliente[10];
    private Vendedor[] vendedores = new Vendedor[10];
    private Venda[] historico = new Venda[10];
    private VendaProduto[] vendaProdutos = new VendaProduto[20];
    private Produto[] produtos = new Produto[10];
    // private float porcentualcomissao = 0.10f; //10%

    // Método Singleton
    public static Sistema getInstance() {

        if (instancia == null) {
            instancia = new Sistema();
        }

        return instancia;
    }

    // metodo init

    public void init() {
        // Clientes
        addCliente("Carlos", "11987654321");
        addCliente("Marcos", "21999887766");
        addCliente("Fernanda", "31995554444");

        // Vendedores
        addVendedor("Joao", "11999990001");
        addVendedor("Maria", "11999990002");
        addVendedor("Pedro", "11999990003");

        // Produtos
        addProduto("Notebook", 3500.00f, "Eletronico");
        addProduto("Mouse", 89.90f, "Periferico");
        addProduto("Teclado", 199.90f, "Periferico");

        // Venda 1
        Venda v1 = addVenda(3500.00f, "01/07/2026", clientes[0], vendedores[0]);

        addVendaProduto(v1, produtos[0], 1, produtos[0].getPrecop());

        // Venda 2
        Venda v2 = addVenda(289.80f, "02/07/2026", clientes[1], vendedores[1]);

        addVendaProduto(v2, produtos[1], 1, produtos[1].getPrecop());
        addVendaProduto(v2, produtos[2], 1, produtos[2].getPrecop());

        // Venda 3
        Venda v3 = addVenda(379.70f, "03/07/2026", clientes[2], vendedores[2]);

        addVendaProduto(v3, produtos[1], 2, produtos[1].getPrecop());
        addVendaProduto(v3, produtos[2], 1, produtos[2].getPrecop());
    }

    // Construtor privado
    private Sistema() {

    }

    // adicionando cada um dos objetos no sistema:
    // para adicionar clientes
    public void addCliente(String nome, String telefone) {

        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] == null) {
                clientes[i] = Cliente.getInstance(nome, telefone);
                break;
            }
        }
    }

    // para adicionar vendedores
    public void addVendedor(String nome, String telefone) {

        for (int i = 0; i < vendedores.length; i++) {
            if (vendedores[i] == null) {
                vendedores[i] = Vendedor.getInstance(nome, telefone);
                break;
            }
        }
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] == null) {
                clientes[i] = Cliente.getInstance(nome, telefone);
                break;
            }
        }

    }

    // para adicionar vendas
    public Venda addVenda(float precoTotal, String dtVenda, Cliente clienteVenda, Vendedor vendedorVenda) {
        Venda venda = Venda.getInstanceVenda(precoTotal, dtVenda, clienteVenda, vendedorVenda);

        for (int i = 0; i < historico.length; i++) {
            if (historico[i] == null) {
                historico[i] = venda;
                break;
            }
        }
        return venda;
    }

    // para adicionar produtos
    public void addProduto(String nmproduto, float precop, String tipoProduto) {
        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i] == null) {
                produtos[i] = Produto.getInstance(nmproduto, precop, tipoProduto);
                break;
            }
        }
    }

    // para adicionar Vendarodutos
    public void addVendaProduto(Venda vendafeita, Produto produtoVendido, int qtd, float precoNaVenda) {
        for (int i = 0; i < vendaProdutos.length; i++) {
            if (vendaProdutos[i] == null) {
                vendaProdutos[i] = VendaProduto.getInstanceVendaProduto(vendafeita, produtoVendido, qtd,
                        precoNaVenda);
                break;
            }
        }
    }

    // funções de listagem
    // listar produtos
    public void listarProdutos() {
        for (int i = 1; i <= produtos.length; i++) {
            if (produtos[i - 1] != null) {
                System.out.println(i + "  " + produtos[i-1].getNmproduto() + " " + produtos[i-1].getPrecop());
            }
        }
    }

    // listar clientes
    public void obterListaClientes() {
        for (int i = 1; i <= clientes.length; i++) {
            if (clientes[i - 1] != null)
                System.out.println(i + "  " + clientes[i-1].getNome() + " " + clientes[i-1].geTelefone());
        }
    }

    // listar vendedor
    public void obterListaVendedor() {
        for (int i = 1; i <= vendedores.length; i++) {
            if (vendedores[i - 1] != null)
                System.out.println(i + "  " + vendedores[i-1].getNome() + " " + vendedores[i-1].geTelefone());
        }
    }

    // listar vendas
    public void obterListaVendas() {
        for (int i = 1; i <= historico.length; i++) {

            if (historico[i - 1] != null) {

                System.out.println("VENDA " + i);

                for (int j = 0; j < vendaProdutos.length; j++) {

                    if (vendaProdutos[j] != null &&
                            vendaProdutos[j].getVendafeita().getCdvendaatual() == historico[i - 1].getCdvendaatual()) {

                        System.out.println(
                                (j + 1) + " " +
                                        vendaProdutos[j].getProdutoVendido().getNmproduto() + " " +
                                        vendaProdutos[j].getQtd() + " " +
                                        vendaProdutos[j].getPrecoNaVenda());
                    }
                }
            }
        }
    }

    // getters e setters

    public Cliente[] getClientes() {
        return clientes;
    }

    public void setClientes(Cliente[] clientes) {
        this.clientes = clientes;
    }

    public Vendedor[] getVendedores() {
        return vendedores;
    }

    public void setVendedores(Vendedor[] vendedores) {
        this.vendedores = vendedores;
    }

    public Venda[] getHistorico() {
        return historico;
    }

    // public void setHistorico(Venda[] historico) {
    // this.historico = historico;
    // }

    // public VendaProduto[] getVendaProdutos() {
    // return vendaProdutos;
    // }

    public void setVendaProdutos(VendaProduto[] vendaProdutos) {
        this.vendaProdutos = vendaProdutos;
    }

    // corrigir copia
    public Produto[] getProdutos() {
        return produtos;
    }

    public void setProdutos(Produto[] produtos) {
        this.produtos = produtos;
    }

    // public float getPorcentualcomissao() {
    // return porcentualcomissao;
    // }

    // public void setPorcentualcomissao(float porcentualcomissao) {
    // this.porcentualcomissao = porcentualcomissao;
    // }

    // funções de exclusão

    public void removerCliente(int indice) {
        clientes[indice] = null;
    }

    public void removerVendedor(int indice) {
        vendedores[indice] = null;
    }

    public void removerProduto(int indice) {
        produtos[indice] = null;
    }

}
