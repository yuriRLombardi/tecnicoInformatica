package ex2;
/*
 Feito por: Yuri e Kevin
 Data: 02/07/24
 */
public class Carro {
    private String modelo;
    private String marca;
    private Motor motor;
    public Carro(String modelo, String marca, Motor motor) {
        this.modelo = modelo;
        this.marca = marca;
        this.motor = motor;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public Motor getMotor() {
        return motor;
    }
    public void setMotor(Motor motor) {
        this.motor = motor;
    }
    public void exibirDados(){
        System.out.println("INFORMACOES CARRO");
        System.out.println("Modelo: "+ modelo);
        System.out.println("Marca: "+marca);
        System.out.println("MOTOR");
        System.out.println("Potencia: "+motor.getPotencia());
        System.out.println("Tipo: "+motor.getTipo());
    }
}
