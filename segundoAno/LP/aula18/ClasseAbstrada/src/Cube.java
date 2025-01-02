/*
 * Feito por: Yuri,Kevin e Yago
 */
public class Cube extends ThreeDimensionalShape{
    private double lado; 
    public Cube(double lado) {
        this.lado = lado;
    }
    public double getLado() {
        return lado;
    }
    public void setLado(double lado) {
        this.lado = lado;
    }
    @Override
    public double calcularVolume(){
        double volume = Math.pow(lado, 3);
        return volume;
    }
    @Override
    public double calcularArea(){
        double area = 6 * Math.pow(lado, 2);
        return area; 
    }
}
