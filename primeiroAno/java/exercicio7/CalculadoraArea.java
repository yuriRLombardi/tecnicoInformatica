/*
Algoritmo em java que calcula à àrea de um retângulo
Feito por:Yuri
Data:09/06/23
*/
import java.util.Scanner;
public class CalculadoraArea{
	public void calcularArea(){
	 Scanner ler;
	 float base,altura,area;
	 ler = new Scanner(System.in);
	 System.out.println("Digite a base do retângulo:");
	 base =ler.nextFloat();
	 System.out.println("Digite a altura do retângulo:");
	 altura =ler.nextFloat();
	 area= base*altura;
	 System.out.printf("De acordo com esses dados,a area do retângulo eh:%f",area);
	} 
}