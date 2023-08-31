/*
programa em java que vê se o numero é par ou impar e ate se é neutro,
no qual se n for diferente de zero,irá repetir o programa
*/
import java.util.Scanner;
public class ParOuImparRep{
	public static void main(String[]args){
		Scanner tec = new Scanner(System.in);
		int n = 1;
		while (n != 0){
			System.out.println("Digite um numero:");
			n = tec.nextInt();
			if (n == 0){
				System.out.println("Numero NEUTRO");
			}
			else if (n%2 == 0){
				System.out.println("Numero PAR");
			}
			else{
				System.out.println("Numero IMPAR");
			}
		}
	}
}