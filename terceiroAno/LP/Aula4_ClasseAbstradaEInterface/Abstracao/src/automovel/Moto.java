package automovel;

public class Moto extends Veiculo implements Impressao{
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
		System.out.println("Marca: "+getMarca()+"\nModelo: "+getModelo()+"\nAno: "+getAno() + "\nCilindrada: " + cilindrada);
	}

	@Override
	public double calcularIPVA(double valor) {
		return 0.02*valor;
	}
}
