package automovel;

public class Carro extends Veiculo{
	private int numPortas;

	public Carro(String marca, String modelo, int ano, String cor, String placa, double consumo, int numPortas) {
		super(marca, modelo, ano, cor, placa, consumo);
		this.numPortas = numPortas;
	}

	public int getNumPortas() {
		return numPortas;
	}

	public void setNumPortas(int numPortas) {
		this.numPortas = numPortas;
	}
	@Override
	public void exibirInformacoes() {
		super.exibirInformacoes();
		System.out.println("Nro de portas: " + numPortas);
	}
}
