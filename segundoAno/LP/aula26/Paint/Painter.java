import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Painter {
    public static void main(String[] args) {
        JFrame aplicacao = new JFrame("Uma simples aplicação");
        PaintPanel paintPanel = new PaintPanel();
        aplicacao.add(paintPanel,BorderLayout.CENTER);
        aplicacao.add(new JLabel("Segure e mova o mouse para desenhar"),BorderLayout.SOUTH);
        aplicacao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aplicacao.setSize(400,200);
        aplicacao.setVisible(true);

    }
}