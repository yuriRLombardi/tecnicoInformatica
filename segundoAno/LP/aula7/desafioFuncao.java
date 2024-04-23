import java.util.Scanner;

public class desafioFuncao {

    public static double MostraDecimais(double num){
        int numI = (int)num;
        double retDecimal = num-numI;
        return retDecimal;
    }
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        double num;
        System.out.println("Digite um valor decimal: ");
        num = ler.nextDouble();
        if (num<0) {
            do{
                System.out.println("Digite outro valor que nao seja negativo");
                num = ler.nextDouble();
            }while(num<0);
        }
        double decimal = MostraDecimais(num);
        System.out.printf("A parte decimal desse numero eh %.2f",decimal);
        ler.close();

    }
}