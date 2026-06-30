public class VendaProduto {
    private Venda vendafeita;
    private Produto produtoVendido;
    private int qtd;
    private float precoNaVenda;

    private VendaProduto(Venda vendafeita,Produto produtoVendido,int qtd,float precoNaVenda){
        this.precoNaVenda = precoNaVenda;
        this.produtoVendido = produtoVendido;
        this.vendafeita = vendafeita;
        this.qtd = qtd;
    }

    //também finalizar as condições
    public static VendaProduto getInstanceVendaProduto(Venda vendafeita,Produto produtoVendido,int qtd,float precoNaVenda){
        if (true) {
            VendaProduto vp = new VendaProduto(vendafeita, produtoVendido, qtd, precoNaVenda);
            return vp;
        }
        return null;
    }

    public Venda getVendaProduto() {
        return vendafeita;
    }
    public void setVendaProduto(Venda vendaProduto) {
        this.vendafeita = vendaProduto;
    }
    public Produto getProdutoVendido() {
        return produtoVendido;
    }
    public void setProdutoVendido(Produto produtoVendido) {
        this.produtoVendido = produtoVendido;
    }
    public float getPrecoNaVenda() {
        return precoNaVenda;
    }
    public void setPrecoNaVenda(float precoNaVenda) {
        this.precoNaVenda = precoNaVenda;
    }
    public int getQtd() {
        return qtd;
    }
    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
    
}
