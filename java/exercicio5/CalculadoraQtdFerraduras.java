/*
Algoritmo em java que calcula a quantidade de ferraduras nessesarias
para todos os cavalos em um haste
Feito por:Yuri
Data:09/06/23
*/
import java.util.Scanner;
public class CalculadoraQtdFerraduras{
	public void calcularFerraduras(){
	 Scanner ler;
	 int qtdCavalos,qtdFerraduras;
	 ler = new Scanner(System.in);
	 System.out.println("Digite a quantidade de cavalos do haste:");
	 qtdCavalos =ler.nextInt();
	 qtdFerraduras= qtdCavalos*4;
	 System.out.printf("A quantidade de ferraduras nessesarias para todos os cavalos terem eh:%d",qtdFerraduras);
	} 
}