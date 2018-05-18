package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Grafica extends JFrame
{

    private panelButtons panel = new panelButtons();
    private MyPanel paint = new MyPanel();

    private String day,date,nowTemperatyre;
    private String[] minMax;

    public Grafica(String day, String date, String nowTemperatyre, String[] minMax)
    {

        this.day = day;
        this.date = date;
        this.nowTemperatyre = nowTemperatyre;
        this.minMax = minMax;

        this.setSize(new Dimension(420,400));
        this.setTitle("Weather 1.0");
        this.setResizable(false);
        this.getContentPane().setLayout(new FlowLayout());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.add(panel);
        this.add(paint);

    }

    class MyPanel extends JPanel implements MouseListener
    {
       MyPanel()
        {
            this.setPreferredSize(new Dimension(310,400));
            this.setBackground(Color.LIGHT_GRAY);

            this.addMouseListener(this);
        }

        public void mouseClicked(MouseEvent e) {

        }

        public void mousePressed(MouseEvent e) {
            Graphics g = paint.getGraphics();
            g.drawString(day,e.getX(),e.getY());
            g.drawString(date,e.getX(),e.getY()+15);
            g.drawString(nowTemperatyre,e.getX(),e.getY()+30);
            g.drawString(minMax[0]+"..."+minMax[1],e.getX(),e.getY()+45);
            g.dispose();
            this.paint(g);

        }

        public void mouseReleased(MouseEvent e) {

        }

        public void mouseEntered(MouseEvent e) {

        }

        public void mouseExited(MouseEvent e) {

        }
    }

    class panelButtons extends JPanel
    {
        private JButton button;
        panelButtons()
        {
            this.setPreferredSize(new Dimension(90,400));
            button = new JButton("CLEAR");
            this.setLayout(new FlowLayout());
            this.add(button);

            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    paint.removeAll();
                    paint.updateUI();
                }
            });
        }
    }
}
