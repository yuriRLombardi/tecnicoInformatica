import java.util.Scanner;

public class PrincipalR {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Digite a largura do Retangulo");    
        double  largura = sc.nextDouble();
        if (largura<=0) {
            do{
                System.out.println("Digite outro valor maior do que 0");
                largura = sc.nextDouble();
            
            }while(largura<=0);
        }
    System.out.println("Digite a altura do retangulo");
    double altura = sc.nextDouble();
    if (altura<=0) {
        do{
            System.out.println("Digite outro valor maior do que 0");
            altura = sc.nextDouble();
        
        }while(altura<=0);
    }
   if (altura == largura) {
    do {
        System.out.println("altura e largura tem que ser com valores diferentes");
        System.out.println("Digite a altura");
        altura = sc.nextDouble();
        System.out.println("Digite a larguras");
        largura = sc.nextDouble();
    } while (altura == largura);
   }
    Retangulo retangulo1 = new Retangulo(largura, altura);    
    System.out.println("O valor da area eh  " + retangulo1.area() );
    System.out.println("O valor da Perimetro eh  " + retangulo1.perimetro() );
    sc.close();
    }
}
