import java.util.Scanner;

public class exercicio3 {
    public static void main(String[] args) {
        int matriz3x3[][] = new int[3][3];
        int maior = 0,lin=0,col=0;
        Scanner ler = new Scanner(System.in);
        System.out.println("Matriz 3x3:");
        for(int l = 0;l<3;l++){
            for(int c = 0;c<3;c++){
            System.out.printf("Digite um valor para a posicao[%d,%d]: ",l,c);
            matriz3x3[l][c] = ler.nextInt();
            } 
        }
        maior = matriz3x3[0][0];
        for(int l = 0;l<3;l++){
            for(int c = 0;c<3;c++){
                System.out.print(matriz3x3[l][c]+"  ");
                if (matriz3x3[l][c]>maior) {
                    maior = matriz3x3[l][c];
                    lin = l;
                    col = c;
                }
            }
            System.out.println("");
        }
        System.out.printf("O maior valor eh %d na posicao[%d,%d]",maior,lin,col);
        ler.close();
    }
}
