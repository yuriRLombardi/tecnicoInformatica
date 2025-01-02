//Exemplo retirado de Deitel - Java : como programar 10ed
// Figura 12.18: CheckBoxTest.java
// Testando CheckBoxFrame.
import javax.swing.JFrame;

public class CheckBoxTest
{
    public static void main(String[] args)
    {
        CheckBoxFrame checkBoxFrame = new CheckBoxFrame();
        checkBoxFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        checkBoxFrame.setSize(275, 100);
        checkBoxFrame.setVisible(true);
    }
} // fim da classe CheckBoxTest
