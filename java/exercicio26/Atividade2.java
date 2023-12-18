/*
programa em java que exibe as palavra digitas em duas maneiras diferentes:
na horizontal e na vertical
Feito por: Yuri
*/
import java.util.Scanner;
public class Atividade2 {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        String palavras;
        String juntar = "";
        do{
            System.out.println("Digite qualquer palavra ou digite \"sair\" para encerrar: ");
            palavras = tec.next();
            palavras = palavras.toLowerCase();
            if(!palavras.equalsIgnoreCase("Sair")){
                juntar = juntar + palavras + "*"; 
            }
            else{
                break;
            }
        }while(!palavras.equalsIgnoreCase("Sair"));
        System.out.println("Palavras digitadas: ");
        for(int i= 0;i<= juntar.length()-2;++i){
            char letra = juntar.charAt(i);
            System.out.print(letra);
        }
        tec.close();
        System.out.println("");
        System.out.println("Letras Separadas:");
        for(int i= 0;i<= juntar.length()-2;++i){
            char letra = juntar.charAt(i);
            System.out.println(letra);
        }
    }
}
