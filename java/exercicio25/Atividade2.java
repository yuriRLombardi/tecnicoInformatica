import java.util.Scanner;
public class Atividade2 {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        String texto;
        System.out.println("Digite um texto qualquer :");
        texto = tec.nextLine();
        System.out.printf("O tamanho do seu texto é : %s \n",texto.length());
        System.out.printf("Seu texto em maiusculo : %s \n",texto.toUpperCase());
        System.out.printf("Seu texto em minusculo : %s \n",texto.toLowerCase());
        tec.close();
    }
}
