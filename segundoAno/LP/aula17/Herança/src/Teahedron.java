/*
 * Feito por: Yuri e Kevin
 */
public class Teahedron extends ThreeDimensionalShape{
    @Override
    public void calcularVolume(){
        double volume = Math.pow(super.getLado(), 3) * Math.sqrt(2)/12;
    }
    @Override
    public void calcularArea(){
        double area = Math.sqrt(3) * Math.pow(super.getLado(), 2);
    }

}
