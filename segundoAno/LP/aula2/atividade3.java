import java.util.Scanner;

public class atividade3 {
    public static void main(String[] args) {
        int sentido[] = new int[6];
        Scanner ler = new Scanner(System.in);
        for(int i =0;i<6;i++){
            System.out.println("Digite o "+(i+1)+"o valor:");
            sentido[i] = ler.nextInt();
        }
        System.out.println("Os valores digitados foram: ");
        for(int i = 5;i>=0;i--){
            System.out.println(sentido[i]);
        }
        ler.close();
    }
}
