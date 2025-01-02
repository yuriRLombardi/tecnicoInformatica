/*
 * Feito por: Yuri,Kevin e Yago
 */
public class Triangle extends TwoDimensionalShape{
    private double seg1; 
    private double seg2; 
    private double base;
    private double altura; 
    public Triangle(double seg1, double seg2,double base, double altura) {
        this.seg1 = seg1;
        this.seg2 = seg2;
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
    @Override
    public double calcularArea(){
        double area = base * altura /2;
        return area;
    }
    @Override
    public double calcularPerimetro(){
        double perimetro = seg1+seg2+base;
        return perimetro;
    }
}
