//Exemplo retirado de Deitel - Java : como programar 10ed
// Figura 12.17: CheckBoxFrame.java
// JCheckBoxes e eventos de item.
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;

public class CheckBoxFrame extends JFrame
{
    private final JTextField textField; // exibe o texto na alteração de fontes
    private final JCheckBox boldJCheckBox; // para marcar/desmarcar estilo negrito 
    private final JCheckBox italicJCheckBox; // para marcar/desmarcar estilo itálico
    private final JCheckBox arialJCheckBox;
    private final JRadioButton t8;
    private final JRadioButton t16;
    private final JRadioButton t32;
    private final JRadioButton tnormal;
    private final ButtonGroup grupoR;

    // construtor CheckBoxFrame adiciona JCheckBoxes ao JFrame
    public CheckBoxFrame()
    {
        super("JCheckBox Test");
        setLayout(new FlowLayout());

        // configura JTextField e sua fonte
        textField = new JTextField("Watch the font style change", 20);
        textField.setFont(new Font("Serif", Font.PLAIN, 14));
        add(textField); // adiciona textField ao JFrame

        boldJCheckBox = new JCheckBox("Bold");
        italicJCheckBox = new JCheckBox("Italic");
        arialJCheckBox = new JCheckBox("Arial");
        t8 = new JRadioButton("Tamanho 8pt",false);
        t16 = new JRadioButton("Tamanho 16pt",false);
        t32 = new JRadioButton("Tamanho 32pt",false);
        tnormal = new JRadioButton("Tamanho padrão",true);
        add(boldJCheckBox); // adiciona caixa de seleção de estilo negrito ao JFrame
        add(italicJCheckBox); // adiciona caixa de seleção de itálico ao JFrame
        add(arialJCheckBox);
        add(t8);
        add(t16);
        add(t32);
        add(tnormal);
        grupoR = new ButtonGroup();
        grupoR.add(t8);
        grupoR.add(t16);
        grupoR.add(t32);
        grupoR.add(tnormal);

        // listeners registradores para JCheckBoxes 
        CheckBoxHandler handler = new CheckBoxHandler();
        boldJCheckBox.addItemListener(handler); 
        italicJCheckBox.addItemListener(handler); 
        arialJCheckBox.addItemListener(handler);
        t8.addItemListener(handler);
        t16.addItemListener(handler);
        t32.addItemListener(handler);
    }

