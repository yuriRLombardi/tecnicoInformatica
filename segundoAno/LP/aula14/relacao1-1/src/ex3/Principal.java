package ex3;
/*
 Feito por: Yuri,Kevin e Yago
 Data: 03/07/24
 */
public class Principal {
    public static void main(String[] args) {
        Endereco[] endereco1 = new Endereco[3];
        endereco1[0] = new Endereco("Lombardi", 1, "Salvador", "Bahia");
        endereco1[1] = new Endereco("Reis", 2, "Niteroi", "Rio de Janeiro");  
        endereco1[2] = new Endereco("Conceicao", 3, "Sao Joao Del Rei", "Minas Gerais");    
        Endereco[] endereco2 = new Endereco[3];
        endereco2[0] = new Endereco("Evaristo", 5, "Doutor", "Sao Paulo");
    endereco2[1] = new Endereco("Ponte", 6, "Prefeito", "Rio Grande Do Sul");
        endereco2[2] = new Endereco("Chico", 7, "Perito", "Amazonas");
        Pessoa p1 = new Pessoa("Golias","1234-6789", endereco1);
        Pessoa p2 = new Pessoa("Carmo", "0987-6543", endereco2);
        p1.exibirDados();
        System.out.println();
        p2.exibirDados();
    }
}
