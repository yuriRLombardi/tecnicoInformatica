import java.util.Scanner;

public class ex4Funcao {
    public static double ConsumoMedio(double km,double l){
        double res = km/l;
        return res;
    }
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        double km,l;
        System.out.println("Digite a distancia percorrida em km");
        km = ler.nextDouble();
        if (km<0) {
            do{
                System.out.println("Digite outro valor que nao seja negativo");
                km = ler.nextDouble();
            }while(km<0);
        }
        System.out.println("Digite a quantidade de gasolina ");
        l = ler.nextDouble();
        if (l<0) {
            do{
                System.out.println("Digite outro valor que nao seja negativo");
                l = ler.nextDouble();
            }while(l<0);
        }
        double medio = ConsumoMedio(km, l);
        System.out.println("O consumo medio eh "+medio+"Km/L");
        ler.close();
    }
}
