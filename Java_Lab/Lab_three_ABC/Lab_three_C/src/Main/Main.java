package Main;


import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Main extends JFrame {

    Random r = new Random();

    Main()
    {
        this.setTitle("Lab three");
        this.setSize(600,600);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setFont(new Font("TimesRoman", Font.PLAIN,30));
        g.drawString("JAVA",1+r.nextInt(this.getWidth()),1+r.nextInt(this.getHeight()));
        g.drawString("Yurii Alieksieiev 30643 WSINF 2018",10,this.getHeight()-15);
    }

    public static void main(String[] args)
    {
	    new Main();
    }
}
