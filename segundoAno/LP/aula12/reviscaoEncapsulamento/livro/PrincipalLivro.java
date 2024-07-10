package livro;

import java.util.Scanner;

/*
 * Feito por: Yuri
 * Data: 18/06/24
 * Modificações: 19/06/24
 */
public class PrincipalLivro {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Livro l1 = new Livro("Como treinar seu dragao", "Cressida Cowell", 2010, 35.11f);
        Livro l2 = new Livro("A Filha do Pantano", "Franny Billingsley", 2018, 59.90f);
        l1.exibir();
        l2.exibir();
        System.out.println("Qual desconto tu deseja aplicar em porsentagem?");
        float desconto = ler.nextInt();
        System.out.println("Qual livro você deseja aplicar o desconto?[1/2]");
        int op = ler.nextInt();
        if (op != 1 && op != 2) {
            do {
                System.out.println("ERRO! A opcao tem que ser 1 para o primeiro livro ou 2 para o segundo livro");
                System.out.println("Redigite a opcao: ");
                op = ler.nextInt();
            } while (op != 1 && op != 2);
        }
        else if (op == 1) {
            l1.aplicarDesconto(desconto);
                System.out.printf("O novo preço do livro é %.2f",l1.getPreco());
        }
        else if (op == 2) {
            l2.aplicarDesconto(desconto);
            System.out.printf("O novo preço do livro é %.2f",l2.getPreco());
        }
        ler.close();
    }
}
