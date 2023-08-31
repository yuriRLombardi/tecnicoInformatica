import java.util.Scanner;

public class CalculadoraIMC{
     public static void main(String[] args){
        float peso,altura,Imc;

		Scanner tec =new Scanner(System.in);

		System.out.println("Digite seu peso em quilos");
		peso = tec.nextFloat();
		
        System.out.println("Digite sua altura em metros");
		altura = tec.nextFloat();

        Imc = peso/(altura * altura);
        System.out.println("Seu IMC eh  "+ Imc);
        if (Imc < 18.5){
            System.out.println("Abaixo do peso");
        }
        else if (Imc >= 18.5 && Imc <= 24.9){
            System.out.println("Peso normal");
        }
		else{
            if(Imc >= 25 && Imc <= 29.9){
                System.out.println("Sobrepeso");
            }
            else if(Imc >= 30 && Imc <= 34.9){
                System.out.println("Obesidade grau 1");
            }
            else{
                if(Imc >= 35 && Imc <= 39.9){
                    System.out.println("Obesidade grau 2");
                }
                else{
                    System.out.println("Obesidade grau 3");
                }
            }
        }
        tec.close();	
     }
}