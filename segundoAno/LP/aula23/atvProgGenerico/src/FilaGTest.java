public class FilaGTest {
    public static void main(String[] args) {
        FilaG<Double> doubleFilaG = new FilaG<>(5);
        doubleFilaG.adicionar(1.5);
        doubleFilaG.adicionar(3.4);
        doubleFilaG.adicionar(4.5);

        
        System.out.println("O Primeiro elemento da fila de Double é: " + doubleFilaG.remover());


        FilaG<String> stringFilaG = new FilaG<>(5);
        stringFilaG.adicionar("Laranja");
        stringFilaG.adicionar("Maçã");

        System.out.println("O Primeiro elemento da fila de String é: " + stringFilaG.remover());
        System.out.println("O Primeiro elemento da fila de String é: " + stringFilaG.remover());
    }
}
