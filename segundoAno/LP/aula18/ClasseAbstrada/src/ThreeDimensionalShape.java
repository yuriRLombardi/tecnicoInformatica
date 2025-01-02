/*
 * Feito por: Yuri,Kevin e Yago
 */
public abstract class  ThreeDimensionalShape extends Shape{
    private double volume;
    public double getVolume() {
        return volume;
    }
    public void setVolume(double volume) {
        this.volume = volume;
    }
    public abstract double calcularVolume();

}
