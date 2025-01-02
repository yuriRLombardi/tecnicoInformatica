import java.util.Arrays;
public class PesquisaBinaria {
    public static boolean ProcurarElemento(int [] array,int num){
        Arrays.sort(array);
        int tamanhoArray = array.length;
        int primeiro = 0;
        int ultimo = tamanhoArray-1;
        
        while(primeiro <= ultimo){

            int i = primeiro + (ultimo - primeiro)/2;

            if(array[i] == num){
                return true;
            }
            if(num < array[i]){
                ultimo = i - 1;
            }else{
                primeiro = i + 1;
            }

        }
        return false;
    }
    public static void main(String[] args) {
        int [] numeros = {7,5,3,2,1,6,7,8,9};
        if(ProcurarElemento(numeros, 5)){
            System.out.println("Existe!");
        }else{
            System.out.println("Nao existe!");
        }
    }
}