/*
Programa em java que armazena marca,modelo
e cor de um carro digitado por um usuário,
através da classe Carro
Feito por:Yuri
*/
import java.util.Scanner;

public class CatalogoCarro{
	public static void main(String[]args){
		Scanner tec = new Scanner(System.in);
		Carro c = new Carro();
		System.out.print("MARCA do carro: ");
		c.marca = tec.next();
		System.out.print("MODELO do carro: ");
		c.modelo = tec.next();
		System.out.print("COR do carro: ");
		c.cor = tec.next();
		System.out.print("Informacoes do Carro: ");
		System.out.print(c.marca+", "+c.modelo+", "+c.cor);
		
	}
}	