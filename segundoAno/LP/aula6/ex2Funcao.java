import java.util.Scanner;

public class ex2Funcao {
    public static int positivoOuNegativo(int num){
        int retorno;
        if (num < 0) {
            retorno = -1;
        }
        else if (num > 0) {
            retorno = 1;
        }
        else{
            retorno = 0;
        }
        return retorno;
    }
    public static void main(String[] args) {
        int num;
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite um numero: ");
        num = ler.nextInt();
        String legenda = 
        """
            Legenda:
            1-Numero eh positivo
            0-Numero igual a zero
            -1-Numero eh negativo
        """;
        System.out.println(legenda);
        System.out.println("O tipo do numero eh "+positivoOuNegativo(num));
        ler.close();
    }
}
