/*
 * Feito por: Yuri,Kevin e Yago
 */
public class Principal {
    public static void main(String[] args) {
        TwoDimensionalShape circle = new Circle(7);
        TwoDimensionalShape square = new Square(9, 8);
        TwoDimensionalShape triangle = new Triangle(5, 6, 7, 10);
        ThreeDimensionalShape sphere = new Sphere(9);
        ThreeDimensionalShape cube = new Cube(5);
        ThreeDimensionalShape teahedron = new Teahedron(10); 
        System.out.printf("%n CIRCULO %n Area do Circulo: %.2f %n Perimetro do Circulo: %.2f",circle.calcularArea(),circle.calcularPerimetro());
        System.out.printf("%n QUADRADO %n Area do Quadrado: %.2f %n Perimetro do Quadrafo: %.2f",square.calcularArea(),square.calcularPerimetro());
        System.out.printf("%n TRIANGULO%n Area do Triangulo: %.2f %n Perimetro do Triangulo: %.2f",triangle.calcularArea(),triangle.calcularPerimetro());
        System.out.printf("%n ESFERA%n Area do Esfera: %.2f %n Volume do Esfera: %.2f",sphere.calcularArea(),sphere.calcularVolume());
        System.out.printf("%n CUBO %n Area do Cubo: %.2f %n Volume do Cubo: %.2f",cube.calcularArea(),cube.calcularVolume());
        System.out.printf("%n PIRAMIDE %n Area ds Piramide: %.2f %n Volume da Piramide: %.2f",teahedron.calcularArea(),teahedron.calcularVolume());
    }
}
