package model;

public class Retangulo {
	private double base;
	private double altura;
	public Retangulo(double base, double altura) {
		super();
		this.base = base;
		this.altura = altura;
	}
	public double getBase() {
		return base;
	}
	public void setBase(double base) {
		this.base = base;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public double area() {
		return base * altura;
	}
	public double perimetro() {
		return 2 * base + 2 * altura;
	}
}
