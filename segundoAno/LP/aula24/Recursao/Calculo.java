public class Calculo{

    public static int somar(int n){
        if(n==0){
            return 0;
        }else{
            return n + somar(n-1);
        }
    }
    public static int fatorial(int n){
        if(n==0 || n == 1){
            return 1;
        }else{
            return n * fatorial(n-1);
        }
    }
}