package aula19;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        String exibir = 
        """
        CONVERTEDOE DE PALAVRAS
        [1] Converter Maiuculas
        [2] Converter Minusculas
        [3] Mostrar quatas vezes voce usou os metodos
        [4] Ou Sair
        """;
        String palavra;
        int opcao = 0;
        do {
            System.out.println(exibir);
            opcao = ler.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Digite alguma palavra: ");
                    ler.nextLine();
                    palavra = ler.nextLine();
                    System.out.println(MyLin.transformaMaiuscula(palavra));
                    
                    break;
                case 2:
                    System.out.println("Digite alguma palavra: ");
                    ler.nextLine();
                    palavra = ler.nextLine();
                    System.out.println(MyLin.transformaMinuscula(palavra));
                    break;
                case 3:
                    System.out.println("A quantidade de vezes que voce usou foi: " + MyLin.usadaQuantasVezes());
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Invalido");
                    break;
            }
        } while (opcao != 4);
        System.out.println("Encerrando...");
        ler.close();
    }
}
