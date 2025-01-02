/*
 * Feito por: Yuri,Kevin e Yago
 */
public class Teahedron extends ThreeDimensionalShape{
    private double lado;
    public Teahedron(double lado) {
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
        double volume = Math.pow(lado, 3) * Math.sqrt(2)/12;
        return volume;
    }
    @Override
    public double calcularArea(){
        double area = Math.sqrt(3) * Math.pow(lado, 2);
        return area;
    }

}
