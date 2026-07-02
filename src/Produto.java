public class Produto {
    private static int cdproduto;
    private String nmproduto;
    private float precop;
    private String tipoProduto;

    private Produto (String nmproduto,float precop, String tipoProduto ){
        this.nmproduto=nmproduto;
        this.precop=precop;
        this.tipoProduto=tipoProduto;
        cdproduto++;
    }
    public static Produto getInstance(String nmproduto,float precop, String tipoProduto){
        if (nmproduto!=null && !nmproduto.isBlank() && precop >= 0 && tipoProduto!=null 
        && !tipoProduto.isBlank()) {
            return new Produto(nmproduto, precop, tipoProduto);
        }else{
            throw new LojaInformaticaException("Dados inválidos para criação do produto!");
        }
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
    public int getCdProduto(){
        return cdproduto;
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