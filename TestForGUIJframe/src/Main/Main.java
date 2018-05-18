package Main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileOutputStream;

public class Main extends JFrame
{
    private JRadioButton RB_1,RB_2,RB_3;
    private JCheckBox ChekB_1,ChekB_2,ChekB_3;
    private JComboBox ComboBox;

    private JLabel Text;

    int sizeFront = 12;
    String styleShit;
    int style;

   private  Main()
    {
        super("Test");
        this.setSize(130,200);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));

        String[] ColorsArray = {"Red","Green","Yellow","Blue","Orange"};
        ComboBox = new JComboBox(ColorsArray);
        Text = new JLabel("I'm a Programer");
        Text.setFont(new Font("italica",Font.PLAIN,sizeFront));
        Text.setSize(30,50);

        ChekB_1 = new JCheckBox("Bold");
        ChekB_2 = new JCheckBox("Italic");
        ChekB_3 = new JCheckBox("Cursor");

        RB_1  = new JRadioButton("15");
        RB_2 = new JRadioButton("20");
        RB_3 = new JRadioButton("25");

        ButtonGroup BG = new ButtonGroup();
        BG.add(RB_1);
        BG.add(RB_2);
        BG.add(RB_3);


        c.add(Text);
        c.add(ComboBox);
        c.add(ChekB_1);
        c.add(ChekB_2);
        c.add(ChekB_3);
        c.add(RB_1);
        c.add(RB_2);
        c.add(RB_3);
        this.setVisible(true);

        MyListener l = new MyListener();
        ChekB_1.addItemListener(l);
        ChekB_2.addItemListener(l);
        ChekB_3.addItemListener(l);

        RB_1.addItemListener(l);
        RB_2.addItemListener(l);

        ComboBox.addItemListener(l);

    }

    class MyListener implements ItemListener
    {
        @Override
        public void itemStateChanged(ItemEvent e)
        {
            if(e.getSource() == ChekB_1)
            {
                if(ChekB_1.isSelected())
                {
                    Text.setFont(new Font("bold", Font.BOLD,sizeFront));
                    style = Font.BOLD;
                }else
                {
                    Text.setFont(new Font("italica", Font.PLAIN,sizeFront));
                    style = Font.ITALIC;
                }
            }

            if(e.getSource() == ChekB_2)
            {
                if(ChekB_2.isSelected())
                {
                    if(ChekB_2.isSelected())
                    {
                        Text.setFont(new Font("italica", Font.ITALIC,sizeFront));
                        style = Font.BOLD;
                    }else
                    {
                        Text.setFont(new Font("italica", Font.PLAIN,sizeFront));
                        style = Font.ITALIC;
                    }
                }
            }

            if(e.getSource() == RB_1)
            {
                if(RB_1.isSelected())
                {
                    Text.setFont(new Font("italica",Font.BOLD,12));
                }
            }

            if(e.getSource() == RB_2)
            {
                System.out.println("TEST");
                if(RB_2.isSelected())
                {
                    Text.setFont(new Font("italica",Font.BOLD,20));
                }
            }

            if(e.getSource() == ComboBox)
            {
                int index = ComboBox.getSelectedIndex();
                switch(index)
                {
                    case 0:
                            Text.setForeground(Color.RED);
                            break;
                    case 1:
                            Text.setForeground(Color.GREEN);
                            break;
                    case 2:
                        Text.setForeground(Color.YELLOW);
                            break;
                }
            }
        }
    }

    public static void main(String[] args)
    {
	    new Main();
    }
}
