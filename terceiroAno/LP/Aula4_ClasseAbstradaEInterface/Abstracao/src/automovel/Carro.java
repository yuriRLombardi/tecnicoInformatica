package automovel;

public class Carro extends Veiculo implements Impressao{
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
	public double calcularIPVA(double valor) {
		return 0.04 * valor;
	}

	@Override
	public void exibirInformacoes() {
		System.out.println("Marca: "+getMarca()+"\nModelo: "+getModelo()+"\nAno: "+getAno() + "\nNro de portas: "+numPortas);
	}
}
