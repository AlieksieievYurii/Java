package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Difficals extends JFrame
{
    private final JButton ButtonStart = new JButton("Run");
    private final TextField MinLabel = new TextField(5);
    private final TextField MaxLabel = new TextField(5);
    private final TextField Leavels = new TextField(5);
    private final JLabel MinText = new JLabel("             Minimum:");
    private final JLabel MaxText = new JLabel("  Maxumum:");
    private final JLabel LeavelsText = new JLabel("How many leavels:");

    public Difficals()
    {
        super("DIfficults");
        this.setSize(200,160);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container cont = getContentPane();
        cont.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));

        cont.add(LeavelsText);
        cont.add(Leavels);
        cont.add(MinText);
        cont.add(MinLabel);
        cont.add(MaxText);
        cont.add(MaxLabel);
        cont.add(ButtonStart);

        this.setVisible(true);

        ButtonStart.addActionListener(new Listener());
    }

    private void close()
    {
        this.setVisible(false);
    }

    class Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
          try
          {
              int minArg = Integer.parseInt(MinLabel.getText());
              int maxArg = Integer.parseInt(MaxLabel.getText());
              int leavel = Integer.parseInt(Leavels.getText());

              if(leavel == 0)JOptionPane.showMessageDialog(null,"Leavels can not be zero!");
              else {
                  if(maxArg <= minArg) JOptionPane.showMessageDialog(null,"Minimum can not be more then maximum!");
                  else {
                      new Main(leavel, minArg, maxArg);
                      close();
                  }
              }
          }catch (Exception error)
          {
              JOptionPane.showMessageDialog(null,"Enter only numbers!");
          }
        }
    }

}
