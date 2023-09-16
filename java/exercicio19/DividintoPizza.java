/*
programa em Java que divide uma pizza
de 8 pedaços para uma quantidade de pessoa
entre 1 e 8,definindo também o quanto de pizza
sobrara
Feito por:Yuri 
*/
import java.util.Scanner;
public class DividintoPizza{
	public static void main(String[]args){
		Scanner tec = new Scanner(System.in);
		System.out.println("---------------------");
		System.out.println("Dividador de Pizza");
		System.out.println("---------------------");
		System.out.println("Digite quantas pessoas vao comer a pizza de 8 pedacos entre 1 e 8");
		int pessoas = tec.nextInt();
		System.out.println("---------------------");
		System.out.println("Calculando...");
		System.out.println("---------------------");
		if((pessoas > 8) || (pessoas <= 0)){
			System.out.println("---------------------");
			System.out.println("Erro");
			System.out.println("---------------------");
			System.out.println("Quantidade de pessoas invalido");
		}
		else{
			int pizza =(int)8/pessoas;
			System.out.println("Para cada pessoa se teve dar "+ pizza+" pedacos de pizza");
			int resto =  8 % pessoas;
			System.out.println("E sobrou apenas " +resto+ " pedacos de pizza");
		}
		tec.close();
	}
}