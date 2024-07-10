package produto;
/*
 * Feito por: Yuri
 * Data: 19/06/24
 */
import java.util.Scanner;

public class PrincipalProduto {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Produto p1 = new Produto("Airfryer", "9021-2340", 269.99, 10);
        Produto p2 = new Produto("Xbox 360", "3600-1800", 1500.00, 5);
        String texto = 
        """
        Olá, seja bem vindo ao gerenciador de produtos
        O que tu deseja?
        [1] Mostrar Informacoes
        [2] Adicionar no Estoque
        [3] Remover do Estoque
        [4] Aplicar um Desconto
        [5] Sair        
        """;
        int op = 0;
        String aviso = 
        """
        AVISO
        Caso o progroma não aplicar nenhum desconto
        ou remocao de estoque, é por causa de valores
        invalidos        
        """;
        System.out.println(aviso);
        do{
            System.out.println(texto);
            op = ler.nextInt();
            switch (op) {
                case 1:
                String exibicao =
                """
                Quer exibir qual?
                [1] O primeiro produto
                [2] O segundo produto
                [3] Os dois produtos
                """;
                System.out.println(exibicao);
                int opExibicao = ler.nextInt();
                if (opExibicao == 1) {
                    p1.exibirInformacoes();
                }
                else if(opExibicao == 2) {
                    p2.exibirInformacoes();
                }
                else if (opExibicao == 3) {
                    p1.exibirInformacoes();
                    p2.exibirInformacoes();
                }
                else{
                    System.out.println("Opcao invalida");
                }
                break;
                case 2:
                   System.out.println("Quanto voce quer adicinar?");
                   int adicionar = ler.nextInt();
                   String adicinaString =
                   """
                   Em qual vai adicionar?
                   [1] Primeiro produto
                   [2] Segundo produto     
                   """; 
                   System.out.println(adicinaString);
                   int opAdicionar = ler.nextInt();
                   if (opAdicionar == 1) {
                        p1.adicionarEstoque(adicionar);
                   } 
                   else if (opAdicionar == 2) {
                       p2.adicionarEstoque(adicionar);
                   }
                   else{
                       System.out.println("Opcao invalida");
                   }
                break;
                case 3:
                    System.out.println("Quanto voce quer remover?");
                    int remover = ler.nextInt();
                    String removerString =
                    """
                    Em qual vai remover?
                    [1] Primeiro produto
                    [2] Segundo produto     
                    """; 
                    System.out.println(removerString);
                    int opRemover = ler.nextInt();
                    if (opRemover == 1) {
                        p1.removerEstoque(remover);
                    } 
                    else if (opRemover == 2) {
                        p2.removerEstoque(remover);
                    }
                    else{
                        System.out.println("Opcao invalida");
                    } 
                break;                   
                case 4:
                   System.out.println("Quanto de desconto?");
                   double desconto = ler.nextInt();
                   String descontoString =
                   """
                    Quer aplicar em qual?
                    [1] O primeiro produto
                    [2] O segundo produto
                    [3] Os dois produtos        
                   """;
                   System.out.println(descontoString);
                   int opDesconto = ler.nextInt();
                   if (opDesconto == 1) {
                        p1.aplicarDesconto(desconto);
                   }
                   else if (opDesconto == 2) {
                        p2.aplicarDesconto(desconto);
                   }
                   else if (opDesconto == 3) {
                        p1.aplicarDesconto(desconto);
                        p2.aplicarDesconto(desconto);
                   }
                   else{
                    System.out.println("Opcao Invalida");
                   }
                break;
                case 5:
                    System.out.println("Saindo....");
                break;
                default:
                   System.out.println("Opcao invalida");
                break;
            }
        }while(op != 5);
        System.out.println("Fim do programa");
        ler.close();
    }
}
