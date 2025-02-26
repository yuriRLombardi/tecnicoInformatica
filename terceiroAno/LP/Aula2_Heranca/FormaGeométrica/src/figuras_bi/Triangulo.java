package figuras_bi;

public class Triangulo {
	private double[] seg = new double[3];
	private double area;
	private double perimetro;
	
	public double calcularArea(){
		if(validarTriangulo()) {
			double meioP = perimetro/2;
			return this.area = Math.sqrt(meioP*(meioP-this.seg[0]) * (meioP-this.seg[1]) * (meioP-this.seg[2]));
		}
		else {
			return 0;
		}
		
	}
	public double calcularPerimetro(){
		if(validarTriangulo()) {
			return this.perimetro = this.seg[0] + this.seg[1] + this.seg[2];
		}
		else {
			return 0;
		}
	}
	public String verTipoTriangulo(){
		if(validarTriangulo()) {
			if(this.seg[0] == this.seg[1] && this.seg[0] == this.seg[2]) {
				return "Equilatero";
			}
			else if(this.seg[0] == this.seg[1] || this.seg[0] == this.seg[2]) {
				return "Isoceles";
			}
			else {
				return "Escaleno";
			}
		}
		else {
			return "Nenhum Triangulo Formado";
		}
	}
	private boolean validarTriangulo() {
		double soma1 = this.seg[0]+this.seg[1];
		double soma2 = this.seg[0]+this.seg[2];
		double soma3 = this.seg[1]+this.seg[2];
		if(soma1 > this.seg[2] && soma2 > this.seg[1] && soma3 > this.seg[0]) {
			return true;
		}
		else {
			return false;
		}
	}

	public Triangulo(double[] seg) {
		super();
		this.seg = seg;
	}

	public double[] getSeg() {
		return seg;
	}

	public void setSeg(double[] seg) {
		this.seg = seg;
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
