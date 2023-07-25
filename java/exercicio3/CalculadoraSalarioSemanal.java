/*
Algoritmo que calcula o salário semanal de um vendedor de certa companhia
Feito por:Yuri
Dia:15/06/23
*/
import java.util.Scanner;
public class CalculadoraSalarioSemanal{
  public void calcularSalario(){
	Scanner leia;
	float valorDaVenda,salario;
	leia = new Scanner(System.in);
	System.out.println("Digite o valor que o funcionario vendeu na semana:");
	valorDaVenda = leia.nextFloat();
	salario = ((valorDaVenda*10)/100)+200;
	System.out.printf("O salario semanal desse funcionario eh:%.2f ",salario);
  }
}