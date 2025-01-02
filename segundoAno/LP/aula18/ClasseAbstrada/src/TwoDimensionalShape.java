/*
 * Feito por: Yuri,Kevin e Yago
 */
public abstract class TwoDimensionalShape extends Shape{
    private double perimetro;

    public double getPerimetro() {
        return perimetro;
    }

    public void setPerimetro(double perimetro) {
        this.perimetro = perimetro;
    }
    public abstract double calcularPerimetro(); 
}
