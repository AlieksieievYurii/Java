package Main;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Okno extends JFrame
{

    protected final int widthText = 40;
    protected final int heightText = 10;
    JPanel p = new JPanel();
    JLabel text = new JLabel("TEXT");
    Random r = new Random();

    public Okno()
    {
        super("Test");
        this.setSize(new Dimension(300,300));

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        p.setBackground(Color.RED);
        this.setVisible(true);
        this.add(p);

        Timer t = new Timer();
        t.schedule(new TimerTask() {
            @Override
            public void run()
            {
                repaint();
            }
        },0,1000);
    }

    public void paint(Graphics g)
    {
        p.setBackground(Color.RED);
        g.drawString("text",r.nextInt(200),r.nextInt(200));
    }
}