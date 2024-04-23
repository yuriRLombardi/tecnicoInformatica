/*
Classe que faz os calculos de volume e base do cone
Feito por: Yuri
*/
public class Cone{
    
    public static double volume(double A,double B){
       double resultado = B/3 * Math.PI * Math.pow(A, 2);
       return resultado;
    }
    public static double perimetroBase(double A) {
        double resultado = 2 * Math.PI * A;
        return resultado;  
    }
}
