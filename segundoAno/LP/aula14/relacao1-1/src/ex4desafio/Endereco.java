package ex4desafio;
 /*
 Feito por: Yuri
 Data: 02/07/24
 Modificação: 03/07/24
 */

public class Endereco {
private String rua;
private int num;
private String cidade; 
private String estado;

public Endereco(String rua, int num, String cidade, String estado) {
    this.rua = rua;
    this.num = num;
    this.cidade = cidade;
    this.estado = estado;
    
}
public String getRua() {
    return rua;
}

public void setRua(String rua) {
    this.rua = rua;
}

public int getNum() {
    return num;
}

public void setNum(int num) {
    this.num = num;
}

public String getCidade() {
    return cidade;
}

public void setCidade(String cidade) {
    this.cidade = cidade;
}

public String getEstado() {
    return estado;
}

public void setEstado(String estado) {
    this.estado = estado;
}

}
