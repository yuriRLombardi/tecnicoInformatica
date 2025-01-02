import java.util.ArrayList;
import java.util.EmptyStackException;

public class FilaG<T>{
        private final ArrayList<T> elements;


    public FilaG()
    {
        this(10);
    }

    public FilaG(int capacity)
    {
        int initCapacity = capacity > 0 ? capacity : 10; 
        elements = new ArrayList<T>(initCapacity); 
    }


    public void adicionar(T pushValue)
    {
        elements.add(pushValue); 
    }

    public T remover()
    {
        if (elements.isEmpty())
            throw new EmptyStackException();

        return elements.remove(0);
    }
}
