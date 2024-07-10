package aluno;
/*
 * Feito por: Yuri
 * Data: 18/06/24
 * Modificação: 19/06/24
 */
public class Aluno {
    private String nome;
    private String matricula;
    private float[] notas = new float[3];
    public Aluno(String nome, String matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public float[] getNotas() {
        return notas;
    }
    public void setNotas(float[] notas) {
        this.notas = notas;
    }
    public void adicinarNota(float nota, int posicao){
        if ((posicao >= 0) && (posicao <=2) && (nota >= 0) && (nota <= 10)) {
            this.notas[posicao] = nota;
        }
        else{
            System.out.println("POSICAO OU NOTA INVALIDOS");
        }
    }
    private float calcularMedia(){
        return (notas[0]+notas[1]+notas[2])/3;
    }
    public boolean verificarAprovacao(){
        if (calcularMedia() >= 7) {
            return true;
        }
        else{
            return false;
        }
    }
    public void exibirInformacoes(){
        String exibir =
        """
        INFORMACOES DO ALUNO
        Nome: %s
        Matricula: %s  
        """;
        System.out.printf(exibir,this.getNome(),this.getMatricula(),this.getNotas());
        System.out.println("Nota 1: "+this.notas[0]);
        System.out.println("Nota 2: "+this.notas[1]);
        System.out.println("Nota 3: "+this.notas[2]);
        System.out.println();
    }
}
