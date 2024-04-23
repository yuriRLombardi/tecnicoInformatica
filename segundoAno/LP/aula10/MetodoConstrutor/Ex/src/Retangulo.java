public class Retangulo {

    double largura,altura;

    public Retangulo(double largura, double altura){
        this.largura = largura;
        this.altura = altura;
    }
    public double area(){
        double resultado = largura * altura; 
        return resultado;
    }       
    public double perimetro(){
        double resultado = (largura * 2) + (altura * 2);
        return resultado;
    }
}

