import java.util.Scanner;

public class atividade1 {

    public static void main(String[] args) {
        int num[] = new int[10];
        int totPar = 0;
        Scanner leitura = new Scanner(System.in);
        for(int i=0;i < 10;i++){
            System.out.println("Digite um valor para a posicao "+i);
            num[i] = leitura.nextInt();
            if (num[i]%2 == 0) {
                totPar ++;
            }
        }
        System.out.println("O total de pares digitados é: "+totPar);
        System.out.println("Os valores pares sao: ");
        for(int i=0;i < 10;i++){
           if (num[i]%2 == 0) {
                System.out.println(num[i]+" na posicao "+i);
           } 
        }
        leitura.close();
    }
}