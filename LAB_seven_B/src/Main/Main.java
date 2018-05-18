package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.prefs.Preferences;

public class Main extends JFrame implements Runnable
{

    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Clipboard clipboard = toolkit.getSystemClipboard();

    private JLabel display;

    private static final String KEY = "key";

    private JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,badd,bdiv,bdel,bmulti,bres;

    private Preferences preferences;

    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem readItem,writeItem;

    private Main()
    {
        this.setTitle("Lab 7 B");
        this.setSize(new Dimension(193,290));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        preferences = Preferences.userRoot().node(this.getClass().getName());

        menuBar = new JMenuBar();
        menu = new JMenu("Result");
        menu.add(readItem = new JMenuItem("Load"));
        menu.add(writeItem = new JMenuItem("Save"));
        menuBar.add(menu);
        this.setJMenuBar(menuBar);

        display = new JLabel("0",SwingConstants.RIGHT);
        display.setFont(new Font("Serif", Font.PLAIN, 20));

        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9= new JButton("9");
        b0 = new JButton("0");
        bdel = new JButton(":");
        bmulti = new JButton("*");
        bdiv = new JButton("-");
        badd = new JButton("+");
        bres = new JButton("=");

        display.setBounds(3,3,180,50);
        b1.setBounds(3,53,45,45);
        b2.setBounds(48,53,45,45);
        b3.setBounds(93,53,45,45);
        badd.setBounds(138,53,45,45);

        b4.setBounds(3,98,45,45);
        b5.setBounds(48,98,45,45);
        b6.setBounds(93,98,45,45);
        bdiv.setBounds(138,98,45,45);

        b7.setBounds(3,143,45,45);
        b8.setBounds(48,143,45,45);
        b9.setBounds(93,143,45,45);
        bmulti.setBounds(138,143,45,45);
        b0.setBounds(3,188,45,45);
        bdel.setBounds(48,188,45,45);
        bres.setBounds(93,188,90,45);

        myListener l = new myListener();

        b1.addActionListener(l);
        b2.addActionListener(l);
        b3.addActionListener(l);
        b4.addActionListener(l);
        b5.addActionListener(l);
        b6.addActionListener(l);
        b7.addActionListener(l);
        b8.addActionListener(l);
        b9.addActionListener(l);
        b0.addActionListener(l);
        badd.addActionListener(l);
        bmulti.addActionListener(l);
        bdel.addActionListener(l);
        bdiv.addActionListener(l);
        bres.addActionListener(l);
        display.addMouseListener(l);

        myListenerForItemMenu k = new myListenerForItemMenu();

        readItem.addActionListener(k);
        writeItem.addActionListener(k);


        this.add(display);
        this.add(b1);
        this.add(b2);
        this.add(b3);
        this.add(badd);
        this.add(b4);
        this.add(b5);
        this.add(b6);
        this.add(bdiv);
        this.add(b7);
        this.add(b8);
        this.add(b9);
        this.add(bmulti);
        this.add(b0);
        this.add(bdel);
        this.add(bres);

        this.setVisible(true);
    }

    public static void main(String[] args)
    {
	// write your code here
        new Thread(new Main()).start();
    }

    @Override
    public void run(){}

    private class myListener implements ActionListener,MouseListener
    {
        int buffer = 0;
        String action = "";

        @Override
        public void actionPerformed(ActionEvent e)
        {
           try
           {
               int number = Integer.parseInt(((JButton)e.getSource()).getText());

               if(display.getText().equals("0")) display.setText(Integer.toString(number));
               else display.setText(display.getText()+number);

           }catch (Exception error)
           {
               if(action.equals(""))
               {
                   buffer = Integer.parseInt(display.getText());
                   display.setText("0");
               }

               switch (action)
               {
                   case "+":
                       display.setText(Integer.toString(buffer + Integer.parseInt(display.getText())));
                       break;
                   case "-":
                       display.setText(Integer.toString(buffer - Integer.parseInt(display.getText())));
                       break;
                   case "*":
                       display.setText(Integer.toString(buffer * Integer.parseInt(display.getText())));
                       break;
                   case ":":
                       if(!display.getText().equals("0")) display.setText(Integer.toString(buffer / Integer.parseInt(display.getText())));
                       else JOptionPane.showMessageDialog(null,"Dividing by zero!");
                       break;
               }
               action = ((JButton)e.getSource()).getText();

           }
        }

        @Override
        public void mouseClicked(MouseEvent e)
        {
            display.setText("0");
            buffer = 0;
            action = "";
        }

        @Override
        public void mousePressed(MouseEvent e) {

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

    private class myListenerForItemMenu implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == writeItem)
            {
                preferences.put(KEY,display.getText());

                StringSelection stringSelection = new StringSelection(display.getText());
                clipboard.setContents(stringSelection,null);

                JOptionPane.showMessageDialog(null,"Preferences is save!");
            }else if(e.getSource() == readItem)
            {
                display.setText(preferences.get(KEY,"0"));
                JOptionPane.showMessageDialog(null,"Preferences is load!");
            }
        }
    }
}