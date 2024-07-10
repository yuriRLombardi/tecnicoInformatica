package aula19;

public class MyLin {
    public static int contador = 0;

    public static String transformaMaiuscula(String palavra){
        contador++;
        return palavra.toUpperCase();
    }
    public static String transformaMinuscula(String palavra){
        contador++;
        return palavra.toLowerCase();
    }
    public static int usadaQuantasVezes(){
        return contador;
    }
}