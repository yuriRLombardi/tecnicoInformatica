import java.util.Scanner;

public class exercicio1 {

    public static void main(String[] args) {
        int matriz4x4[][] = new int[4][4];
        int vMaior10 = 0;
        Scanner ler = new Scanner(System.in);
        System.out.println("Matriz 4x4: ");
        for(int l = 0; l<4;l++){
            for(int c = 0; c<4;c++){
                System.out.print("Digite um valor para a posicao["+l+","+c+"]: ");
                matriz4x4[l][c] = ler.nextInt();
                if (matriz4x4[l][c] > 10) {
                    vMaior10++;
                }
            }
        }
        System.out.println("O total de valores maiores do que 10 eh "+vMaior10);
        for(int l = 0; l<4;l++){
            for(int c = 0; c<4;c++){
                if (matriz4x4[l][c] > 10) {
                    System.out.println(matriz4x4[l][c]+" na posicao["+l+","+c+"]: ");  
                }
            }
        }
        ler.close();
    }
}