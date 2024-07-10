package ex4desafio;


/*
 Feito por: Yuri
 Data: 02/07/24
 Modificação: 03/07/24
 */
public class Pessoa {
    private String nome;
    private String cpf;
    private Endereco[] endereco;

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
        int tamanho = endereco.length;
        System.out.println("INFORMACOES PESSOA");    
        System.out.println("    Nome: "+ nome);
        System.out.println("    CPF: "+cpf);
        String exibirEndereco =
        """
            ENDERECO %d
                Rua: %s
                Numero: %s
                Cidade: %s
                Estado: %s       
        """;
        for(int c = 0;c < tamanho;c++){
            System.out.printf(exibirEndereco,(c+1),endereco[c].getRua(),endereco[c].getNum(),endereco[c].getCidade(),endereco[c].getEstado());
        }
    }
}
