package automovel;

public class Aplicacao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Carro");
		Carro c = new Carro("Ford","Ka",2015,"rosa","FRS2G123",10,4);
		c.exibirInformacoes();
		System.out.println(c.calcularAutonomia(10));
		System.out.println();
		System.out.println("Moto");
		Moto m = new Moto("Honda","CG",2008,"azul","EHN3A456",18,150);
		m.exibirInformacoes();
		System.out.println(m.calcularAutonomia(10));
	}

}
