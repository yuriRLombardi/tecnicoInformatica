import java.util.Scanner;

public class Atividade1{
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        String palavras;
        String juntar = "";
        do{
            System.out.println("Digite qualquer palavra ou digite \"sair\" para encerrar: ");
            palavras = tec.next();
            if(!palavras.equalsIgnoreCase("Sair")){
                juntar = juntar + palavras + "  "; 
            }
            else{
                break;
            }
        }while(!palavras.equalsIgnoreCase("Sair"));
        System.out.println("As palavras que foram digitadas foram");
        System.out.println(juntar);
        tec.close();
    }
}