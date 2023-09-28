/*
Programa em java que calcula se um numero
inteiro é divisivel por 3 e/ou 5,digitado
pelo usuário.
Feito por: Yuri
*/
import java.util.Scanner;

public class Eleicao{
	public static void main(String[]args){
		Scanner tec = new Scanner(System.in);
		float eleitores,vValido,vBranco,vNulo;
		System.out.print("Digite o numero total de eleitores no municipio:  ");
		eleitores = tec.nextInt();
		System.out.print("Digite o numero de votos validos:  ");
		vValido = tec.nextInt();
		System.out.print("Digite o numero de votos brancos:  ");
		vBranco = tec.nextInt();
		System.out.print("Digite o numero de votos nulos:  ");
		vNulo = tec.nextInt();
	    if(vNulo+vBranco+vValido != eleitores){
		  System.out.print("Voce digitou algum valor incorreto");
		}
		else{
		  NumAPorcentagem cal = new NumAPorcentagem();
		  float porValido = cal.calcular(eleitores,vValido);
		  float porBranco = cal.calcular(eleitores,vBranco);
		  float porNulo = cal.calcular(eleitores,vNulo);
		  System.out.println("Representacao dos valores digitados em porcentagem:");
		  System.out.printf("Total de eleitores: 100 %n Votos Validos: %.2f %n Votos Brancos: %.2f %n Votos Nulos: %.2f",porValido,porBranco,porNulo);
		}
	}	
}