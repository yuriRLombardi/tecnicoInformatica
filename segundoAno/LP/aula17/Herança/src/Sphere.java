/*
 * Feito por: Yuri e Kevin
 */
public class Sphere extends ThreeDimensionalShape{
    private double raio;
    @Override
    public void calcularVolume(){
        double volume = (4/3)*Math.PI*Math.pow(raio, 3);
    }
    @Override
    public void calcularArea(){
        double area = 4 * Math.PI * Math.pow(raio, 2);
 }
}
