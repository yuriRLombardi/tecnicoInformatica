
import java.util.ArrayList;
/*
 * Programa para conhecer a Arraylist
 * Feito por: Yuri
 * Data: 10/07/24
 */
public class Lista {

    public static void main(String[] args) {
        ArrayList<String> carros = new ArrayList<String>();
        carros.add("Corsa");
        carros.add("Celta");
        carros.add("Corolla");
        System.out.println("Os meus carros sao: "+carros);
        System.out.println("Quantos carros tenho na lista?: "+carros.size());
        System.out.println("Qual o segundo carro?: "+carros.get(1));
        carros.set(1, "Fiat");
        //carros.removeAll(carros); -> Remove tudo tendo uma ArrayList como parametro
        //carros.clear(); -> Limpa tudo
        carros.remove(1);
        for(int c = 0;c<carros.size();c++){
            System.out.println(carros.get(c)+" na posicao "+(c+1));
        }       
        System.out.println("Tem fiat na lista?: "+ carros.contains("Fiat"));
    }
}