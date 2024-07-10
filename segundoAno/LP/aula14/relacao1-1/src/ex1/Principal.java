package ex1;
/*
 Feito por: Yuri, Yago e Kevin
 Data: 02/07/24
 */
public class Principal {
public static void main(String[] args) {
    
Endereco e1 = new Endereco("Salgado", 7, "Campinas", "Sao Paulo"); 
Pessoa p1 = new Pessoa("Jacinto", "7419", e1);    
Endereco e2 = new Endereco("doce", 14, "Sao Goncalo", "Rio de Janeiro");
Pessoa p2 = new Pessoa("Anaconda", "3071", e2);

p1.exibirDados();
System.out.println();
p2.exibirDados();

}



}
