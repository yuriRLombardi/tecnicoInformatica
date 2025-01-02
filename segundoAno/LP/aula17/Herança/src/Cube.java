/*
 * Feito por: Yuri e Kevin
 */
public class Cube extends ThreeDimensionalShape{
    @Override
    public void calcularVolume(){
        double volume = Math.pow(super.getLado(), 3);
    }
    @Override
    public void calcularArea(){
        double area = 6 * Math.pow(super.getLado(), 2);
    }
}
