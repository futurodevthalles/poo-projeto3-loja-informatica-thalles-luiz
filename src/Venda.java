public class Venda {
    private static int cdvenda;
    private float  precoTotal;
    private String dtVenda;
    private Cliente clienteVenda;
    private Vendedor vendedorVenda;

    private Venda(float  precoTotal, String dtVenda,Cliente clienteVenda,Vendedor vendedorVenda){
        this.precoTotal = precoTotal;
        this.dtVenda = dtVenda;
        this.clienteVenda = clienteVenda;
        this.vendedorVenda = vendedorVenda;
        cdvenda++;

    }

    //finalizar esse também
    public static Venda getInstanceVenda(float  precoTotal, String dtVenda,Cliente clienteVenda,Vendedor vendedorVenda){
        if (false) {
            return null;
        }

        Venda v = new Venda( precoTotal,dtVenda, clienteVenda, vendedorVenda);
        return v;
    }







    public int getCdvenda() {
        return cdvenda;
    }
    public void setCdvenda(int cdvenda) {
        this.cdvenda = cdvenda;
    }
    public float getPrecoTotal() {
        return precoTotal;
    }
    public void setPrecoTotal(float precoTotal) {
        this.precoTotal = precoTotal;
    }
    public String getDtVenda() {
        return dtVenda;
    }
    public void setDtVenda(String dtVenda) {
        this.dtVenda = dtVenda;
    }
    public Cliente getClienteVenda() {
        return clienteVenda;
    }
    public void setClienteVenda(Cliente clienteVenda) {
        this.clienteVenda = clienteVenda;
    }
    public Vendedor getVendedorVenda() {
        return vendedorVenda;
    }
    public void setVendedorVenda(Vendedor vendedorVenda) {
        this.vendedorVenda = vendedorVenda;
    }
    
}
