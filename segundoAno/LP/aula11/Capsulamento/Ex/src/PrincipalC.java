import java.util.Scanner;
//classe principal criada por Yuri e Yago
//Data:10/04
public class PrincipalC {
    public static void main(String[] args) {
        int aumento,opcao=0;
        Scanner tec = new Scanner(System.in);
        Carro c1 = new Carro("Fiat", "Idea", 2024, 0, 0);
        System.out.println("*****************");
        System.out.println("CARRO");
        System.out.println("*****************");
        do {
            System.out.println("*************************");
            System.out.println("Menu de opcoes");
            System.out.println("**************************");
            System.out.println("1-Mostrar informcoes");
            System.out.println("2-Aumentar a quilometragem");
            System.out.println("3-Sair");
            System.out.println("**************************");
            opcao = tec.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println();
                    c1.exibirDetalhes();
                    break;
                case 2:
                    System.out.println("Digite o aumento da velocidade:");
                    aumento = tec.nextInt();
                    if (aumento <= c1.getQuilometragemAtual()) {
                        do {
                            System.out.println("Digite um aumento maior que quilometragem atual");
                            aumento = tec.nextInt();
            
                        } while (aumento < c1.getQuilometragemAtual());
                    }
                    System.out.println();
                    c1.AumentarQuilometragem(aumento);
                    if (c1.VerificarTrocaOleo()) {
                        System.out.println("Precisa trocar o oleo um momento...");
                        c1.realizarTrocadeOleo();
                        System.out.println("Troca de oleo efetuada:");
                    }
                    System.out.println();
                case 3:
                    break;
                default:
                    System.out.println("Opcao Invalida");
                    break;
            }
        } while (opcao!=3);
        System.out.println("Fim do programa");
        tec.close();
    }
}
