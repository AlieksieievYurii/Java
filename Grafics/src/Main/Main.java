package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Main extends JFrame{

    JButton b = new JButton("RUN");

    JPanel panel;
    JLabel text;

    private int Xclick;
    private int Yclick;

    private int Random_X;
    private int Random_Y;

    private int Number = 1;

    private String coordinats = "";

    public Main(int width, int height)
    {
        this.setSize(new Dimension(width,height));
        this.setTitle("test 1.0");
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        Xclick = this.getWidth() / 2;
        Yclick = this.getHeight() / 2;

        this.addWindowListener(new windowListener());
        this.addMouseListener(new mouseListener());
        this.addKeyListener(new keyListener());
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawString("Table of multi:",Xclick,Yclick);

        int K = 0;


            for(int h = 1; h <= 9; h++)
                g.drawString( Number +" * "+h+" = "+Number*h,Xclick,Yclick+(K+=13));
    }

    public static void main(String[] args)
    {
        new Main(300,300);
    }

    private class windowListener extends WindowAdapter
    {
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

    private class mouseListener extends MouseAdapter
    {
        @Override
        public void mousePressed(MouseEvent e)
        {
            Xclick = e.getX();
            Yclick = e.getY();

            coordinats = "X:" + Xclick + " Y:" + Yclick;
            repaint();
        }
    }

    private class keyListener extends KeyAdapter
    {
        @Override
        public void keyPressed(KeyEvent e) {
            try
            {
                Number = Integer.parseInt(Character.toString(e.getKeyChar()));
            }catch (Exception error){Number = 1;}
            repaint();
        }
    }

}
