//classe criada por Yuri e Yago
//Data:10/04
public class Carro {
   private String marca;
   private String modelo;
   private int ano;
   private int quilometragemAtual;
   private int quilometragemUltimaTroca;
   
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }
    public int getAno() {
        return ano;
    }
    public int getQuilometragemAtual() {
        return quilometragemAtual;
    }
    public int getQuilometragemUltimaTroca() {
        return quilometragemUltimaTroca;
    }
    public Carro(String marca,String modelo,int ano,int quilometragemAtual,int quilometragemUltimaTroca) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.marca = marca;
        this.quilometragemAtual = quilometragemAtual;
        this.quilometragemUltimaTroca = quilometragemUltimaTroca;
    }
   void AumentarQuilometragem(int novaQuilometragem){
    if (novaQuilometragem>quilometragemAtual) {
        quilometragemAtual = novaQuilometragem;
    }
   }
   void exibirDetalhes(){
    System.out.println("Informacoes do Carro:");
    System.out.println("Marca do Carro: "+ marca);
    System.out.println("Marca do Modelo: "+ modelo);
    System.out.println("Ano do Carro: "+ ano);
    System.out.println("Quilometragem Atual do Carro: "+ quilometragemAtual);
    System.out.println("Quilometragem da Ultima Troca de Oleo:"+ quilometragemUltimaTroca);    
    }
    boolean VerificarTrocaOleo(){
        if ((quilometragemAtual-quilometragemUltimaTroca) >= 10000 ) {
            return true;
        }
        else{
            return false;
        }   
    }
    void realizarTrocadeOleo(){
        quilometragemUltimaTroca = quilometragemAtual;
    }
}
