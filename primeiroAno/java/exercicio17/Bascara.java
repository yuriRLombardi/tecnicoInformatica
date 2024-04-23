/*
 programa em Java que
le os coeficientes "a", "b" e "c"
de uma equação quadrática(ou que usa bascará) e
calcula suas raízes.
*/
import java.util.Scanner;
public class Bascara{
	public static void main(String[]args){
		Scanner tec = new Scanner(System.in);
		System.out.println("Digite o coeficiente A da equacao");
		double a = tec.nextDouble();
		System.out.println("Digite o coeficiente B da equacao");
		double b = tec.nextDouble();
		System.out.println("Digite o coeficiente C da equacao");
		double c = tec.nextDouble();
		double delta = Math.pow(b,2)-4*a*c;
		double x1 = ((b * -1) + Math.sqrt(delta)) / (2*a);
		double x2 = ((b * -1) - Math.sqrt(delta)) / (2*a);
		System.out.println("As raizes da equacao sao "+ x1 + " e " + x2);
		tec.close();
	}
}