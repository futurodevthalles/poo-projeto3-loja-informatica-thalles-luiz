public class Sistema {
    private static Sistema instancia;
    private Cliente[] clientes = new Cliente[10];
    private Vendedor[] vendedores = new Vendedor[10];
    private Venda[] historico = new Venda[10];
    private VendaProduto[] vendaProdutos = new VendaProduto[20];
    private Produto[] produtos = new Produto[10];
    private float porcentualcomissao = 0.10f; //10%
    
    // Método Singleton
    public static Sistema getInstance() {
    
        if (instancia == null) {
            instancia = new Sistema();
        }
    
        return instancia;
    }

//                                              metodo init

    public void init (){

    }


    // Construtor privado
    private Sistema() {

    }

    //                                          adicionando cada um dos objetos no sistema:
    // para adicionar clientes
    public void addCliente(String nome, String telefone, float desconto){

        for (int i = 0; i < clientes.length ;i++) {
            if (clientes[i] == null) {
                clientes[i] = Cliente.getInstance(nome, telefone);
                break;
            }
        }
    }

    //para adicionar vendedores
    public void addVendedor(String nome, String telefone){

        for (int i = 0; i < clientes.length ;i++) {
            if (clientes[i] == null) {
                clientes[i] = Cliente.getInstance(nome, telefone);
            }
        }
    }

    //para adicionar vendas
    public Venda addVenda (float  precoTotal, String dtVenda,Cliente clienteVenda,Vendedor vendedorVenda){
        Venda venda = Venda.getInstanceVenda(precoTotal, dtVenda, clienteVenda, vendedorVenda);

        for (int i = 0; i < historico.length ;i++) {
            if (historico[i] == null) {
                historico[i] = venda;
            }
        }
        return venda;
    }

    //para adicionar produtos
    public void addProduto (String nmproduto,float precop, String tipoProduto){
        for (int i = 0; i < produtos.length ;i++) {
            if (produtos[i] == null) {
                produtos[i] = Produto.getInstance(nmproduto,precop,tipoProduto);
            }
        }
    }

    //para adicionar Vendarodutos
    public void addVendaProduto (Venda vendafeita,Produto produtoVendido,int qtd,float precoNaVenda){
        for (int i = 0; i < vendaProdutos.length ;i++) {
            if (vendaProdutos[i] == null) {
                vendaProdutos[i] = VendaProduto.getInstanceVendaProduto(vendafeita,produtoVendido,qtd,precoNaVenda);
            }
        }
    }

    //                                                  funções de listagem
    //listar produtos
    public void listarProdutos(){
        for (int i = 0; i <produtos.length;i++) {
            if (produtos[i] != null) {
                System.out.println( i+"  "+produtos[i].getNmproduto()+" "+produtos[i].getPrecop());
            }
        }
    }
                

    //listar clientes
    public void obterListaClientes(){
        for (int i = 0; i <clientes.length;i++) {
            if (clientes[i] != null)
            System.out.println( i+"  "+clientes[i].getNome()+" "+clientes[i].geTelefone());
        }
    }

    //listar vendedor
    public void obterListaVendedor(){
        for (int i = 0; i <vendedores.length;i++) {
            if (vendedores[i] != null)
            System.out.println( i+"  "+vendedores[i].getNome()+" "+vendedores[i].geTelefone());
        }
    }
    
    //listar vendas
    public void obterListaVendas(){
        for (int i = 0; i< historico.length;i++) {
            System.out.println("VENDA"+i);
            for (int j = 0; j< historico.length;j++) {
                if ( vendaProdutos[j].getVendafeita().getCdvendaatual() == historico[i].getCdvendaatual()){
                    System.out.println(j+" "+vendaProdutos[j].getProdutoVendido().getNmproduto()+" "+vendaProdutos[j].getQtd()+" "+vendaProdutos[j].getPrecoNaVenda());
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

    public void setHistorico(Venda[] historico) {
        this.historico = historico;
    }

    public VendaProduto[] getVendaProdutos() {
        return vendaProdutos;
    }

    public void setVendaProdutos(VendaProduto[] vendaProdutos) {
        this.vendaProdutos = vendaProdutos;
    }

    public Produto[] getProdutos() {
        return produtos;
    }

    public void setProdutos(Produto[] produtos) {
        this.produtos = produtos;
    }

    public float getPorcentualcomissao() {
        return porcentualcomissao;
    }

    public void setPorcentualcomissao(float porcentualcomissao) {
        this.porcentualcomissao = porcentualcomissao;
    }
    
    

}
