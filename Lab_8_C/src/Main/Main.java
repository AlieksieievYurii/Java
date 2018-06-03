package Main;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DecimalFormat;

public class Main extends JFrame implements Runnable
{
    private JTextField edtFare,edtCelc;
    private JLabel lFare,lCelc;

    @Override
    public void run()
    {
        this.setTitle("Lab 8 C");
        this.setSize(new Dimension(100,80));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);

        edtFare = new JTextField();
        edtCelc = new JTextField();
        lFare = new JLabel("Fahrenheit");
        lCelc = new JLabel("Celsius ");

        lFare.setBounds(2,2,60,20);
        edtFare.setBounds(2,25,60,20);
        lCelc.setBounds(67,2,50,20);
        edtCelc.setBounds(67,25,50,20);

        listener l = new listener();
        edtCelc.getDocument().addDocumentListener(l);
        edtFare.getDocument().addDocumentListener(l);
        edtFare.addFocusListener(l);
        edtCelc.addFocusListener(l);

        this.add(lFare);
        this.add(edtFare);
        this.add(lCelc);
        this.add(edtCelc);
        this.setVisible(true);
    }

    private double convertFahrenheitToCelsius(double Fahrenheit)
    {
        return 0.5*(Fahrenheit-32);
    }

    private double convertCelsiusToFahrenheit(double Celsius)
    {
        return 32 + 0.5*Celsius;
    }

    private void engine(DocumentEvent e, boolean focusOnCelsius)
    {
        DecimalFormat df = new DecimalFormat("###.#");

        if(e.getDocument() == edtCelc.getDocument() && focusOnCelsius)
        {
            try {
                double Celsius = Double.parseDouble(edtCelc.getText());
                double Fahrenheit = convertCelsiusToFahrenheit(Celsius);
                edtFare.setText(df.format(Fahrenheit));
            }catch (Exception error)
            {
                edtFare.setText("");
            }
        }else if(e.getDocument() == edtFare.getDocument() && !focusOnCelsius)
        {
            try
            {
                double Fahrenheit = Double.parseDouble(edtFare.getText());
                double Celsius = convertFahrenheitToCelsius(Fahrenheit);
                edtCelc.setText(df.format(Celsius));
            }catch (Exception error){
                edtCelc.setText("");
            }
        }
    }

    public static void main(String[] args) {
	// write your code here
        new Thread(new Main()).start();
    }

    private class listener implements DocumentListener,FocusListener
    {

        boolean focusOnCelsius = true;

        @Override
        public void insertUpdate(DocumentEvent e)
        {
            engine(e,focusOnCelsius);
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            engine(e,focusOnCelsius);
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            engine(e,focusOnCelsius);
        }

        @Override
        public void focusGained(FocusEvent e) {
            if(e.getSource() == edtCelc)
            {
                focusOnCelsius = true;
            }else if(e.getSource() == edtFare)
            {
                focusOnCelsius = false;
            }
        }

        @Override
        public void focusLost(FocusEvent e) {
        }
    }
}
