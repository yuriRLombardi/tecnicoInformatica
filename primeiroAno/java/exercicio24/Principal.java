/*
Programa em java que simula uma calculadora
Alterações feitas por:Yuri
*/
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
    
    Scanner tec = new Scanner(System.in);        
    Calculadora calc = new Calculadora();
    System.out.print("Digite um numero: ");
    double n1 = tec.nextDouble();    
	System.out.print("Digite um sinal de operacao(+ - / *): ");
	String sinal = tec.next();
	System.out.print("Digite outro numero: ");
	double n2 = tec.nextDouble();
	double result;
	do{
	if(sinal.equals("+")){

		 result = calc.somar(n1, n2); 
		 System.out.printf("%.2f + %.2f = %.2f \n ",n1,n2,result );   
		}
	else if(sinal.equals("-")){
		result = calc.subtracao(n1, n2); 
		System.out.printf("%.2f - %.2f = %.2f \n",n1,n2,result );
			  
		}   
	else{
		if(sinal.equals("/")){
				result = calc.divisao(n1, n2); 
				System.out.printf("%.2f / %.2f = %.2f \n",n1,n2,result);
			}
		else if(sinal.equals("*")){
		    	result = calc.multiplicacao(n1, n2); 
				System.out.printf("%.2f * %.2f = %.2f \n",n1,n2,result );
			}
			else{
			System.out.println();
			System.out.println("Simbolo invalido");
			break;
				}
	}
		System.out.print("Digite um sinal de operacao(+ - / *) ou Digite S para Sair do programa: ");
		sinal = tec.next();
		if(sinal.equals("S")){
			break;
		}
		else{
		System.out.print("Digite outro numero: ");
		n2 = tec.nextDouble();
		n1 = result;
		}
	}while(!sinal.equals("S"));
	System.out.println("Programa ENCERRADO!");
	tec.close();
  } 
}
