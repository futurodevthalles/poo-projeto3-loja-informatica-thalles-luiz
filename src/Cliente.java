public class Cliente {
    private static int cdpessoa;
    private String nome;
    private String telefone;
    private Venda[] historicoCompras = new Venda[10];
    
    protected Cliente (String nome, String telefone){
        cdpessoa++;
        this.nome=nome;
        this.telefone=telefone;
        
    }
    
    public static Cliente getInstance(String nome, String telefone){
        if(cdpessoa>0 || nome!=null && !nome.isBlank() && nome.length()>1 
            && telefone!=null && !telefone.isBlank()){
            return new Cliente(nome,telefone);
        }
        else{
           throw new LojaInformaticaException("Dados inválidos para criação do cliente!");
        }
    }

    //talvez adicionar execption
    public void adicionairaohistoricocompras(Venda v){
        for (int i = 0; i>historicoCompras.length; i++) {
            if(historicoCompras[i] == null){
                historicoCompras[i] = v;
                break;
            }
        }
    }

    public float desconto(){
        return 1;
    }

    public static int getCdpessoa() {
        return cdpessoa;
    }
    public static void setCdpessoa(int cdpessoa) {
        Cliente.cdpessoa = cdpessoa;
    }
    public String getTelefone() {
        return telefone;
    }
    // public void setDesconto(float desconto) {
    //     this.desconto = desconto;
    // }
    public Venda[] getHistoricoCompras() {
        return historicoCompras;
    }
    public void setHistoricoCompras(Venda[] historicoCompras) {
        this.historicoCompras = historicoCompras;
    }
    public String getNome(){
        return this.nome;
    }
    // public float getDesconto(){
    //     return this.desconto;
    // }
    public void setNome(String nome){
        this.nome=nome;
    }
    public void setTelefone(String telefone){
        this.telefone=telefone;
    }
 
    public double desconto(double valor) {
        return valor;
    }

    public String geTelefone(){
        return this.telefone;
    }
    
}