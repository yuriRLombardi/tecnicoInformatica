/*
Programa em java que faz a soma de dois numeros
atráves de uma classe criada
Feito por:Yuri
*/
import java.util.Scanner;
public class Principal{
	
	public static void main(String[]args){
		Scanner tec = new Scanner(System.in);
		System.out.print("Digite um valor para a soma");
		float n1 = tec.nextFloat();
		System.out.print("Digite um outro valor para a soma");
		float n2 = tec.nextFloat();
		Calculadora cal = new Calculadora();
		float soma = cal.somar(n1,n2);
		System.out.print(soma);
	}
	
}