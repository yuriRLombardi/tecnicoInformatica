/*
programa em Java que le o
raio de uma circunferência e calcula
sua área, perímetro e diâmetro
Feito por:Yuri
*/
import java.util.Scanner;
public class Circunferencia{
	public static void main(String[]args){
		Scanner tec = new Scanner(System.in);
		System.out.println("Digite o raio da circunferencia");
		double raio =tec.nextDouble();
		double area = Math.PI * Math.pow(raio,2);
		System.out.println("A area da circunferencia eh  " + area);
		double perimetro = 2 * Math.PI * raio;
		System.out.println("O perimetro da circunferencia eh  " + perimetro);
		double diametro = 2 * raio;
		System.out.println("O diametro eh " + diametro);
		tec.close();
	}
}