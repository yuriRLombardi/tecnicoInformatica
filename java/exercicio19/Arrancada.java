/* programa em java que calcula a aceleração e
a velocidade final numa corrida de arrancada
Feito por: Yuri
*/
import java.util.Scanner;
public class Arrancada {
	public static void main(String[]args){
		Scanner tec = new Scanner(System.in);
		double tempo;
		double velocidadeI = 0;
		double distancia = 402;
		System.out.println("---------------------");
		System.out.println("Corrida de Arrancada");
		System.out.println("---------------------");
		System.out.println("Digite o tempo em segundos que o veiculo percorreu");
		tempo = tec.nextFloat();
		System.out.println("---------------------");
		System.out.println("Calculando...");
		System.out.println("---------------------");
		double calculoA = 0 * tempo + (Math.pow(tempo,2))/2;
		double resA = 402/calculoA;
		System.out.println("A aceleracao do veiculo eh "+resA+" em metros por segundos quadrados");
		double calculoVF = 0 + resA * tempo;
		double resVF = calculoVF*3.6;
		System.out.println("A velocidade do veiculo eh "+resVF+" em kilometros por hora");
		tec.close();
	}
}