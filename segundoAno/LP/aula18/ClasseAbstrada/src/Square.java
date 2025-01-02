/*
 * Feito por: Yuri,Kevin e Yago
 */
public class Square extends TwoDimensionalShape{
    private double altura;
    private double base;
    public Square(double altura, double base) {
        this.altura = altura;
        this.base = base;
    }
    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
    public double getBase() {
        return base;
    }
    public void setBase(double base) {
        this.base = base;
    }
    @Override
    public double calcularArea(){
        double area = base * altura;
        return area;
    }
    @Override
    public double calcularPerimetro(){
        double perimetro = base * 2 + altura * 2;
        return perimetro;
    }
}
