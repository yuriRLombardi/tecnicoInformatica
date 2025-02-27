package figuras_bi;

public class Quadrado extends Forma{
	public Quadrado(double base, String cor, String nomeFigura, int qtdVertice) {
		super(base, cor, nomeFigura, qtdVertice);
	}
	@Override
	public double calcularArea(){
		return Math.pow(super.getBase(),2);
	}
	@Override
	public double calcularPerimetro(){
		return super.getBase() * 4;
	}
	@Override
	public void mostrarInformacoes() {
		super.mostrarInformacoes();
		System.out.printf("\nArea: %.2f \n Perimetro: %.2f",calcularArea(),calcularPerimetro());
	}
}
