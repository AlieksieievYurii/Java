package Main;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main extends JFrame implements Runnable{

    private JTextArea combination;
    private JButton btnNext,btnLast;
    private JLabel textEnter;
    private JTextField textField;

    private JScrollPane scroll;

    private ArrayList<String> values;
    private int index = 0;

    @Override
    public void run()
    {
        this.setTitle("Lab 8 B");
        this.setSize(new Dimension(100,250));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);

        values = new ArrayList<>();

        combination = new JTextArea();
        btnLast = new JButton("<");
        btnNext = new JButton(">");
        textEnter = new JLabel("Enter sum:");
        textField = new JTextField();

        scroll = new JScrollPane(combination);

        scroll.setBounds(5,5,100,140);
        textEnter.setBounds(20,145,100,20);
        textField.setBounds(5,165,100,20);
        btnLast.setBounds(5,185,50,20);
        btnNext.setBounds(55,185,50,20);

        this.add(scroll);
        this.add(textEnter);
        this.add(textField);
        this.add(btnLast);
        this.add(btnNext);

        myListener l = new myListener();
        textField.getDocument().addDocumentListener(l);

        btnLast.addActionListener(l);
        btnNext.addActionListener(l);


        this.setVisible(true);
    }

    public static void main(String[] args) {
	// write your code here
        new Thread(new Main()).start();
    }

    private void nextFun()
    {
        try
        {
            if(index+1 != values.size())index++;
            combination.setText(values.get(index));
        }catch (Exception e){};

    }

    private void lastFun()
    {
        try
        {
            if(index-1 != -1)index--;
            combination.setText(values.get(index));
        }catch (Exception e){};
    }

    private void runAlgorytm()
    {
        int number;
        int[] money = {1,2,5};

        try
        {
            number = Integer.parseInt(textField.getText());
        }catch (Exception error)
        {
            JOptionPane.showMessageDialog(null,"Enter only number!");
            return;
        }
        values.removeAll(values);
        int oneSize = number/money[0];
        int twoSize = number/money[1];
        int threeSize = number/money[2];

        for(int oneNum = 0; oneNum <= oneSize; oneNum++)
        {
            for(int twoNum = 0; twoNum <= twoSize; twoNum++)
            {
                for(int threeNum = 0; threeNum <= threeSize; threeNum++)
                {
                    if(oneNum + twoNum*2 + threeNum*5 == number)
                    {
                        StringBuilder res = new StringBuilder();

                        for(int o = 0; o < oneNum; o++)
                        {
                            res.append("1\n");
                        }

                        for(int o = 0; o < twoNum; o++)
                        {
                            res.append("2\n");
                        }
                        for(int o = 0; o < threeNum; o++)
                        {
                            res.append("5\n");
                        }

                        values.add(res.toString());
                    }
                }
            }
        }

        combination.setText(values.get(0));
    }

    private class myListener implements DocumentListener,ActionListener
    {

        @Override
        public void insertUpdate(DocumentEvent e) {
            runAlgorytm();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            runAlgorytm();
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == btnLast) lastFun();
            else if(e.getSource() == btnNext)nextFun();

        }
    }

}
