public class Cliente {
    private static int cdpessoa;
    private String nome;
    private String telefone;
    float desconto;
    private Venda[] historicoCompras;
    
    public Cliente (String nome, String telefone, float desconto, Venda venda){
        this.nome=nome;
        this.telefone=telefone;
        this.desconto=desconto;
        this.historicoCompras[cdpessoa]=venda;
        cdpessoa++;
    }
    public String getNome(){
        return this.nome;
    }
    public float getDesconto(){
        return this.desconto;
    }
    public void setNome(String nome){
        this.nome=nome;
    }
    public void setTelefone(String telefone){
        this.telefone=telefone;
    }
 
    public double desconto(double valor) {
        return valor;
    }

}