    // classe interna private para tratamento de evento ItemListener
    private class CheckBoxHandler implements ItemListener
    {
        // responde aos eventos de caixa de seleção
        @Override
        public void itemStateChanged(ItemEvent event)
        {
            Font font = null; // armazena a nova Font
            // determina quais CheckBoxes estão marcadas e cria Font
            //------------------------------------------------------------------------------------------------
            //Bold,Arial,Italico e 32pt
            if (boldJCheckBox.isSelected() && italicJCheckBox.isSelected() && arialJCheckBox.isSelected() && t32.isSelected())
                font = new Font("Arial", Font.BOLD + Font.ITALIC, 32);
            //------------------------------------------------------------------------------------------------
            //Bold,Arial,Italico e 16pt
            else if (boldJCheckBox.isSelected() && italicJCheckBox.isSelected() && arialJCheckBox.isSelected() && t16.isSelected())
                font = new Font("Arial", Font.BOLD + Font.ITALIC, 16);
            //------------------------------------------------------------------------------------------------
            //Bold,Arial,Italico e 8pt
            else if (boldJCheckBox.isSelected() && italicJCheckBox.isSelected() && arialJCheckBox.isSelected() && t8.isSelected())
            font = new Font("Arial", Font.BOLD + Font.ITALIC, 8);
            //------------------------------------------------------------------------------------------------
            //Bold,Arial,Italico e normal
            else if (boldJCheckBox.isSelected() && italicJCheckBox.isSelected() && arialJCheckBox.isSelected() && tnormal.isSelected())
            font = new Font("Arial", Font.BOLD + Font.ITALIC, 14);
            //------------------------------------------------------------------------------------------------
            //Bold,Italico e 32pt
            else if(boldJCheckBox.isSelected() && italicJCheckBox.isSelected() && t32.isSelected())
                font = new Font("Serif", Font.BOLD + Font.ITALIC, 32);
            //------------------------------------------------------------------------------------------------
            //Bold,Italico e 16pt
            else if(boldJCheckBox.isSelected() && italicJCheckBox.isSelected() && t16.isSelected())
                font = new Font("Serif", Font.BOLD + Font.ITALIC, 16);
            //------------------------------------------------------------------------------------------------
            //Bold,Italico e 8pt
            else if(boldJCheckBox.isSelected() && italicJCheckBox.isSelected() && t8.isSelected())
                font = new Font("Serif", Font.BOLD + Font.ITALIC, 8);
            //------------------------------------------------------------------------------------------------
            //Bold,Italico e normal
            else if(boldJCheckBox.isSelected() && italicJCheckBox.isSelected() && tnormal.isSelected())
                font = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
            //------------------------------------------------------------------------------------------------
            //Bold,Arial e 32pt
            else if(boldJCheckBox.isSelected() && arialJCheckBox.isSelected() && t32.isSelected())
                font = new Font("Arial", Font.BOLD, 32);
            //------------------------------------------------------------------------------------------------
            //Bold,Arial e 16pt
                else if(boldJCheckBox.isSelected() && arialJCheckBox.isSelected() && t16.isSelected())
                    font = new Font("Arial", Font.BOLD, 16);
            //------------------------------------------------------------------------------------------------
            //Bold,Arial e 8pt
                else if(boldJCheckBox.isSelected() && arialJCheckBox.isSelected() && t8.isSelected())
                    font = new Font("Arial", Font.BOLD, 8);
            //-----------------------------------------------------------------------------------------------
            //Bold,Arial e normal
            else if(boldJCheckBox.isSelected() && arialJCheckBox.isSelected() && t8.isSelected())
            font = new Font("Arial", Font.BOLD, 14);
            //-----------------------------------------------------------------------------------------------
            //Arial,Italico e 32pt
            else if(italicJCheckBox.isSelected() && arialJCheckBox.isSelected() && t32.isSelected())
                font = new Font("Arial", Font.ITALIC, 32);
            //---------------------------------------------------------------------------------------------- 
            //Arial,Italico e 16pt
            else if(italicJCheckBox.isSelected() && arialJCheckBox.isSelected() && t16.isSelected())
                font = new Font("Arial", Font.ITALIC, 16);
            //---------------------------------------------------------------------------------------------   
            //Arial,Italico e 8pt
            else if(italicJCheckBox.isSelected() && arialJCheckBox.isSelected() && t8.isSelected())
                    font = new Font("Arial", Font.ITALIC, 8);
            //--------------------------------------------------------------------------------------------- 
            //Arial,Italico e normal
            else if(italicJCheckBox.isSelected() && arialJCheckBox.isSelected() && tnormal.isSelected())
                    font = new Font("Arial", Font.ITALIC, 14);
            //---------------------------------------------------------------------------------------------   
            //Bold e 32pt
            else if (boldJCheckBox.isSelected() && t32.isSelected())
                font = new Font("Serif", Font.BOLD, 32);
            //------------------------------------------------------------------------------------------------
            //Bold e 16pt
            else if (boldJCheckBox.isSelected() && t16.isSelected())
                font = new Font("Serif", Font.BOLD, 16);
            //------------------------------------------------------------------------------------------------
            //Bold e 8pt
            else if (boldJCheckBox.isSelected() && t16.isSelected())
                font = new Font("Serif", Font.BOLD, 16);
            //------------------------------------------------------------------------------------------------
            //Italico e 32pt 
            else if (italicJCheckBox.isSelected() && t32.isSelected())
                font = new Font("Serif", Font.ITALIC, 32);
            //------------------------------------------------------------------------------------------------
            //Italico e 16pt 
            else if (italicJCheckBox.isSelected() && t16.isSelected())
                font = new Font("Serif", Font.ITALIC, 16);
            //------------------------------------------------------------------------------------------------
            //Italico e 8pt 
            else if (italicJCheckBox.isSelected() && t8.isSelected())
                font = new Font("Serif", Font.ITALIC, 8);
            //------------------------------------------------------------------------------------------------
            //Arial e 32pt
            else if (arialJCheckBox.isSelected() && t32.isSelected())
                font = new Font("Arial",Font.PLAIN,32);
            //------------------------------------------------------------------------------------------------
            //Arial e 16pt
            else if (arialJCheckBox.isSelected() && t16.isSelected())
                font = new Font("Arial",Font.PLAIN,16);
            //------------------------------------------------------------------------------------------------
            //Arial e 8pt
            else if (arialJCheckBox.isSelected() && t8.isSelected())
                font = new Font("Arial",Font.PLAIN,8);
            //------------------------------------------------------------------------------------------------
            //Bold,Arial e Italico 
            else if (boldJCheckBox.isSelected() && italicJCheckBox.isSelected() && arialJCheckBox.isSelected())
                font = new Font("Arial", Font.BOLD + Font.ITALIC, 14);
            //------------------------------------------------------------------------------------------------
            //Bold e Italico 
            else if(boldJCheckBox.isSelected() && italicJCheckBox.isSelected())
                font = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
            //------------------------------------------------------------------------------------------------
            //Bold e Arial
            else if(boldJCheckBox.isSelected() && arialJCheckBox.isSelected())
                font = new Font("Arial", Font.BOLD, 14);
            //------------------------------------------------------------------------------------------------
            //Italico e Arial
            else if(italicJCheckBox.isSelected() && arialJCheckBox.isSelected())
                font = new Font("Arial", Font.ITALIC, 14);
            //------------------------------------------------------------------------------------------------
            //32pt
            else if (t32.isSelected()) 
                font = new Font("Serif",Font.PLAIN,32);
            //------------------------------------------------------------------------------------------------
            //16pt
            else if (t16.isSelected())
                font = new Font("Serif",Font.PLAIN,16);
            //------------------------------------------------------------------------------------------------
            //8pt
            else if (t8.isSelected())
                font = new Font("Serif",Font.PLAIN,8);
            //------------------------------------------------------------------------------------------------
            //Bold
            else if (boldJCheckBox.isSelected())
                font = new Font("Serif", Font.BOLD, 14);
            //------------------------------------------------------------------------------------------------
            //Italico
            else if (italicJCheckBox.isSelected())
                font = new Font("Serif", Font.ITALIC, 14);
            //------------------------------------------------------------------------------------------------
            //Arial
            else if (arialJCheckBox.isSelected())
                font = new Font("Arial",Font.PLAIN,14);
            //------------------------------------------------------------------------------------------------
            //Caso as condições não forem atenditas
            else
                font = new Font("Serif", Font.PLAIN, 14);
            //------------------------------------------------------------------------------------------------
            textField.setFont(font);
        }
    }
} // fim da classe CheckBoxFrame