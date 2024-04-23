import java.util.Scanner;

public class DesafioLoja {

    public static void main(String[] args) {
        float compras[] = new float[10];
        int totV=0,totP=0,tot=0;
        float valorV=0,valorP=0,valor=0;
        float media;
        String codigo[] = new String[10];
        Scanner ler = new Scanner(System.in);
        for(int i = 0;i < 10;i++){
            System.out.printf("Digite o %do valor da compra: ",(i+1));
            compras[i] = ler.nextFloat();
            if (compras[i]<0) {
                do{
                System.out.println("Digite um valor que nao seja negativo: ");
                compras[i] = ler.nextFloat();
                }while(compras[i]<0);
            }
            System.out.println("Digite o codigo da compra(V/P): ");
            codigo[i] = ler.next();
           
            if (codigo[i].equalsIgnoreCase("V")) {
                totV++;
                valorV += compras[i];
            }
            else if (codigo[i].equalsIgnoreCase("P")) {
                totP++;
                valorP += compras[i];
            }
            else{
                System.out.println("Por favor,digite o codigo correto sendo \"V\" compras a vista e \"P\" compras a prazo:");
                codigo[i] = ler.next();
                if (codigo[i].equalsIgnoreCase("V")) {
                    totV++;
                    valorV += compras[i];
                }
                else if (codigo[i].equalsIgnoreCase("P")) {
                    totP++;
                    valorP += compras[i];
                }
            }
            tot++;
            valor += compras[i];
        }
        ler.close();
        media = valor/10;
        String texto = """
                Valor total da compra a vista:%.2f
                Quantidade de trancicoes a vista:%d
                Valor total da compra a prazo:%.2f
                Quantidade de trancicoes a prazo:%d
                Valor total da compra:%.2f
                Quantidade de trancicoes:%d
                Ticket medio: %.2f
                """;
        System.out.printf(texto,valorV,totV,valorP,totP,valor,tot,media);
    }
}