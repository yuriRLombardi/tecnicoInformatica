/*
programa em Java que calcula o intervalo
do coeficiente "a" e "b",digitados pelo usuário
Feito por:Yuri 
*/
import java.util.Scanner;
public class Intervalo{
	public static void main(String[]args){
		int a,b;
		System.out.println("---------------------");
		System.out.println("Intervalo");
		System.out.println("---------------------");
		Scanner tec = new Scanner(System.in);
		System.out.println("Digite o coeficiente A para calcular a sequencia sendo inteiro");
		 a = tec.nextInt();
		System.out.println("Digite o coeficiente B para calcular a sequencia sendo inteiro");
		 b = tec.nextInt();
		System.out.println("---------------------");
		System.out.println("Contando...");
		System.out.println("---------------------");
		if(a < b){
			System.out.println("");
		    for(int i = a;i <= b;i++){
				System.out.printf("%d...",i);
			}
		}
		else{
			System.out.println("");
			for(int i = a;i >= b;i--){
				System.out.printf("%d...",i);
			}
		}
		tec.close();
	}
}