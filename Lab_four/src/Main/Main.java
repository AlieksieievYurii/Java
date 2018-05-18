package Main;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.Buffer;

public class Main extends JFrame implements ActionListener{

    private JLabel JLabelTextName;
    private JLabel JLabelTextAge;

    private JTextField TextFieldName;
    private JTextField TextFieldAge;

    private JButton ButStart;

    Main()
    {
        this.setTitle("Lab four");
        this.setSize(150,130);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setLayout(null);

        JLabelTextName = new JLabel("Name:");
        JLabelTextAge = new JLabel("Age:");

        TextFieldName = new JTextField(10);
        TextFieldAge = new JTextField(10);

        ButStart = new JButton("RUN");

        this.add(JLabelTextName);
        this.add(JLabelTextAge);
        this.add(TextFieldName);
        this.add(TextFieldAge);
        this.add(ButStart);

        JLabelTextName.setBounds(10,10,40,20);
        TextFieldName.setBounds(50,10,80,20);
        JLabelTextAge.setBounds(20,40,30,20);
        TextFieldAge.setBounds(50,40,80,20);
        ButStart.setBounds(60,70,60,20);

        ButStart.addActionListener(this);
    }

    public static void main(String[] args)
    {
        new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
       try
       {
           int age = Integer.parseInt(TextFieldAge.getText());
           if(age < 0) JOptionPane.showMessageDialog(null,"Age can not be less then zero!");
           else if(!TextFieldName.getText().equals(""))
           {
               JOptionPane.showMessageDialog(null,TextFieldName.getText()+" masz ze soban "+ age*365);
           }else JOptionPane.showMessageDialog(null,"Please enter your name!");

       }catch (Exception error)
       {
           JOptionPane.showMessageDialog(null,"\"Age\" must be only number!");
       }
    }
}
