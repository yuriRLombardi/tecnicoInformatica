import java.util.Arrays;
import java.util.Scanner;
public class PesquisaBinariaRecursiva {
    public static boolean ProcurarElemento(int [] array,int primeiro,int ultimo,int num){
        Arrays.sort(array);

        if(primeiro > ultimo){
            return false;
        }else{
            int i = primeiro + (ultimo - primeiro)/2;
           
            if(array[i] == num){
                return true;
            }
            else if(num < array[i]){
                return ProcurarElemento(array, primeiro,i-1, num);
            }else{
                return ProcurarElemento(array,i+1, ultimo, num);
            }
        }
    }
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int [] numeros = {7,5,3,2,1,6,7,8,9};
        System.out.print("Digite o numero que deseja procurar: ");
        int num = ler.nextInt();
        if(ProcurarElemento(numeros, 0,numeros.length - 1,num)){
            System.out.println("Elemento Encontrado!");
        }else{
            System.out.println("Elemento Nao Encontrado!");
        }
        ler.close();
    }
}