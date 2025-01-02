/*
 * Feito por: Yuri e Kevin
 */
public class Triangle extends TwoDimensionalShape{
    private double seg1; 
    private double seg2; 
    private double seg3; 
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
    public double getSeg3() {
        return seg3;
    }
    public void setSeg3(double seg3) {
        this.seg3 = seg3;
    }
    @Override
    public void calcularArea(){
        double area = super.getAltura() * super.getLargura()/2;
    }
    @Override
    public void calcularPerimetro(){
        double perimetro = seg1+seg2+seg3;
    }
}
