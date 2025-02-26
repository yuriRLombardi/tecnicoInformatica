package introducao;

public class Aplicacao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Carro carro = new Carro("Volkswagen","Fusca",1988,"azul","FTR2A234",11);
		carro.exibirInformacoes();
		
		double autonomia = carro.calcularAutonomia(15);
		System.out.println("\nAutonomia: " +autonomia+ "km");
	}

}
