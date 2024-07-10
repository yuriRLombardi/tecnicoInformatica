package ex2;
/*
 Feito por: Yuri e Kevin
 Data: 02/07/24
 Modificação: 03/07/24
 */
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int [] potencia = new int[2];
        String [] modelo = new String[2];
        String [] marca = new String[2];
        String [] tipo = new String[2];
        System.out.println("DIGITE AS SEGUINTES INFORMACOES DO PRIMEIRO CARRO");
        System.out.print("Modelo: ");
        modelo[0] = ler.nextLine();
        System.out.print("Marca: ");
        marca[0] = ler.nextLine();
        System.out.println("MOTOR");
        System.out.print("Potencia: ");
        potencia[0] = ler.nextInt();
        System.out.print("Tipo: ");
        ler.nextLine();
        tipo[0] = ler.nextLine();
        System.out.println();
        System.out.println("DIGITE AS SEGUINTES INFORMACOES DO SEGUNDO CARRO");
        System.out.print("Modelo: ");
        modelo[1] = ler.nextLine();
        System.out.print("Marca: ");
        marca[1] = ler.nextLine();
        System.out.println("MOTOR");
        System.out.print("Potencia: ");
        potencia[1] = ler.nextInt();
        System.out.print("Tipo: ");
        ler.nextLine();
        tipo[1] = ler.nextLine();
        System.out.println();
        Motor m1 = new Motor(potencia[0], tipo[0]);
        Motor m2 = new Motor(potencia[1],tipo[1]);
        Carro c1 = new Carro(modelo[0], marca[0], m1);
        Carro c2 = new Carro(modelo[1], marca[1], m2);
        c1.exibirDados();
        System.out.println();
        c2.exibirDados();
        ler.close();
    }
}
