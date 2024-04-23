/*
Programa em java que calcula o quanto a pessoa
terá de desconto numa loja de eletrônicos,baseado no
valor total da compra digitado pelo usuario
Feito por: Yuri
*/
import java.util.Scanner;
public class Desconto{
		public static void main(String[]args){
		Scanner tec = new Scanner(System.in);
		System.out.print("Digite o valor total da sua compra(R$): ");
		float compra = tec.nextFloat();
		if (compra <= 200){
			System.out.println("Nao ha desconto");
			System.out.printf("Voce ira pagar : %.2f",compra);
		}
		else if (compra > 200 && compra <= 500){
			System.out.println("Voce tem um desconto de 10 porcento");
			double valorFinal = compra - (compra * 0.1);
			System.out.printf("Voce ira pagar : %.2f",valorFinal);
		}
		else{
			if(compra > 500 && compra <= 1000){
				System.out.println("Voce tem um desconto de 15 porcento");
				double valorFinal = compra - (compra * 0.15 );
				System.out.printf("Voce ira pagar : %.2f",valorFinal);	
			}
			else{
				System.out.println("Voce tem um desconto de 20 porcento");
				double valorFinal = compra - (compra * 0.20);
				System.out.printf("Voce ira pagar : %.2f",valorFinal);
			}
		}
	}
}