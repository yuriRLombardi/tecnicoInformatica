public class Lampada {
    boolean verificar;
    String cor;
   
    void ligado(){
         verificar = true;
    }
    void desligado(){
        verificar = false;
    }
   boolean estaLigado(){
    System.out.println("Lampada esta ligada?");
    return  verificar;
   } 
}
