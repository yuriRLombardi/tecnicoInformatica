import java.util.Scanner;
/*Feito por: Yuri Rodrigues Lombardi ht3023664 e Kevin dos Santos Reis ht3023397 */
public class Conta {
    public static void main(String[] args) {
        double saldo = 0;
        int opcaousuario = 0;
        double ganho, perda;
        while (opcaousuario != 4) {
            System.out.println("*******");
            System.out.println("Nome: Kevin dos Santos Reis2");
            System.out.println("Tipo da conta: Corrente");
            System.out.println("Saldo= " + saldo);

            System.out.println("*******");
            System.out.println("**Digite a opção**");
            System.out.println("1- Consultar saldo");
            System.out.println("2- Transferir valor da conta");
            System.out.println("3- Receber valor");
            System.out.println("4- Sair");

            Scanner scan = new Scanner(System.in);
            opcaousuario = scan.nextInt();

             if (opcaousuario == 3) {
                System.out.println("Que valor voce recebera?");
                ganho = scan.nextDouble();
                saldo = saldo + ganho;

            }

            if (opcaousuario == 2) {
                if (saldo == 0) {
                    System.out.println("Você não tem saldo");
                }
                else{
                System.out.println("Que valor voce transferir?");
                perda = scan.nextDouble();
                saldo = saldo - perda;
                }
            }


            
        } 
    }
}
    

