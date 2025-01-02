package ex3;

import java.util.ArrayList;

//import java.util.ArrayList;

/*
 Feito por: Yuri e Yago
 Data: 02/07/24
 Modificação: 17/07/24
 */
public class Pessoa {
    private String nome;
    private String cpf;
    //private Endereco[] enderecos = new Endereco[3];
    private ArrayList<Endereco> endereco = new ArrayList<Endereco>();
    /*public Pessoa(String nome, String cpf,Endereco e1, Endereco e2, Endereco e3) {
        this.nome = nome;
        this.cpf = cpf;
        endereco.add(e1);
        endereco.add(e2);
        endereco.add(e3);
    }*/

    /*public Pessoa(String nome, String cpf, ArrayList<Endereco> endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
    }*/
    public Pessoa(String nome, String cpf,Endereco e1) {
        this.nome = nome;
        this.cpf = cpf;
        endereco.add(e1);
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
    public ArrayList<Endereco> getEnderecos() {
        return endereco;
    }

    public void setEnderecos(ArrayList<Endereco> endereco) {
        this.endereco = endereco;
    }
    public void addEnd(){
        
    }
    public void removeEnd(int indice){
        endereco.remove(indice);
    }
    public void exibirDados(){
        int contador = 1;
        System.out.println("INFORMACOES PESSOA");
        System.out.println("Nome: "+this.nome);
        System.out.println("CPF: "+this.cpf);
        for (Endereco end : endereco) {
            System.out.println("ENDERECO " + contador);
            contador ++;
            System.out.println("Rua: "+end.getRua());
            System.out.println("Numero: "+end.getNum());
            System.out.println("Cidade: "+end.getCidade());
            System.out.println("Estado: "+end.getEstado());
        }
    }

}
