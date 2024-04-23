import java.util.Scanner;
public class Atividade7 {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        String palavra;
        boolean Ehpalindromo = false;
        System.out.print("Digite uma palavra para ver se ela eh ou nao eh palindromo: ");
        palavra = tec.nextLine();
        palavra = palavra.toUpperCase();
        int tamanho = palavra.length() - 1;
        for(int i = 0; i <= tamanho; ++i){
            if(palavra.charAt(i) == palavra.charAt((tamanho)-i)){
                 Ehpalindromo = true;
            }
            else{
                Ehpalindromo = false;
            }
        }  
        if(Ehpalindromo == true){
            System.out.print("eh palindromo");
        }
        else{
            System.out.print("Nao eh palindromo");
        }
        tec.close();   
    }
}
