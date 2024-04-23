/*
programa em java que calcula o perimetro da base e o volume
de um cone atraves da classe Cone
Feito por: Yuri
*/
import java.util.Scanner;
public class Atividade1{
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        double r,h;
        System.out.print("Digite o raio da base do cone: ");
        r = tec.nextDouble();
        System.out.print("Digite a altura do cone: ");
        h = tec.nextDouble();
        double perimetroBase = Cone.perimetroBase(r);
        double volume = Cone.volume(r, h);
        System.out.printf("O volume do cone eh igual ah: %f \n",volume);
        System.out.printf("O Perimetro da base do cone eh igual ah: %f \n",perimetroBase);
        tec.close();
    }
}