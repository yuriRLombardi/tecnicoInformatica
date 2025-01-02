/*
 * Feito por: Yuri,Kevin e Yago
 */
public class Circle extends TwoDimensionalShape{
    private double raio;
    private double diametro;
    public Circle(double raio) {
        this.raio = raio;
        this.diametro = 2*raio;
    }
    @Override
    public double calcularArea(){
        double area = 2 * Math.PI *Math.pow(raio, 2);
        return area;
    }
    @Override
    public double calcularPerimetro(){
        double perimetro = 2 * Math.PI * raio;
        return perimetro;
    }
}
