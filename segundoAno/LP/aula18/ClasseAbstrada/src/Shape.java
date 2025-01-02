/*
 * Feito por: Yuri,Kevin e Yago
 */
public abstract class Shape{
    private double area;
    public double getArea() {
        return area;
    }
    public void setArea(double area) {
        this.area = area;
    }
    public abstract double calcularArea();
}
