package ex3;

//import java.util.ArrayList;
/*
 Feito por: Yuri
 Data: 17/07/24
 */
public class Principal {
    public static void main(String[] args) {
        //ArrayList<Endereco> enderecoLista1 = new ArrayList<Endereco>();
        //ArrayList<Endereco> enderecoLista2 = new ArrayList<Endereco>();
        //Endereco[] endereco1 = new Endereco[3];
        Endereco 
        endereco1 = new Endereco("Lombardi", 1, "Salvador", "Bahia"),
        endereco2 = new Endereco("Reis", 2, "Niteroi", "Rio de Janeiro");
        //endereco3 = new Endereco("Conceicao", 3, "Sao Joao Del Rei", "Minas Gerais");

        //enderecoLista1.add(endereco1);
        //enderecoLista1.add(endereco2);
        //enderecoLista1.add(endereco3); 

        //Endereco 
        //endereco4 = new Endereco("Evaristo", 5, "Doutor", "Sao Paulo"),
        //endereco5 = new Endereco("Ponte", 6, "Prefeito", "Rio Grande Do Sul"),
        //endereco6 = new Endereco("Chico", 7, "Perito", "Amazonas");

        //enderecoLista2.add(endereco4);
        //enderecoLista2.add(endereco5);
        //enderecoLista2.add(endereco6); 
        
        Pessoa p1 = new Pessoa("Golias","1234-6789", endereco1);
        Pessoa p2 = new Pessoa("Carmo", "0987-6543", endereco2);

        p1.exibirDados();
        System.out.println();
        p2.exibirDados();
    }
}
