import java.util.Scanner;

public class desafioMatriz {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.println("Criando sua matriz");
        System.out.println("Digite a linha da matriz:");
        int linha = ler.nextInt();
        if (linha<0) {
            do{
                System.out.println("Digite outro valor que nao seja negativo");
                linha = ler.nextInt();
            }while(linha<0);
        }
        System.out.println("Digite a linha da matriz:");
        int coluna = ler.nextInt();
        if (coluna<0) {
            do{
                System.out.println("Digite outro valor que nao seja negativo");
                coluna = ler.nextInt();
            }while(coluna<0);
        }
        int matriz[][] = new int[linha][coluna];
        int par=0,impar=0,n=0,p=0;
        int linme =0,colme=0,linma=0,colma=0;
        
        System.out.println("Digite os valores da matriz");
        for(int l = 0;l<linha;l++){
            for(int c = 0;c<coluna;c++){
            System.out.printf("Digite um valor para a posicao[%d,%d]: ",l,c);
            matriz[l][c] = ler.nextInt();
            if (matriz[l][c]%2 == 0) {
                par++;
            }
            else{
                impar++;
            }
            if (matriz[l][c]<0) {
                n++;
            }
            else{
                p++;
            }
            } 
        }
        int maior = matriz[0][0];
        int menor = matriz[0][0];
        System.out.println("Sua matriz:");
        for(int l = 0;l<linha;l++){
            for(int c = 0;c<coluna;c++){
                System.out.print(matriz[l][c]+"  ");
                if (matriz[l][c]>maior) {
                    maior = matriz[l][c];
                    linma = l;
                    colma = c;
                }
                else if(matriz[l][c]<menor){
                    menor = matriz[l][c];
                    linme = l;
                    colme = c;
                }
            }
            System.out.println("");
        }
        System.out.printf("A quantidade de numeros pares eh %d no total\n",par);
        System.out.printf("A quantidade de numeros impares eh %d no total\n",impar);
        System.out.printf("O maior valor eh %d na posicao[%d,%d]\n",maior,linma,colma);
        System.out.printf("O menor valor eh %d na posicao[%d,%d]\n",menor,linme,colme);
        System.out.printf("A quantidade de numeros negativos eh %d no total\n",n);
        System.out.printf("A quantidade de numeros positivos eh %d no total\n",p);
        ler.close();
    }
}