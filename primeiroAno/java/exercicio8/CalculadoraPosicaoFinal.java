
    import java.util.Scanner;

public class CalculadoraPosicaoFinal {
    public void calcularPosicaoFinal(){
        System.out.println("Digite velocidade em metros: ");
        Scanner teclado = new Scanner(System.in);
        float velocidade = teclado.nextFloat();
        System.out.println("Digite tempo em segundos: ");        
        float tempo = teclado.nextFloat();
        System.out.println("Digite a Distáncia inicial em metros: ");        
        float disInicial = teclado.nextFloat();
        System.out.println("Formula para descobrir a posição final: S = So + V x T");
        System.out.println("dados os seus parâmetros: So = " +disInicial+ " V ="+velocidade+" T = " +tempo);
        float S = disInicial+(velocidade*tempo);
        System.out.printf("A posição final é: %.2f metros",S);
        teclado.close();
    }
}
