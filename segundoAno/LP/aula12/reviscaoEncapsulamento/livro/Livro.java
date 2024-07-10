package livro;
/*
 * Feito por: Yuri
 * Data: 18/06/24
 */
public class Livro {
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private float preco;

    public Livro(String titulo, String autor, int anoPublicacao, float preco) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.preco = preco;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public int getAnoPublicacao() {
        return anoPublicacao;
    }
    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
    public float getPreco() {
        return preco;
    }
    public void aplicarDesconto(float desconto){
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
    private boolean precoValido(float novoPreco){
        if (novoPreco >= 0 ) {
            return true;
        }
        else{
            return false;
        }
    }
    public void exibir(){
        String texto = 
        """
        INFORMACOES DO LIVRO
        Título do Livro: %s
        Autor do Livro: %s
        Ano de publicacao: %d
        Preco: %.2f    
        \n   
        """;
        System.out.printf(texto,this.getTitulo(),this.getAutor(),this.getAnoPublicacao(),this.getPreco());
    }
}
