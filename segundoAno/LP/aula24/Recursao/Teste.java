import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.print("Digite um numero inteiro: ");
        int num = ler.nextInt();
        System.out.println("Resultado da soma \"fatorial\": "+Calculo.somar(num));
        System.out.println("Fatorial do numero: "+ Calculo.fatorial(num));
        ler.close();
    }
}
