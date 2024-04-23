import java.util.Scanner;
public class Atividade3 {
   public static void main(String[] args) {
        Scanner tec1 = new Scanner(System.in);
        Scanner tec2 = new Scanner(System.in);
        String frase;
        String palavra;
        System.out.println("Digite uma frase : ");
        frase = tec1.nextLine();
		frase = frase.toLowerCase();
        System.out.println("Digite uma palavra : ");
        palavra = tec2.nextLine();
		palavra = palavra.toLowerCase();
        int verificador = frase.indexOf(palavra);
        if(verificador != -1){
            System.out.print("A palavra está na frase");
        }
        else{
            System.out.print("A palavra digitada não está na frase"); 
        }
        tec1.close();
        tec2.close();
   } 
}
