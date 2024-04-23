/*
Algoritmo em java que calcula os gastos de um cliente do restaurante Bem-Bão
por quilo do prato desse cliente
para todos os cavalos em um haste
Feito por:Yuri
Data:09/06/23
*/
import java.util.Scanner;
public class CalculadoraGastoRestaurante{
	public void calcularGasto(){
	 Scanner ler;
	 float quiloDoPrato,gastoDoPrato;
	 ler = new Scanner(System.in);
	 System.out.println("Digite o peso do prato em quilos:");
	 quiloDoPrato =ler.nextFloat();
	 gastoDoPrato= quiloDoPrato*12;
	 System.out.printf("A quantidade que sera gasto eh:%f",gastoDoPrato);
	} 
}