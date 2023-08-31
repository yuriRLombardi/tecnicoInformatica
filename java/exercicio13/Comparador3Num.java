/*Programa em Java para caulcular o número maior 
e menor entre 3 números  
Feito por: Yago e Yuri*/
 
import java.util.Scanner;

 public class Comparador3Num{
	public static void main(String[]args){

		float n1,n2,n3; 

		Scanner tec = new Scanner(System.in);

		System.out.println("Digite um Número");
		n1 = tec.nextFloat();

		System.out.println("Digite outro Número");
		n2 = tec.nextFloat();

		System.out.println("Digite outro Número");
		n3 = tec.nextFloat();

		if(n1>n2 && n1>n3){
			System.out.printf("maior numero eh %f",n1);
		}	
		else if (n2>n1 && n2>n3){		
				System.out.printf("maior numero eh %f",n2);
		}	
		else{
			if (n3>n1 && n3>n2){		
				System.out.printf("maior numero eh %f",n3);
			}
			else{
				System.out.printf("Nao ah maior numero");
				}
			}	

		System.out.println("");

		if (n1<n2 && n1<n3){
			System.out.printf("menor número eh %f",n1);
		}	
		else if (n2<n1 && n2<n3){		
				System.out.printf("menor número eh %f",n2);
			}	
			else{
				if (n3<n1 && n3>n2){		
					System.out.printf("menor numero eh %f",n3);
				}
				else{
					System.out.printf("Nao ah menor numero");
					}
			}
		System.out.println("");
		
		if ((n1 == n2 && n1 == n3)&&(n2 == n3)){
			System.out.printf("Os numeros sao iguais");
		}	
		
    }
 }