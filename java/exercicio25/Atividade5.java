import java.util.Scanner;
public class Atividade5 {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        System.out.println("Digite um texto para remover os espaços em branco: ");
        String texto = tec.nextLine();
		System.out.println("");
        int tamanho = texto.length()-1;
        int aspas = texto.indexOf(" ");
		if(aspas != -1){
			for(int i = 0;i <= tamanho;++i){
				char prencher = texto.charAt(i);
				if(prencher == ' '){
					
				}
				else{
					System.out.print(prencher);
				}
			}
		}
		System.out.println("");
        System.out.printf("Seu texto sem espaços em branco se encontra acima dessa mensagem");
        tec.close();
    }
}
