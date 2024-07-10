package ex1;
/*
 Feito por: Yuri, Yago e Kevin
 Data: 02/07/24
 */
public class Pessoa {
private String nome;
private String cpf;
private Endereco endereco;

public Pessoa(String nome, String cpf, Endereco endereco) {
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

public Endereco getEndereco() {
    return endereco;
}

public void setEndereco(Endereco endereco) {
    this.endereco = endereco;
}
public void exibirDados(){
System.out.println("PESSOA");    
System.out.println("Nome: "+ nome);
System.out.println("CPF: "+ cpf);
System.out.println("ENDERECO");
System.out.println("Rua: "+ endereco.getRua());
System.out.println("Numero: "+ endereco.getNum());
System.out.println("Cidade: "+ endereco.getCidade());
System.out.println("Estado: "+ endereco.getEstado());



}
}
