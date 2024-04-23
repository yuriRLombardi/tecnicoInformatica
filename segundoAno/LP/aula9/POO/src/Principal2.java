import java.util.Scanner;

public class Principal2 {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        Aluno aluno1 = new Aluno();
        System.out.println("Digite seu Nome: ");
        aluno1.nome = tec.nextLine();
        System.out.println("Digite sua Matricula: ");
        aluno1.matricula = tec.nextInt();
        tec.nextLine();
        System.out.println("Digite seu Curso: ");
        aluno1.curso = tec.nextLine();
        System.out.println("Digite a Disciplina1");
        aluno1.dis1 = tec.nextLine();
        System.out.println("Digite a Disciplina2");
        aluno1.dis2 = tec.nextLine();
        System.out.println("Digite a Disciplina3");
        aluno1.dis3 = tec.nextLine();
        System.out.println("Digite a Nota1: ");
        aluno1.nota1 = tec.nextFloat();
        System.out.println("Digite a Nota2: ");
        aluno1.nota2 = tec.nextFloat();
        System.out.println("Digite a Nota1: ");
        aluno1.nota3 = tec.nextFloat();
        System.out.println("INFORMACOES DO ALUNO");
        System.out.println("Nome: "+aluno1.nome);
        System.out.println("Matricula: "+aluno1.matricula);
        System.out.println("Curso: "+aluno1.curso);
        System.out.println("Diciplina1: "+aluno1.dis1);
        System.out.println("Diciplina2: "+aluno1.dis2);
        System.out.println("Diciplina3: "+aluno1.dis3);
        System.out.println("Nota1: "+aluno1.nota1);
        System.out.println("Nota2: "+aluno1.nota2);
        System.out.println("Nota1: "+aluno1.nota1);
       aluno1.aprovacao();
       tec.close();
    }
}
