/*
Programa em java que calcula se um numero
inteiro é divisivel por 3 e/ou 5,digitado
pelo usuário.
Feito por: Yuri
*/
import java.util.Scanner;

public class Divisor3e5{
	public static void main(String[]args){
		Scanner tec = new Scanner(System.in);
		int num;
		System.out.print("Digite um numero inteiro qualquer:  ");
		num = tec.nextInt();
	    if(num % 3 == 0 && num % 5 == 0){
		  System.out.println("O numero digitado naon eh divisivel por 3 e por 5");
		}
		else if(num % 3 == 0){
			System.out.println("O numero digitado eh divisivel por 3");
		}
		else{
			if(num % 5 == 0){
				System.out.println("O numero digitado eh divisivel por 5");
			}
			else{
				System.out.println("O numero digitado nao eh divisivel por 3 e por 5");
			}
		}
	}
}