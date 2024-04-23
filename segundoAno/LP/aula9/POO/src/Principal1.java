import java.util.Scanner;

public class Principal1 {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        Lampada lampada1 = new Lampada();

        String opcao;
        System.out.println("Digite \"L\" para acender ou \"D\" para desligar a lampada");
        opcao = tec.next();
        if(opcao.equalsIgnoreCase("L")){
            lampada1.ligado();
        }
        else if (opcao.equalsIgnoreCase("D")) {
            lampada1.desligado();
        }
        else{
                System.out.println("Por mais que voce digitou a letra errada,você vera o resultado padrao:");      
        }   
            String texto = """
            LEGENDA:    
            True -> Lampada ligada
            False -> Lampada desligada
            """;
            System.out.println(texto);
            System.out.println(lampada1.estaLigado());
        
         
        tec.close();
    }
}
