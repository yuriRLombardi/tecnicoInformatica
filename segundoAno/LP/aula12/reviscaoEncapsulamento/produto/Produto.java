package produto;
/*
 * Feito por: Yuri
 * Data: 18/06/24
 * Modificações: 19/06/24
 */
public class Produto {
    private String nome;
    private String codigo;
    private double preco;
    private int quantidade;
    
    public Produto(String nome, String codigo, double preco, int quantidade) {
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.quantidade = quantidade;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public double getPreco() {
        return preco;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void adicionarEstoque(int adicionar){
        if (adicionar > 0) {
            this.quantidade += adicionar;
        }
        else{
            System.out.println("Adição Invalida");
        }
    }
    public void removerEstoque(int remover){
        if (quantidadeSuficiente(remover)) {
            this.quantidade -= remover;
        }
        else{
            System.out.println("Remocao Invalida");
        }
    }
    private boolean quantidadeSuficiente(int remocao){
        if (remocao <= this.quantidade && remocao > 0) {
            return true;
        }
        else{
            return false;
        }
    }
    public void aplicarDesconto(double desconto){
        if (desconto > 0) {
            if (precoValido(preco - (preco * (desconto/100)))) {
                this.preco = preco - (preco * (desconto/100)); 
            }
            else{
                System.out.println("Desconto Invalido");
            }
        }
        else{
            System.out.println("Desconto Invalido");
        }
    }
    private boolean precoValido(double novoPreco){
        if (novoPreco >= 0) {
            return true;
        }
        else{
            return false;
        }
    }
    public void exibirInformacoes(){
        String text =
        """
        INFORMAÇÕES DO PRODUTO
        Nome: %s
        Codigo: %s
        Preco: %.2f
        Quantidade: %d  
        \n     
        """;
        System.out.printf(text,this.getNome(),this.getCodigo(),this.getPreco(),this.getQuantidade());
    }
}
