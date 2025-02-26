package automovel;

public class Moto extends Veiculo{
	private int cilindrada;

	public Moto(String marca, String modelo, int ano, String cor, String placa, double consumo, int cilindrada) {
		super(marca, modelo, ano, cor, placa, consumo);
		this.cilindrada = cilindrada;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}
	@Override
	public void exibirInformacoes() {
		super.exibirInformacoes();
		System.out.println("Cilindrada: " + cilindrada);
	}
}
