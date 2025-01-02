import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ContagemTermos {
    public static int LerTermos(File nomeArquivo,String termo){
        int contador = 0;
        try{
            FileReader leitor = new FileReader(nomeArquivo);
            int c;
            String texto = "";
            while ((c = leitor.read()) != -1) {
                char ch = (char) c;
                if (ch != ' ') {
                    texto += Character.toString(ch); 
                }
                else{
                    texto = "";
                }
                if (texto.equalsIgnoreCase(termo)) {
                    ++contador;
                }    
            }  
            leitor.close(); 
        }
        catch(FileNotFoundException aException){
            System.err.println("Arquivo Não Encontrado");
        }  
        catch(IOException bException){
            System.err.println("Falha "+bException);
        }
        return contador;      
    }
}
