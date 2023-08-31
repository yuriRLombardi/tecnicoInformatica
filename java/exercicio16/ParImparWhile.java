/*
programa em java que faz a contagem de 0 à 100
com o comando while, definindo numeros
pares e impares
Feito por: Yuri
*/
public class ParImparWhile{
	public static void main(String[]args){
		int n = 0;
		while(n <= 100){
			if(n%2==0){
				System.out.println(n + " eh par");
			}
			else{
				System.out.println(n + " eh impar");			
			}
			n++;
		}
		
	}
}