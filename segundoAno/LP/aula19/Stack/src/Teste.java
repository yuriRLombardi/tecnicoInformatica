/*
 * Feito por: Yuri e Kevin
 * Data: 17/09/24
 */
public class Teste {
    public static void main(String[] args) {
        Pilha p1 = new Pilha();
        p1.push(1);
        p1.push(2);
        p1.push(3);
        
        System.out.print("Os elementos sao: ");
        p1.print();
        System.out.println();

        System.out.println("É vazio? "+p1.isEmpty());


        p1.pop();

        System.out.print("Os elementos sao: ");
        p1.print();
        System.out.println();

        p1.pop();

        p1.pop();

        System.out.println("É vazio? "+p1.isEmpty());

        p1.pop();
        
        
    }
}
