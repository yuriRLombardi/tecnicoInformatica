package figuras_bi;

import java.util.Scanner;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Scanner ler = new Scanner(System.in);
			System.out.println("Bem vindo ao gerador de Formas!");
			String texto = 
			"""

			Qual forma deseja gerar?
			[1] Quadrado 
			[2] Triângulo	
			""";
			System.out.println(texto);
			int opcao = ler.nextInt();
			System.out.println();
			switch (opcao) {
				case 1:
					System.out.println("Digite o valor dos lados do quadrado:");
					double lado = ler.nextDouble();
					System.out.println();
					Quadrado q = new Quadrado(lado,"rosa","Quadrado",4);
					q.mostrarInformacoes();
					break;
				case 2:
					double[] seg = new double[3];
					System.out.println("Digite o primeiro valor");
					seg[0] = ler.nextDouble();
					System.out.println("Digite o seguno valor");
					seg[1] = ler.nextDouble();
					System.out.println("Digite o terceiro valor");
					seg[2] = ler.nextDouble();
					Triangulo t = new Triangulo(seg[0],"azul","Triangulo",3,seg[1],seg[2]);
					System.out.println();
					t.mostrarInformacoes();
					break;
				default:
					System.out.println("Programa encerrado");
					break;
			}
			ler.close();	
		} catch (Exception e) {
			System.out.println("Erro: "+ e);
		}
	}
}
