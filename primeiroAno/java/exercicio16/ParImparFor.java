/*
programa em java que faz a contagem de 0 à 100
com o comando for, definindo numeros
pares e impares
Feito por: Yuri
*/
public class ParImparFor{
	public static void main(String[]args){
		for(int i = 0;i<= 100;i++){
			if(i%2==0){
				System.out.println(i + " eh par");
			}
			else{
				System.out.println(i + " eh impar");			
			}
		}	
	}
}