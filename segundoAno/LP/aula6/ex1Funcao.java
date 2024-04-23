import java.util.Scanner;

public class ex1Funcao {

    public static int DobroNum(int num){
        int dobro = num*2;
        return dobro;
    }
    public static void main(String[] args) {
        int num;
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite um valor: ");
        num = ler.nextInt();
        System.out.println("O dobro do numero digitado eh "+DobroNum(num));
        ler.close();
    }
}