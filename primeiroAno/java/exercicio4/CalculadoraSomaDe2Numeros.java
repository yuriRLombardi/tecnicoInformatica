/*
Algoritmo que soma dois numeros inteiros
Feito por:Yuri
Data:07/06/23
Modificação:09/06/23
*/
import java.util.Scanner;
public class CalculadoraSomaDe2Numeros{
	public void calcularSoma(){
	 Scanner ler;
	 int num1,num2,soma;
	 ler = new Scanner(System.in);
	 System.out.println("Digite um numero inteiro:");
	 num1 =ler.nextInt();
	 System.out.println("Digite outro numero inteiro:");
	 num2 =ler.nextInt();
	 soma= num1+num2;
	 System.out.printf("A soma de %d e %d eh igual ah: %d",num1,num2,soma);
	} 
}