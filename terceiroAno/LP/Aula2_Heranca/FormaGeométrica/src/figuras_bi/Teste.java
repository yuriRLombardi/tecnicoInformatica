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
					Quadrado q = new Quadrado(lado);
					System.out.println("Informacoes do Quadrado");
					System.out.printf("Perimetro: %.2f \n",q.calcularPerimetro());
					System.out.printf("Area: %.2f \n",q.calcularArea());
					break;
				case 2:
					double[] seg = new double[3];
					System.out.println("Digite o primeiro valor");
					seg[0] = ler.nextDouble();
					System.out.println("Digite o seguno valor");
					seg[1] = ler.nextDouble();
					System.out.println("Digite o terceiro valor");
					seg[2] = ler.nextDouble();
					Triangulo t = new Triangulo(seg);
					System.out.println();
					System.out.println("Informacoes do Triangulo");
					System.out.printf("Perimetro: %.2f \n",t.calcularPerimetro());
					System.out.printf("Area: %.2f \n",t.calcularArea());
					System.out.printf("Tipo do tringulo: %s \n",t.verTipoTriangulo());
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
