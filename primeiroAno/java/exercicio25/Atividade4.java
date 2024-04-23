import java.util.Scanner;
public class Atividade4 {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        System.out.println("Digite uma palavra para ser invertida:");
        String palavra = tec.nextLine();
        int tamanho = palavra.length() - 1;
        for(int i = tamanho; i >= 0; --i){
            char invertida = palavra.charAt(i);
            System.out.print(invertida);
        }  
        tec.close();
    }
}
