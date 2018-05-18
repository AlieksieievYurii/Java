package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main extends JFrame
{
    private int X = 0,Y = 0;
    private myPanel panel;

    public Main(String title, int width, int height)
    {

        panel = new myPanel(Color.RED);

        this.setTitle(title);
        this.setSize(new Dimension(width,height));
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        this.addWindowListener(new myListenerWindow());
        panel.addMouseListener(new myListenerMouse());
        this.getContentPane().setLayout(new FlowLayout());

        this.add(panel);

    }

    public static void main(String[] args)
    {
        new Main("Test",400,400);
    }

    public class myListenerWindow extends WindowAdapter
    {
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

    public class myListenerMouse extends MouseAdapter
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            X = e.getX();
            Y = e.getY();
            panel.repaint();
        }
    }

    private class myPanel extends JPanel{

        public myPanel(Color color)
        {
            //this.setPreferredSize(new Dimension(150,150));
            this.setBackground(color);
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.drawRect(X,Y,20,20);
        }
    }
}
