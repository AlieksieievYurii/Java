package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main extends JFrame implements KeyListener{
    private String text="";

    private Main()
    {
        this.setTitle("Lab three(DEL clears display)");
        this.setSize(900,900);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.add(new myPanel());
        this.addKeyListener(this);
    }

    public static void main(String[] args)
    {
        new Main();
    }
    @Override
    public void keyTyped(KeyEvent e)
    {
        System.out.println("OK-->LOG");
        text+=e.getKeyChar();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        System.out.println("OK-->LOG");
        if(e.getKeyCode() == KeyEvent.VK_DELETE) text ="";//If press DELETE display will be clear
        repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    private class myPanel extends JPanel implements MouseListener
    {
        int X = 0;
        int Y = 0;

        myPanel()
        {
            this.setBackground(Color.gray);
            this.addMouseListener(this);
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
            g.setColor(Color.RED);
            g.drawString(text,X,Y);
        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            System.out.println("MOUSE");
            X = e.getX();
            Y = e.getY();
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
    }
}
