package atividades;

public class Bhaskara {
	private double a;
	private double b;
	private double c;
	
	public Bhaskara(double a, double b, double c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}
	private boolean eq2grau() {
		if(a == 0) {
			return false;
		}
		else {
			return true;
		}
	}
	private double calcularDelta() {
		return Math.pow(b, 2) - (4*a*c);
	}
	private boolean raizesReais() {
		double delta = calcularDelta();
		if(delta < 0) {
			return false;
		}
		else {
			return true;
		}
	}
	public String calcularRaizes() {
		if(!eq2grau()) {
			return "A equação não é de segundo grau";
		}
		else if(!raizesReais()) {
			return "A equação não possui raízes reais";
		}
		else {
			double delta = calcularDelta();
			double r1 = ((0-b) + Math.sqrt(delta))/(2*a);
			double r2 = ((0-b) - Math.sqrt(delta))/(2*a);
			if(delta > 0) {
				return String.format("%.2f", r1) +" e "+ String.format("%.2f", r2);
			}
			else {
				return String.format("%.2f", r1);
			}
		}
	}
	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}
}
