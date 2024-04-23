public class Produto {
     String nome;
     double preco;
     int quantidadeEmEstoque;
     public Produto(String nome,double preco,int quantidadeEmEstoque){
          this.nome = nome;
          this.preco = preco;
          this.quantidadeEmEstoque = quantidadeEmEstoque;
     } 
     public double valorTotEstoque(){
          double valor = preco*quantidadeEmEstoque;
          return valor;
     }
     public void diminuir(int quantidade){
          quantidadeEmEstoque -= quantidade; 
     }
     public void aumentar(int quantidade){
          quantidadeEmEstoque += quantidade; 
     }
}