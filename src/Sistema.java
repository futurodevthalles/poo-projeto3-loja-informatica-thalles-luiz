    public class Sistema {
    private static Sistema instancia;
    private Cliente[] clientes = new Cliente[10];
    private Vendedor[] vendedores = new Vendedor[10];
    private Venda[] historico = new Venda[10];
    private VendaProduto[] vendaProdutos = new VendaProduto[20];
    private Produto[] produtos = new Produto[10];
    private float porcentualcomissao = 0.10f; //10%


    // Construtor privado
    private Sistema() {

    }

    // adicionando cada um dos objetos no sistema:
    // para adicionar clientes
    public void AddCliente(String nome, String telefone, float desconto){

        for (int i = 0; i < clientes.length ;i++) {
            if (clientes[i] == null) {
                clientes[i] = Cliente.GetInstanceCliente(nome, telefone, desconto);
            }
        }
    }

    //para adicionar vendedores
    public void AddVendedor(String nome, String telefone, float desconto){

        for (int i = 0; i < clientes.length ;i++) {
            if (clientes[i] == null) {
                clientes[i] = Cliente.GetInstanceCliente(nome, telefone, desconto);
            }
        }
    }

    //para adicionar vendas
    public void AddVenda (float  precoTotal, String dtVenda,Cliente clienteVenda,Vendedor vendedorVenda){
        for (int i = 0; i < historico.length ;i++) {
            if (historico[i] == null) {
                historico[i] = Venda.getInstanceVenda(precoTotal, dtVenda, clienteVenda, vendedorVenda);
            }
        }
    }

    //para adicionar Vendarodutos
    public void AddVendaProduto (Venda vendafeita,Produto produtoVendido,int qtd,float precoNaVenda){
        for (int i = 0; i < vendaProdutos.length ;i++) {
            if (vendaProdutos[i] == null) {
                vendaProdutos[i] = VendaProduto.getInstanceVendaProduto(vendafeita,produtoVendido,qtd,precoNaVenda);
            }
        }
    }

    // Método Singleton
    public static Sistema getInstance() {

        if (instancia == null) {
            instancia = new Sistema();
        }

        return instancia;
    }
}
