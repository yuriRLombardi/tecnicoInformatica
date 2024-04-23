//classe criada por Yuri e Yago
//Data:09/04

public class Funcionario {
    private String nome;
    private String cargo;
    private double salario;

    public Funcionario (String nome,String cargo,double salario){
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }
    void aumentarSalario(double aumento){
        if (aumento>=0) {
            salario += aumento;   
        }      
    }
    void exibirDetalhes(){
        System.out.println("Nome: "+nome);
        System.out.println("Cargo: "+ cargo);
        System.out.println("Salario: "+ salario);
        
    }
}
