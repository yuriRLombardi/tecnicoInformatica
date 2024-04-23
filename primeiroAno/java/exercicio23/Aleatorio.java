/*
Programa em java que simula um jogo de 
adivinhação,no qual vocetem que adivinhar o numero de
0 à 1000,tanto dicas se numero que usuário digitou
é maior ou menor do que o numero secreto
Feito por: Yuri
*/
import java.util.Random;
import java.util.Scanner;
public class Aleatorio{
	public static void main(String[] args){
		Scanner tec = new Scanner(System.in);
		Random random = new Random();
		int numeroAleatorio = random.nextInt(1001);
		int palpite;
		int tentativas = 0;
		do{
			System.out.print("Qual eh o numero inteiro ?: ");
			palpite = tec.nextInt();
			if(palpite > numeroAleatorio){
				System.out.println("Seu palpite eh maior do que o numero");
			}
			else if (palpite < numeroAleatorio){
				System.out.println("Seu palpite eh menor do que o numero");
			}
			else{
				System.out.println("Numero encontrado");
			}
			tentativas ++;
		}while(palpite != numeroAleatorio);
		System.out.println("");
		System.out.println("Meus parabens, voce adivinhou o numero!!!");
		System.out.println("O numero era : "+ numeroAleatorio);
		System.out.printf("Voce adivinhou o numero com %d tentativas",tentativas);
	}
}
