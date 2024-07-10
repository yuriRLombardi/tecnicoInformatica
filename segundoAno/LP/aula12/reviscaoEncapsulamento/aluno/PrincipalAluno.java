package aluno;

import java.util.Scanner;
/*
 * Feito por: Yuri
 * Data: 19/06/24
 * Modificações: 20/06/24
 */

public class PrincipalAluno {
    public static void opcoes(String msg){
        String texto = 
        """
        %s
        [1] Primeiro Alnuno
        [2] Segundo Aluno  
        [3] Dos dois Alunos        
        """;
        System.out.printf(texto,msg);
    }
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Aluno a1 = new Aluno("Jose", "1291");
        Aluno a2 = new Aluno("Maria", "7869");
        String opcoes =
        """
        GERENCIADOR DE NOTAS DE ALUNOS 
        [1] Exibir Informacoes
        [2] Adicinar Notas
        [3] Verificar Aprovacao
        [4] Sair
        """;
        int op = 0;
        do {
            System.out.println(opcoes);
            op = ler.nextInt();
            switch (op) {
                case 1:
                    String opExibir = "EXIBIR:";
                    opcoes(opExibir);
                    int opE = ler.nextInt();
                    if (opE == 1) {
                        a1.exibirInformacoes();
                    }
                    else if (opE == 2) {
                        a2.exibirInformacoes();
                    }
                    else if (opE == 3) {
                        a1.exibirInformacoes();
                        a2.exibirInformacoes();
                    }
                    else{
                        System.out.println("OPCAO INVALIDA");
                    }
                    break;
                case 2:
                    String opAdicionar = "ADICIONAR NOTA PARA:";
                    opcoes(opAdicionar);
                    int opA = ler.nextInt();
                    if (opA != 1 && opA != 2 && opA != 3) {
                        System.out.println("OPCAO INVALIDA");
                    }
                    else{
                        System.out.println("Quanto vai adicionar?:");
                        float nota = ler.nextFloat();
                        System.out.println("Em qual posicao vai adicionar?[0 = 1º posicao, 1 = 2º posicao,2 = 3º posicao] "); 
                        int posicao = ler.nextInt();
                        if (opA == 1) {
                            a1.adicinarNota(nota, posicao);
                        }
                        else if (opA == 2) {
                            a2.adicinarNota(nota, posicao);
                        }
                        else if (opA == 3) {
                            a1.adicinarNota(nota, posicao); 
                            a2.adicinarNota(nota, posicao);
                        }
                    }
                    break;
                case 3:
                    String opValidar = "VERIFICAR APROVACAO";
                    opcoes(opValidar);
                    int opV = ler.nextInt();
                    if (opV == 1) {
                        if (a1.verificarAprovacao()) {
                            System.out.println(" PRIMEIRO APROVADO");
                        }
                        else{
                            System.out.println("PRIMEIRO REPROVADO");
                        }
                    }
                    else if (opV == 2) {
                        if (a2.verificarAprovacao()) {
                            System.out.println("SEGUNDO APROVADO");
                        }
                        else{
                            System.out.println("SEGUNDO ALUNO REPROVADO");
                        }
                    }
                    else if (opV == 3) {
                        if (a1.verificarAprovacao()) {
                            System.out.println("PRIMEIRO APROVADO");
                        }
                        else{
                            System.out.println("PRIMEIRO REPROVADO");
                        }
                        if (a2.verificarAprovacao()) {
                            System.out.println("SEGUNDO APROVADO");
                        }
                        else{
                            System.out.println("SEGUNDO ALUNO REPROVADO");
                        }
                    }
                    else{
                        System.out.println("OPCAO INVALIDA");
                    }
                    break;
                case 4:
                    System.out.println("SAINDO...");
                    break;
                default:
                    System.out.println("OPCAO INVALIDA");
                    break;
            }
        } while (op != 4);
        System.out.println("ENCERRANDO O PROGRAMA...");
        ler.close();
    }
    
}
