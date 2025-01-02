import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
    System.out.println("Para o teste,será criado um arquivo txt aumaticamente...");
    try {
          Scanner ler = new Scanner(System.in);
          File file = new File("test.txt"); 

          if (file.createNewFile()) { 
             System.out.println("Arquivo criado");
          } else {
             System.out.println("Arquivo já existe");
          } 
          
          System.out.print("Escreva algumas coisas para colocar dentro do arquivo: ");
          String texto = ler.nextLine();
          FileWriter writer = new FileWriter(file, true);
          writer.write(" "+texto+"\n");
          writer.close();
          System.out.print("Certo,agora selecione o termo que voce deseja ver o numero de ocorrencias: ");
          String termo = ler.nextLine();
          System.out.println("Temos "+ContagemTermos.LerTermos(file,termo)+" ocorrencias do termo");
          //ContagemTermos.LerTermos(file, termo);
          ler.close();
      } catch (IOException e) {
         System.out.print("Erro");
      }
}
}