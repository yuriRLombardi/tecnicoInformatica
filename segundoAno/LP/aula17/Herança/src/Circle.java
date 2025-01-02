/*
 * Feito por: Yuri e Kevin
 */
public class Circle extends TwoDimensionalShape{
    private double raio;
    @Override
    public void calcularArea(){
        double area = 2 * Math.PI *Math.pow(raio, 2);
    }
    @Override
    public void calcularPerimetro(){
        double perimetro = 2 * Math.PI * raio;
    }
}
