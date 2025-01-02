/*
 * Feito por: Yuri e Kevin
 */
public class Square extends TwoDimensionalShape{
    @Override
    public void calcularArea(){
        double area = super.getLargura() * super.getAltura();
    }
    @Override
    public void calcularPerimetro(){
        double volume = super.getLargura() * 2 + super.getAltura();
    }
}
