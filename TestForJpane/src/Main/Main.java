package Main;
import javax.swing.*;
import java.awt.*;

public class Main extends JFrame
{
     private Main()
    {
        super("JPane");
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JButton BN = new JButton("UP");
        panel.add(BN,BorderLayout.NORTH);

        JButton BS = new JButton("DOWN");
        panel.add(BS, BorderLayout.SOUTH);

        JButton BE = new JButton("RIGHT");
        panel.add(BE,BorderLayout.EAST);

        JButton BW = new JButton("LEFT");
        panel.add(BW,BorderLayout.WEST);

        JButton BC = new JButton("SPACE");
        panel.add(BC,BorderLayout.CENTER);

        this.add(panel);
        this.setPreferredSize(new Dimension(500,300));
        this.pack();

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    public static void main(String[] args)
    {
	    //new Main();
        new TestKeyListener();
    }
}
