/*
 programa em Java que
le os coeficientes "a", "b" e "c"
de uma equação quadrática(ou que usa bascará) e
calcula suas raízes e repete o programa até o usuário
digitar zero.
Feito por:Yuri
*/
import java.util.Scanner;
public class BascaraDoWhile{
	public static void main(String[]args){
		Scanner tec = new Scanner(System.in);
		int opcao = 1; 
		do{
		System.out.println("-------------------------------------------------------------------");
		System.out.println("Digite o coeficiente A da equacao");
		double a = tec.nextDouble();
		System.out.println("Digite o coeficiente B da equacao");
		double b = tec.nextDouble();
		System.out.println("Digite o coeficiente C da equacao");
		double c = tec.nextDouble();
		double delta = Math.pow(b,2)-(4*a*c);
		double x1 = ((b * -1) + Math.sqrt(delta)) / (2*a);
		double x2 = ((b * -1) - Math.sqrt(delta)) / (2*a);
		System.out.println("As raizes da equacao sao "+ x1 + " e " + x2);
		System.out.println("Se quiser continur,digite zero,caso contrario,digite qualquer numero");
		opcao = tec.nextInt();
		System.out.println("--------------------------------------------------------------------");
		}
		while(opcao != 0);
		System.out.println("Fim do programa");
		tec.close();
	}
}