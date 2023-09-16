/*
programa em Java que vê se um 
quadrilatero é um quadrado ou um retângulo,
medindo sua área e perímetro com a base
e altura digitadas pelo usuário.
Feito por:Yuri
*/
import java.util.Scanner;
public class Quadrilatero{
	public static void main(String[]args){
		Scanner tec = new Scanner(System.in);
		System.out.println("---------------------");
		System.out.println("Quadrilatero");
		System.out.println("---------------------");
		System.out.println("Digite a base do quadrilatero");
		float base = tec.nextFloat();
		System.out.println("Digite a altura do quadrilatero");
		float  altura = tec.nextFloat();
		System.out.println("---------------------");
		System.out.println("Analisando...");
		System.out.println("---------------------");
		if(base == altura){
			System.out.println("Seu quadrilatero eh um quadrado");
		}
		else{
			System.out.println("Seu quadrilatero eh um retangulo");
		}
		System.out.println("---------------------");
		System.out.println("Calculando...");
		System.out.println("---------------------");
		float perimetro = (base*2) + (altura*2);
		System.out.println("O perimetro da figura eh " + perimetro);
		float area = base * altura;
		System.out.println("A area da figura eh " + area);
		tec.close();
	}
}