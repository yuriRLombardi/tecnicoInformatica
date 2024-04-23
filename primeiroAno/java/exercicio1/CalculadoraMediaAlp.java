/*
Algoritmo que calcula a média da matéria ALP
Feito por:Yuri
Dia:15/06/23
Modificação:19/06/23
*/
import java.util.Scanner;
public class CalculadoraMediaAlp{
  public void calcularMedia(){
	Scanner leia;
	float mediaBimestral,mediaAtv,prova,trabalho,lista,participacao,atv1,atv2,atv3;
	leia = new Scanner(System.in);
	System.out.println("Digite a nota da primeira atividade:");
	atv1 = leia.nextFloat();
	System.out.println("Digite a nota da segunda atividade:");
	atv2 = leia.nextFloat();
	System.out.println("Digite a nota da terceira atividade:");
	atv3 = leia.nextFloat();
	mediaAtv = (atv1+atv2+atv3)/3;
	System.out.println("Digite a nota da prova:");
	prova = leia.nextFloat();
	System.out.println("Digite a nota da lista:");
	lista = leia.nextFloat();
	System.out.println("Digite a nota de participacao de 0 a 1:");
	participacao = leia.nextFloat();
	System.out.println("Digite a nota do trabalho:");
	trabalho = leia.nextFloat();
	mediaBimestral =(mediaAtv*4+prova*3+trabalho*3)/(10+lista+participacao);
	System.out.printf("Sua media de ALP eh: %.1f",mediaBimestral);
  }
}	