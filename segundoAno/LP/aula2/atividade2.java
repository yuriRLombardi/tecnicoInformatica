import java.util.Scanner;

public class atividade2 {
    public static void main(String[] args) {
        int num[] = new int[10];
        int maior=0,menor=0;
        Scanner ler = new Scanner(System.in);
        for(int i = 0;i < 10;i++){
            System.out.println("Digite o "+(i+1)+"o valor: ");
            num[i] = ler.nextInt();
            if (num[i]>maior) {
                maior = num[i];
            }
        }
        menor = num[0];
        for(int i = 0; i<10; i++){
            if (num[i] == menor) {
                menor = num[i];
            }
            else if (num[i]<menor) {
                menor = num[i];
            }
        }
        System.out.println("O maior valor eh "+maior+" e o menor eh "+menor);
        ler.close();
    }
}
