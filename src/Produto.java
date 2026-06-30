public class Produto {
    private static int cdproduto;
    String nmproduto;
    float precop;
    String tipoProduto;

    public Produto (String nmproduto,float precop, String tipoProduto ){
        this.nmproduto=nmproduto;
        this.precop=precop;
        this.tipoProduto=tipoProduto;
        cdproduto++;
    }
    
    public String getNmproduto(){
        return this.nmproduto;
    }
    public float getPrecop(){
        return this.precop;
    }
    public String getTipoProduto(){
        return this.tipoProduto;
    }
    public void setNmproduto(String nmproduto) {
        this.nmproduto = nmproduto;
    }
    public void setPrecop(float precop) {
        this.precop = precop;
    }
    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }
}