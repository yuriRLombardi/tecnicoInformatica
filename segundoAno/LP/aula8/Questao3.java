import java.util.Scanner;

public class Questao3 {

    public static double cauculoQuadrado(double n1){ 
       Scanner sc=new Scanner(System.in);
       
        do{

        System.out.println("Digite um valor positivo =(");
        n1=sc.nextDouble();
       }while(n1<0);
        double res=n1*n1;
        sc.close();
        return res;
      
    }
    public static void main(String[] args) {
        double n1;
        Scanner scan=new Scanner(System.in);
        System.out.println("Digite um numero: ");
        n1=scan.nextDouble();
      double res= cauculoQuadrado(n1);
      System.out.println("");    
      System.out.println("O valor digitado elevado ao quadrado eh: "+res);
      scan.close();
      //Feito por Yuri e Kevin
        //Data: 19/03/24

    }
}
