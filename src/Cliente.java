public class Cliente {
    private static int cdpessoa;
    private String nome;
    private String telefone;
    float desconto;
    private Venda[] historicoCompras;
    
    private Cliente (String nome, String telefone, float desconto){
        cdpessoa++;
        this.nome=nome;
        this.telefone=telefone;
        this.desconto=desconto;
    }
    public static Cliente getInstance(String nome, String telefone, float desconto, Venda venda){
        if(cdpessoa>0 || nome!=null && !nome.isBlank() && nome.length()>1 
            && telefone!=null && !telefone.isBlank() && desconto>=0 
            && desconto<=100){
            return new Cliente(nome,telefone,desconto);
        }
        else{
           throw new LojaInformaticaException("Dados inválidos para criação do cliente!");
        }
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