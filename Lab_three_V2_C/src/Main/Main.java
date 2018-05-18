package Main;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends JFrame{

    Random r = new Random();

    Main()
    {
        this.setSize(600,600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Lab 3.2 C");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run()
            {
                repaint();
            }
        },0,5000);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setFont(new Font("TimesRoman", Font.PLAIN,30));
        g.setColor(Color.blue);
        g.drawString("WSINF",r.nextInt(this.getWidth())+1,r.nextInt(this.getHeight())+1);
        g.setFont(new Font("TimesRoman", Font.PLAIN,10));
        g.drawString("Yurii Alieksieiev 30643 WSINF 2018",10,this.getHeight() - 15);
    }

    public static void main(String[] args) {
        new Main();
    }
}
