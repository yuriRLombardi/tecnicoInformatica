import java.util.Scanner;

public class PrincipalP {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int quantidadeC = 0;     
    int quantidadeV = 0;
    System.out.println("Digite o nome do produto:");
    String nome = sc.nextLine();
    if (nome.length() == 0) {
        do{
            System.out.println("Digite um valor maior do que zero");
            nome = sc.nextLine();
        }while(nome.length() == 0);
    }
    System.out.println("Digite o preço do estoque:");
    double preco = sc.nextDouble();
    if (preco<=0) {
        do{
            System.out.println("Digite um valor maior do que zero");
            preco = sc.nextDouble();
        }while(preco<= 0);
    }
    System.out.println("Digite a quantidade do estoque:");
    int quantidade = sc.nextInt();
    if (quantidade<=0) {
        do{
            System.out.println("Digite um valor maior do que zero");
            quantidade = sc.nextInt();
        }while(quantidade<= 0);
    }
    Produto p1 = new Produto(nome, preco, quantidade);
    System.out.println("Digite V para vender um lote ou C para comprar um lote ou N para fazer nenhum dos dois");
    String opcao = sc.next();
    if (!opcao.equalsIgnoreCase("V")) {
        
        do {
            if (opcao.equalsIgnoreCase("C")) {
                break;
            }
            else if (opcao.equalsIgnoreCase("N")) {
                break;
            }
            System.out.println("Digite V,C ou N");
            opcao = sc.next();
        } while (!opcao.equalsIgnoreCase("V"));
    }
    if (opcao.equalsIgnoreCase("V")) {
        System.out.println("Digite o quanto voce vai vender:");    
        quantidadeV = sc.nextInt();
        if (quantidadeV<=0 || quantidadeV>quantidade) {
            do {
                System.out.println("Digite valores positivos diferente de zero e/ou digite um valor menor ou igual do que seu estoque:");
                quantidadeV = sc.nextInt();
            } while (quantidadeV<=0 || quantidadeV>quantidade);
        }
        p1.diminuir(quantidadeV);
    }
    else if(opcao.equalsIgnoreCase("C")){
        System.out.println("Digite o quanto voce vai comprar ");
        quantidadeC = sc.nextInt();
        if (quantidadeC<=0) {
            do {
                System.out.println("Digite valores positivos e diferente de zero:");
                quantidadeC = sc.nextInt();
            } while (quantidadeC<=0);
        }
        p1.aumentar(quantidadeC);
    }
    else{
        if (opcao.equalsIgnoreCase("N")) {
            System.out.println("Nenhuma compra ou venda efetuada");
        }
    }
    System.out.println("INFORMACOES ESTOQUE: ");
    System.out.println("Nome do produto: "+p1.nome);
    System.out.println("Preco do estoque: "+p1.preco);
    System.out.println("Quantidade do estoque: "+p1.quantidadeEmEstoque);
    System.out.println("Seu valor de estoque total eh: "+ p1.valorTotEstoque() );
    sc.close();
    }
}
