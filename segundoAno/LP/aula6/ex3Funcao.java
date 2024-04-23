import java.util.Scanner;

public class ex3Funcao {
    public static void tempo(){
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite as horas:");
        int h = ler.nextInt();
        if (h >= 24 || h <0) {
            do{
                System.out.println("Digite outro valor que nao seja negativo ou igual e maior a 24");
                h = ler.nextInt();
            }while(h >= 24 || h<0);
        }
        System.out.println("Digite os minutos:");
        int m = ler.nextInt();
        if (m >= 60 || m <0) {
            do{
                System.out.println("Digite outro valor que nao seja negativo ou igual e maior a 60");
                m = ler.nextInt();
            }while(m >= 60 || h<0);
        }
        System.out.println("Digite os segundos:");
        int s = ler.nextInt();
        if (s >= 60 || s <0) {
            do{
                System.out.println("Digite outro valor que nao seja negativo ou igual e maior a 60");
                s = ler.nextInt();
            }while(s >= 60 || h<0);
        }
        
        int resS = (h*3600)+(m*60)+s;
        System.out.println("A soma dos valores convertidos em segundos eh "+resS);
        ler.close();
    }
    public static void main(String[] args) {
        tempo();
    }
}
