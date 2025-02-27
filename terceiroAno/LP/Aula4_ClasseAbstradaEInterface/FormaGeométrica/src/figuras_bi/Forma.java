package figuras_bi;

public abstract class Forma {
	public  double base;
	private String cor;
	private String nomeFigura;
	private int qtdVertice;
	public Forma(double base, String cor, String nomeFigura, int qtdVertice) {
		super();
		this.base = base;
		this.cor = cor;
		this.nomeFigura = nomeFigura;
		this.qtdVertice = qtdVertice;
	}
	public void mostrarInformacoes() {
		System.out.printf("INFORMACOES DA FORMA \n Nome: %s \n Cor: %s \n Quantidade de Vertices: %s \n Base: %.2f",nomeFigura,cor,qtdVertice,base);
	}
	public abstract double calcularArea();
	public abstract double calcularPerimetro();
	public double getBase() {
		return base;
	}
	public void setBase(double base) {
		this.base = base;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getNomeFigura() {
		return nomeFigura;
	}
	public void setNomeFigura(String nomeFigura) {
		this.nomeFigura = nomeFigura;
	}
	public int getQtdVertice() {
		return qtdVertice;
	}
	public void setQtdVertice(int qtdVertice) {
		this.qtdVertice = qtdVertice;
	}

}
