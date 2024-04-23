import java.util.Scanner;

public class exercicio2 {
    public static void main(String[] args) {
        int m1[][] = new int[4][4],m2[][] = new int[4][4];
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite os valores da 1o matriz: ");
        for(int l = 0;l<4;l++){
            for(int c = 0;c<4;c++){
                System.out.printf("Digite um valor para a posicao[%d,%d]: ",l,c);
                m1[l][c] = ler.nextInt();
            }
        }
        System.out.println("Digite os valores da 2o matriz: ");
        for(int l = 0;l<4;l++){
            for(int c = 0;c<4;c++){
                System.out.printf("Digite um valor para a posicao[%d,%d]: ",l,c);
                m2[l][c] = ler.nextInt();
            }
        }
        System.out.println("Matriz com os maiores valores lidas das duas matrizes: ");
        for(int l = 0;l<4;l++){
            for(int c = 0;c<4;c++){
                if(m1[l][c]>m2[l][c]){
                    System.out.print(m1[l][c]+"  ");
                }
                else if (m2[l][c]>m1[l][c]) {
                    System.out.print(m2[l][c]+"  "); 
                }
                else{
                    System.out.print(m1[l][c]);
                }
            }
            System.out.println("");
        }
        ler.close();
    }
}
