public class EmptyFilaGException extends RuntimeException   
{
    // construtor sem argumento
    public EmptyFilaGException()
    {
        this("Fila is empty");
    }

    // construtor de um argumento
    public EmptyFilaGException(String message)
    {
        super(message);
    }
} // fim da classe EmptyStackException