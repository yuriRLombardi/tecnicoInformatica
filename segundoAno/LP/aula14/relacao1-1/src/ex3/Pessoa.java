package ex3;
 /*
 Feito por: Yuri e Yago
 Data: 02/07/24
 Modificação: 03/07/24
 */
public class Pessoa {
private String nome;
private String cpf;
private Endereco[] endereco = new Endereco[3];

public Pessoa(String nome, String cpf, Endereco[] endereco) {
    this.nome = nome;
    this.cpf = cpf;
    this.endereco = endereco;
}
public String getNome() {
    return nome;
}

public void setNome(String nome) {
    this.nome = nome;
}

public String getCpf() {
    return cpf;
}

public void setCpf(String cpf) {
    this.cpf = cpf;
}

public Endereco[] getEndereco() {
    return endereco;
}

public void setEndereco(Endereco[] endereco) {
    this.endereco = endereco;
}
public void exibirDados(){
System.out.println("INFORMACOES PESSOA");    
System.out.println("  Nome: "+ nome);
System.out.println("  CPF: "+ cpf);
System.out.println("ENDERECO 1");
System.out.println("  Rua: "+ endereco[0].getRua());
System.out.println("  Numero: "+ endereco[0].getNum());
System.out.println("  Cidade: "+ endereco[0].getCidade());
System.out.println("  Estado: "+ endereco[0].getEstado());
System.out.println("ENDERECO 2");
System.out.println("  Rua: "+ endereco[1].getRua());
System.out.println("  Numero: "+ endereco[1].getNum());
System.out.println("  Cidade: "+ endereco[1].getCidade());
System.out.println("  Estado: "+ endereco[1].getEstado());
System.out.println("ENDERECO 3");
System.out.println("  Rua: "+ endereco[2].getRua());
System.out.println("  Numero: "+ endereco[2].getNum());
System.out.println("  Cidade: "+ endereco[2].getCidade());
System.out.println("  Estado: "+ endereco[2].getEstado());

}
}
