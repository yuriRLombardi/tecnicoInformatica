/*
programa em Java que calcula um fibonacci
sendo definido o limite pelo usuário
Feito por:Yuri 
*/
import java.util.Scanner;
public class Fibonacci{
	public static void main(String[]args){
		int n;
		System.out.println("---------------------");
		System.out.println("Sequencia Fibonacci");
		System.out.println("---------------------");
		Scanner tec = new Scanner(System.in);
		System.out.println("Digite um numero inteiro para definir um limite:");
		n = tec.nextInt();	
		System.out.println("---------------------");
		System.out.println("Contando...");
		System.out.println("---------------------");
		int f1 = 0;
		int f2 = 1;
		for(int f3 = 0;f3 <= n;f3 = f1 + f2){
		System.out.print(f3+"...");
		f1 = f2;
		f2 = f3;
		}

		tec.close();
	}
}