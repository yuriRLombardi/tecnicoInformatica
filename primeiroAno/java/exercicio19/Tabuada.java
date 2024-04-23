/* programa em java que calcula a tabuada de um 
numero que o usuário digitar
Feito por: Yuri
*/
import java.util.Scanner;
public class Tabuada {
	public static void main(String[]args){
		Scanner tec = new Scanner(System.in);
		int num;
		int res = 0;
		System.out.println("---------------------");
		System.out.println("Tabuada");
		System.out.println("---------------------");
		System.out.println("Digite um valor inteiro para fazer a tabuada");
		num = tec.nextInt();
		if (num > 0){
			System.out.println("---------------------");
			System.out.println("Executando Tabuada");
			System.out.println("---------------------");
			for(int i = 1;i <= 10;i++){
				res = num + res;
				System.out.printf("%d X %d = %d %n",num,i,res);
			}
		}
		else if(num == 0){
				System.out.println("A tabuada eh tudo zero");
		}
		else{
			System.out.println("---------------------");
			System.out.println("Erro");
			System.out.println("---------------------");
			System.out.println("Voce digitou um numero invalido,ou seja, numero negativo");	
		}
	tec.close();	
	}
}