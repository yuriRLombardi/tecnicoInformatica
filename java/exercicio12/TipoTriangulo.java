/*
Programa em java que calcula se com as medidas digitadas pelo
usuário,tá para formar um triângulo ou não, e ver qual seria o
tipo desse triângulo, se ter para formar
*/

import java.util.Scanner;

public class TipoTriangulo{
	public static void main(String[]args){
	Scanner tec = new Scanner(System.in);
	System.out.println("Digite o primeiro lado do triangulo");
	float L1 = tec.nextFloat();
	System.out.println("Digite o sengundo lado do triangulo");
	float L2 = tec.nextFloat();
	System.out.println("Digite o terceiro lado do triangulo");
	float L3 = tec.nextFloat();
	if (L1 + L2 < L3 || L1 + L3 < L2 || L2 + L3< L1){
		System.out.println("Nao ta para formar um triangulo");
		System.out.println("Fim do programa");
	}
	else{
		System.out.println("Ta para formar um triangulo");
		if(L1==L2 && L1 == L3){
			System.out.println("De acordo com as medidas,seu triangulo eh equilatero");
			System.out.println("Fim do programa");
		}
		else if((L1 == L2 || L1 == L3) || (L2 == L3)){
			System.out.println("De acordo com as medidas,seu triangulo eh isoseles");
			System.out.println("Fim do programa");
		}
		else{
			System.out.println("De acordo com as medidas,seu triangulo eh escaleno");
			System.out.println("Fim do programa");
		}
	}
  }
}