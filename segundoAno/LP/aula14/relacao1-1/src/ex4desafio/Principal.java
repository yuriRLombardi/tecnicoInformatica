package ex4desafio;
/*
 Feito por: Yuri
 Data: 03/07/24
 */
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("CADASTROS DE PESSOAS");
        System.out.print("Digite seu nome: ");
        String nome = ler.nextLine();
        System.out.print("Digite seu CPF: ");
        String cpf = ler.nextLine();
        System.out.print("Quantos enderecos voce quer cadastrar?: ");
        int quantidade = ler.nextInt();
        Endereco[] enderecos = new Endereco[quantidade];
        for(int c = 0;c < quantidade;c++){
            if (c == 0) {
                ler.nextLine(); 
            }
            System.out.println("DIGITE ESSAS INFORMACOES DO ENDERECO "+(c+1));
            System.out.print("Rua: ");
            String rua = ler.nextLine();
            System.out.print("Numero: ");
            int num = ler.nextInt();
            System.out.print("Cidade: ");
            ler.nextLine();
            String cidade = ler.nextLine();
            System.out.print("Estado: ");
            String estado = ler.nextLine();
            enderecos[c] = new Endereco(rua, num, cidade, estado);
            System.out.println();
        }
        Pessoa pessoa = new Pessoa(nome, cpf, enderecos);
        pessoa.exibirDados();
        ler.close();
    }
}
