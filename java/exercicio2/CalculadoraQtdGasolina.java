/*
Algoritmo que calcula quantos litros de gasolina terá no tanque de acordo
com o dinheiro que você gastará e o preço da gasolina
Feito por:Yuri
Dia:15/06/23
*/
import java.util.Scanner;
public class CalculadoraQtdGasolina{
  public void calcularGasolina(){
	Scanner leia;
	float valorDaGasolina,valorPago,qtdGasolina;
	leia = new Scanner(System.in);
	System.out.println("Digite o preco da gasolina:");
	valorDaGasolina = leia.nextFloat();
	System.out.println("Digite o quantidade que ira pagar:");
	valorPago = leia.nextFloat();
	qtdGasolina = valorPago/valorDaGasolina;
	System.out.printf("A quantidade de gasolina sera: %.1f litros ",qtdGasolina);
  }
}	