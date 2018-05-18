package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Executable;
import java.net.Inet4Address;

public class Main extends JFrame
{

    private JLabel textPetrol = new JLabel("Petrol:");
    private JLabel textGas = new JLabel("Gas:");
    private JLabel textInstallGas = new JLabel("Price install gas:");
    private JLabel textGasOn100Km = new JLabel("Lit gas on 100 km:");
    private JLabel textResualt = new JLabel("RES:");
    private JLabel author = new JLabel("Yurii Alieksieiev 30643 WSINF 2018");

    private JTextField TextFieldPetrol = new JTextField(10);
    private JTextField TextFieldGas = new JTextField(10);
    private JTextField TextFieldInstallGas = new JTextField(10);
    private JTextField TextFieldLiitersGasOn100Km = new JTextField(10);

    private JButton ButtonRun = new JButton("Num");


    private Main()
    {
        this.setTitle("Lab 5");
        this.setSize(200,230);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        textPetrol.setBounds(10,10,50,20);
        TextFieldPetrol.setBounds(50,10,130,20);
        textGas.setBounds(20,35,40,20);
        TextFieldGas.setBounds(50,textGas.getY(),130,20);
        textInstallGas.setBounds(2,60,100,20);
        TextFieldInstallGas.setBounds(100,textInstallGas.getY(),80,20);
        textGasOn100Km.setBounds(2,85,110,20);
        TextFieldLiitersGasOn100Km.setBounds(110,textGasOn100Km.getY(),70,20);
        textResualt.setBounds(5,150,180,20);

        author.setBounds(5,this.getHeight() - 40,150,10);
        author.setFont(new Font("TimesRoman", Font.PLAIN, 8));

        ButtonRun.setBounds(60,120,80,20);

        this.add(textPetrol);
        this.add(TextFieldPetrol);
        this.add(textGas);
        this.add(TextFieldGas);
        this.add(textInstallGas);
        this.add(TextFieldInstallGas);
        this.add(textGasOn100Km);
        this.add(TextFieldLiitersGasOn100Km);
        this.add(ButtonRun);
        this.add(textResualt);
        this.add(author);

        ButtonRun.addActionListener(new myListener());

        this.setVisible(true);
    }

    private class myListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            float     priceGas = 0,
                    pricePetrol = 0,
                    priceInstallGas = 0,
                    litersOn100Km = 0;

            try
            {
                pricePetrol = Float.parseFloat(TextFieldPetrol.getText());

            }catch (Exception error)
            {
                JOptionPane.showMessageDialog(null,"Please enter price of petrol!");
                return;
            }

            try
            {
                priceGas = Float.parseFloat(TextFieldGas.getText());

            }catch(Exception error)
            {

                JOptionPane.showMessageDialog(null,"Please enter price of gas!");
                return;
            }

            try
            {
                priceInstallGas = Float.parseFloat(TextFieldInstallGas.getText());

            }catch(Exception error)
            {

                JOptionPane.showMessageDialog(null,"Please enter price of installing gas!");
                return;
            }

            try
            {
                litersOn100Km = Float.parseFloat(TextFieldLiitersGasOn100Km.getText());

            }catch (Exception error)
            {

                JOptionPane.showMessageDialog(null,"Please enter liters on 100 km!");
                return;
            }

            float res = priceInstallGas/((litersOn100Km*priceGas)/100);
            textResualt.setText(String.format("RES: %.1f KM",res));

        }
    }

    public static void main(String[] args) {
	// write your code here
        new Main();
    }
}
