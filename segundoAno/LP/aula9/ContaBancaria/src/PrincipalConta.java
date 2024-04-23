import java.util.Scanner;
public class PrincipalConta {

    public static void main(String[] args) {
        int opcao = 0;
        float saque,deposito;
        Scanner tec = new Scanner(System.in);
        contaBancariav0 conta = new contaBancariav0();
        System.out.println("**************************");
        System.out.println("Conta Bancaria");
        System.out.println("**************************");
        System.out.println("Digite o nome do Titular:");
        conta.titular = tec.nextLine();
        System.out.println("Digite seu saldo: ");
        conta.saldo = tec.nextFloat();
        System.out.println("Digite o numero da Conta:");
        conta.numero = tec.nextInt();
        do{
            System.out.println("**************************");
            System.out.println("1- Saque");
            System.out.println("2- Deposito");
            System.out.println("3- Imprimir Informacoes");
            System.out.println("4- Sair");
            System.out.println("**************************");
            opcao = tec.nextInt();
            switch (opcao) {
                case 1:
                System.out.println("Digite o saque que sera feito:");
                saque = tec.nextFloat();
                  if (conta.podeSacar(saque)) {
                    conta.sacar(saque);
                    System.out.println("Saque efetuado");
                  }
                  else{
                    System.out.println("Saque nao pode ser efetuado");
                  }
                    break;

                case 2:
                System.out.println("Digite o o deposito que sera feito:");
                deposito = tec.nextFloat();
                conta.depositar(deposito);
                System.out.println("Depoito efetuado");
                break;

                case 3:
                  conta.impressao();
                  break;
                case 4:
                break;
                default:
                    System.out.println("Opcao invalida");
                    break;
            }
            System.out.println("**************************");
        }while(opcao != 4);
        System.out.println("Fim da execucao");
        tec.close();
    }
}
