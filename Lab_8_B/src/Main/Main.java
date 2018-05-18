package Main;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame implements Runnable{

    private JTextArea combination;
    private JButton btnNext,btnLast;
    private JLabel textEnter;
    private JTextField textField;

    @Override
    public void run()
    {
        this.setTitle("Lab 8 B");
        this.setSize(new Dimension(100,250));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);

        combination = new JTextArea();
        btnLast = new JButton("<");
        btnNext = new JButton(">");
        textEnter = new JLabel("Enter sum:");
        textField = new JTextField();

        combination.setBounds(5,5,100,140);
        textEnter.setBounds(20,145,100,20);
        textField.setBounds(5,165,100,20);
        btnLast.setBounds(5,185,50,20);
        btnNext.setBounds(55,185,50,20);

        this.add(combination);
        this.add(textEnter);
        this.add(textField);
        this.add(btnLast);
        this.add(btnNext);


        this.setVisible(true);
    }

    public static void main(String[] args) {
	// write your code here
        new Thread(new Main()).start();
    }


}
