import java.util.Scanner;
public class Atividade6 {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        String texto,letra;
        int contador = 0;
        System.out.print("Digite uma palavra,frase ou texto: ");
        texto = tec.nextLine();
		texto = texto.toUpperCase();
        System.out.print("Digite uma letra para ver o numero de ocorrencias dessa letra: ");
        letra = tec.nextLine();
		letra = letra.toUpperCase();
        int tamanhoTexto = texto.length()-1;
        int posicao = texto.indexOf(letra);
		char letra2;
		if(posicao != -1){
			letra2 = texto.charAt(posicao);
		}
		else{
			letra2 = '1';
		}
        if (texto.indexOf(letra) != -1) {
             
			for(int i = 0;i <= tamanhoTexto;++i){
				char letra1 = texto.charAt(i);	
                if(letra1 == letra2){
                    ++contador;
                }
				else{
					
				}
			}
            System.out.printf("Ah %d de ocorrencias da letra \"%s\"",contador,letra);  
        }
        else{
            System.out.printf("Nao ha nenhuma ocorrencia da letra \"%s\" no texto digitado",letra);  
        }
        tec.close();
    }
}
