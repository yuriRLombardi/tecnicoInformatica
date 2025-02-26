package figuras_bi;

public class Quadrado {
	private double medidaLado;
	private double area;
	private double perimetro;
	public Quadrado(double medidaLado) {
		super();
		this.medidaLado = medidaLado;
	}
	public double calcularArea(){
		return this.area = Math.pow(this.medidaLado,4);
	}
	public double calcularPerimetro(){
		return this.perimetro = this.medidaLado * 4;
	}
	public double getMedidaLado() {
		return medidaLado;
	}
	public void setMedidaLado(double medidaLado) {
		this.medidaLado = medidaLado;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public double getPerímetro() {
		return perimetro;
	}
	public void setPerímetro(double perimetro) {
		this.perimetro = perimetro;
	}
}
