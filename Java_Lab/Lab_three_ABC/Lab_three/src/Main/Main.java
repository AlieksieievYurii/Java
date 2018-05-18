package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main extends JFrame{

    Main()
    {
        this.setTitle("Tablica mnorzenia");
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.add(new myPanel());
    }

    public static void main(String[] args)
    {
        new Main();
    }

    private class myPanel extends JPanel implements MouseListener
    {
        int X = 0;
        int Y = 0;

        myPanel()
        {
            this.setBackground(Color.GRAY);
            this.addMouseListener(this);
        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e)
        {
            X = e.getX();
            Y  = e.getY();
            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);

            int KX = 0;//Variables for margin
            int KY = 0;

            for(int x = 1; x < 10; x++)
            {
                for(int y = 1; y < 10; y++)
                {
                    g.drawString(x + "*" + y +"=" + x*y,X+KX,Y+KY);//By each clock i change K of coordinats for print table
                    KX += 50;
                }
                KX = 0;
                KY += 15;
            }

            g.drawString("Yurii Alieksieiev 30643 WSINF 2018",10,this.getHeight()-20);
        }
    }
}
