import java.util.Scanner;
//classe principal criada por Yuri e Yago
//Data:09/04
public class PrincipalF {
    public static void main(String[] args) {
    Scanner tec = new Scanner(System.in);
    Funcionario f1 = new Funcionario("Pedro","Pedreiro",1000);
    Funcionario f2 = new Funcionario("Ivan", "Empresario", 3000);
    System.out.println("Informacoes do Funcionario1");
    f1.exibirDetalhes();
    System.out.println();
    System.out.println("Informacoes do Funcionario2");
    f2.exibirDetalhes();
    System.out.println();
    System.out.println("Digite o aumento para o funcionario1: ");
    double aumento1 = tec.nextDouble();
    if (aumento1<=0) {
        do {
            System.out.println("Digite o aumento maior que zero");
            aumento1 = tec.nextDouble();  
        } while (aumento1<=0);
        
    }
    f1.aumentarSalario(aumento1);
    System.out.println();
    System.out.println("Digite o aumento para o funcionario2: ");
    double aumento2 = tec.nextDouble();
    System.out.println();
    if (aumento2<=0) {
        do {
            System.out.println("Digite o aumento maior que zero");
            aumento2 = tec.nextDouble(); 
        } while (aumento2<=0);  
    }
    System.out.println();
    f2.aumentarSalario(aumento2);
    System.out.println("Informacoes do Funcionario1");
    f1.exibirDetalhes();
    System.out.println();
    System.out.println("Informacoes do Funcionario2");
    f2.exibirDetalhes();
    tec.close();
    }
}
