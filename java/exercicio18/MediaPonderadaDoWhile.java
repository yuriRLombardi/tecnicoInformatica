/*
 programa em Java que
armazema valores que o usuario digitar e só para
de armazenar até que usuariodecida parar de digitar os valores,
fazendo uma media ponderada com os valores o usuario digitou
Feito por:Yuri
*/
import java.util.Scanner;
public class MediaPonderadaDoWhile{
	public static void main(String[]args){
		Scanner tec = new Scanner(System.in);
		int opcao;
		float num;
		float soma = 0;
		float media;
		int contador = 0;
		do{
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("Digite um numero tanto inteiro,tanto decimal para fazer a media:  ");
		num = tec.nextFloat();
		soma += num;
		contador += 1;
		System.out.println("Se quiser continuar basta digitar zero,caso contratio,digite qualquer numero");
		opcao = tec.nextInt();
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("");
		}
		while(opcao != 0);
		media = soma/contador;
		System.out.println("A media eh igual ah " + media);
		System.out.println("Fim do programa");
		tec.close();
	}
}