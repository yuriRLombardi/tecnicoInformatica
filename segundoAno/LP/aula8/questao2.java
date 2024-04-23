import java.util.Scanner;

public class questao2 {

    public static void main(String[] args) {
        float matriz3x3[][] = new float[3][3];
        float soma = 0;
        Scanner ler = new Scanner(System.in);
        System.out.println("Matriz 3x3");
        for(int l = 0;l<3;l++){
            for(int c = 0;c<3;c++){
                System.out.printf("Digite um valor na posicao [%d,%d] \n",l,c);
                matriz3x3[l][c] = ler.nextFloat();
            }
        }
        System.out.println();
        for(int l = 0;l<3;l++){
            for(int c = 0;c<3;c++){
                System.out.print(matriz3x3[l][c]+"  ");
                soma += matriz3x3[l][c];
            }
            System.out.println();
        }
        
        System.out.println("A soma dos valores digitados eh "+soma);
        ler.close();
        //Feito por Yuri e Kevin
        //Data: 19/03/24
    }
}
