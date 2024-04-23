public class Aluno {
    String nome;
    int matricula;
    String curso;
    String dis1,dis2,dis3;
    float nota1,nota2,nota3;

    void aprovacao(){
        float media = (nota1+nota2+nota3)/3;
        if (media>=6) {
            System.out.println("A situacao do aluno: APROVADO");
        }
        else{
            System.out.println("A situacao do aluno: REPROVADO");
        }
    }
}
