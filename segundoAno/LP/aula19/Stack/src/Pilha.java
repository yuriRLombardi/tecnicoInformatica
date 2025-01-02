import java.util.ArrayList;
/*
 * Feito por: Yuri e Kevin
 * Data: 17/09/24
 */
public class Pilha {
    
    private ArrayList<Object> stack;


    public Pilha() {
        this.stack = new ArrayList<Object>();
    }
    public void push(Object elemento){
        this.stack.add(0,elemento);
    }
    public void pop(){
        if(this.stack.size() != 0){
            this.stack.remove(0);
        }
    }
    public boolean isEmpty(){
        return this.stack.isEmpty();
    }
    public void print(){
        for (Object object : stack) {
            System.out.print(object+" ");
        }
    }
}
