import excecoes.LojaInformaticaException;

public class Vendedor extends Cliente{
    private static int id;
    private float salario =1800;
    private float comissao =0;
    private float porcentualcomissao = 0.025f; //2.5%
    private int percentualDesconto = 25;
    private Venda[] vendasfeitas;



    public Vendedor(String nome, String telefone) {
        super(nome, telefone);
    }

    public static Vendedor getInstance(String nome, String telefone) {
        if (nome != null && !nome.isBlank()
                && telefone != null && !telefone.isBlank()) {
            return new Vendedor(nome, telefone);
        } else {
            throw new LojaInformaticaException("Dados inválidos para criação do vendedor!");
        }
    }


    @Override
     
    public double desconto(double valor) {
        return valor - (valor * (1-percentualDesconto) / 100);
    }

    //tambem exception
public void adicionairaohistovendas(Venda v){
        for (int i = 0; i>vendasfeitas.length; i++) {
            if(vendasfeitas[i] == null){
                vendasfeitas[i] = v;
                break;
            }
        }
    }


    public float getSalario() {
        return salario;
    }


    public void setSalario(float salario) {
        this.salario = salario;
    }


    public float getComissao() {
        return comissao;
    }


    public void setComissao(float comissao) {
        this.comissao = comissao;
    }


    public float getPorcentualcomissao() {
        return porcentualcomissao;
    }


    public void setPorcentualcomissao(float porcentualcomissao) {
        this.porcentualcomissao = porcentualcomissao;
    }




    


    public int getPercentualDesconto() {
        return percentualDesconto;
    }


    public void setPercentualDesconto(int percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }

//vetpr
    public Venda[] getVendasfeitas() {
        return vendasfeitas;
    }

    public void setVendasfeitas(Venda[] vendasfeitas) {
        this.vendasfeitas = vendasfeitas;
    }




    
}
