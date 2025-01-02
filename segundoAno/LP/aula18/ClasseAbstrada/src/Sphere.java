/*
 * Feito por: Yuri,Kevin e Yago
 */
public class Sphere extends ThreeDimensionalShape{
    private double raio;
    private double diametro;
    public Sphere(double raio) {
        this.raio = raio;
        this.diametro = raio * 2;
    }
    public double getRaio() {
        return raio;
    }
    public void setRaio(double raio) {
        this.raio = raio;
    }
    @Override
    public double calcularVolume(){
        double volume = (4/3)*Math.PI*Math.pow(raio, 3);
        return volume;
    }
    @Override
    public double calcularArea(){
        double area = 4 * Math.PI * Math.pow(raio, 2);
        return area;
    }
}
