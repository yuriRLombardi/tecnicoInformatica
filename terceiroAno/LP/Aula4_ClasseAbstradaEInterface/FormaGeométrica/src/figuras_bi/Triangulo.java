package figuras_bi;

public class Triangulo extends Forma{
	private double seg1,seg2;
	
	
	public Triangulo(double base, String cor, String nomeFigura, int qtdVertice, double seg1, double seg2) {
		super(base, cor, nomeFigura, qtdVertice);
		this.seg1 = seg1;
		this.seg2 = seg2;
	}
	@Override
	public void mostrarInformacoes() {
		super.mostrarInformacoes();
		System.out.printf("\nSegmento 1: %.2f \n Segmento 2: %.2f",seg1,seg2);
		System.out.printf("\n Area: %.2f \n Perimetro: %.2f \n",calcularArea(),calcularPerimetro());
		System.out.println("Tipo triangulo: "+verTipoTriangulo());
	}
	@Override
	public double calcularArea(){
		if(validarTriangulo()) {
			double meioP = calcularPerimetro()/2;
			return  Math.sqrt(meioP*(meioP-super.getBase()) * (meioP-seg1) * (meioP-seg2));
		}
		else {
			return 0;
		}
		
	}
	@Override
	public double calcularPerimetro(){
		if(validarTriangulo()) {
			return super.getBase() + seg1 + seg2;
		}
		else {
			return 0;
		}
	}
	public String verTipoTriangulo(){
		if(validarTriangulo()) {
			if(super.getBase() == seg1 && super.getBase() == seg2) {
				return "Equilatero";
			}
			else if(super.getBase() == seg1 || super.getBase() == seg2) {
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
		double soma1 = super.getBase()+seg1;
		double soma2 = super.getBase()+seg2;
		double soma3 = seg1+seg2;
		if(soma1 > seg2 && soma2 > seg1 && soma3 > super.getBase()) {
			return true;
		}
		else {
			return false;
		}
	}
	public double getSeg1() {
		return seg1;
	}
	public void setSeg1(double seg1) {
		this.seg1 = seg1;
	}
	public double getSeg2() {
		return seg2;
	}
	public void setSeg2(double seg2) {
		this.seg2 = seg2;
	}
	
}
