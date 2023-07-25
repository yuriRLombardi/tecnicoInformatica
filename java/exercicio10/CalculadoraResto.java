/*
Algoritmo em java que calcula o resto da divisão de dois numeros inteiros
Feito por: Yuri e Kevin
*/
import  java.util.Scanner;

public class CalculadoraResto{
	
	public void calcularResto(){
		Scanner ler;
		ler=new Scanner(System.in);
		int n1,n2,resto;
		
		System.out.println("Digite um numero inteiro");
		n1=ler.nextInt();
		System.out.println("Digite outro numero inteiro");
		n2=ler.nextInt();
		resto = n1 % n2;
		System.out.printf("O resto da divisao de %d e %d eh igual ah %d",n1,n2,resto);
	}
}