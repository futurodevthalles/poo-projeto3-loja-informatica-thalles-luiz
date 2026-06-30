public class Vendedor extends Cliente{
    private static int id;
    float salario;
    float comissao;
    int qtdvendas;
    int percentualDesconto;
    private Venda[] vendasfeitas;
    private Venda[] historicoCompras;

    @Override
     
    public double desconto(double valor) {
        return valor - (valor * percentualDesconto / 100);
    }
    
}
