package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Main extends JFrame implements Runnable
{
    private static final int FRAME_WIDTH = 155;
    private static final int FRAME_HEIGHT = 340;

    private static final String TEXT_LABEL_HEIGHT = "Height:";
    private static final String TEXT_LABEL_WEIGHT = "Weight:";
    private static final String TEXT_BUTTON_CALCULATE = "Calculate";
    private static final String TEXT_LABEL_RESUALT = "You need to enter data";

    private JTextField txtfHeight,txtfWeight;
    private JLabel lHeighText, lWeightText,lBMIresualts;

    private JButton btnCalculate;

    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem jmiHelp,jmiAbout;

    private InfPanel infPanel;

    @Override
    public void run()
    {
        this.setTitle("BMI");
        this.setSize(new Dimension(FRAME_WIDTH,FRAME_HEIGHT));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        txtfHeight = new JTextField();
        txtfWeight = new JTextField();
        lHeighText = new JLabel(TEXT_LABEL_HEIGHT);
        lWeightText = new JLabel(TEXT_LABEL_WEIGHT);
        btnCalculate = new JButton(TEXT_BUTTON_CALCULATE);
        infPanel = new InfPanel();
        lBMIresualts = new JLabel(TEXT_LABEL_RESUALT);
        lBMIresualts.setHorizontalAlignment(JLabel.CENTER);
        lBMIresualts.setOpaque(true);
        lBMIresualts.setBackground(Color.red);

        jmiAbout = new JMenuItem("About");
        jmiHelp = new JMenuItem("Help");
        menuBar = new JMenuBar();
        menu = new JMenu("App");
        menu.add(jmiAbout);
        menu.add(jmiHelp);

        menuBar.add(menu);
        this.setJMenuBar(menuBar);

        setingPosition();

        myListener l = new myListener();

        btnCalculate.addActionListener(l);
        jmiHelp.addActionListener(l);
        jmiAbout.addActionListener(l);

        this.setVisible(true);
    }

    private void setingPosition()
    {
        lHeighText.setBounds(5,5,40,20);
        txtfHeight.setBounds(45,5,100,20);
        lWeightText.setBounds(5,30,45,20);
        txtfWeight.setBounds(50,30,95,20);
        lBMIresualts.setBounds(5,60,140,30);
        infPanel.setBounds(5,100,140,150);
        btnCalculate.setBounds(5,260,140,20);

        this.add(lHeighText);
        this.add(txtfHeight);
        this.add(lWeightText);
        this.add(txtfWeight);
        this.add(lBMIresualts);
        this.add(infPanel);
        this.add(btnCalculate);
    }



    private class InfPanel extends JPanel
    {
        private float BMI = -1;//Default value for setting default values in panel

        InfPanel()
        {
            this.setOpaque(true);
            this.setBackground(Color.YELLOW);
        }

        public void setBMI(float BMI){
            this.BMI = BMI;
            this.repaint();
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);

            String statusText = "error";

            for(int i = 0; i < 85; i+=4)
            {
                g.drawLine(25,60+i,40,60+i);
            }

            g.setFont(new Font("TimesRoman", Font.PLAIN, 9));
            g.setColor(Color.RED);
            g.drawString("Dead",1,144);
            g.setColor(Color.GREEN);
            g.drawString("Norm",1,112);
            g.setColor(Color.CYAN);
            g.drawString("Aver",1,97);
            g.setColor(Color.ORANGE);
            g.drawString("Impo",1,80);
            g.setColor(Color.RED);
            g.drawString("Dead",1,60);


            switch (findLeavelBMI(BMI))
            {
                case 1:
                    g.setColor(Color.GREEN);
                    statusText = "Normal";
                    break;//Normal
                case 2:
                    g.setColor(Color.YELLOW);
                    statusText = "Average";
                    break;//Average
                case 3:
                    g.setColor(Color.ORANGE);
                    statusText = "Important";
                    break;//Important
                case 4:
                    g.setColor(Color.MAGENTA);
                    statusText = "Severe";
                        break;//Severe
                case 5:
                    g.setColor(Color.RED);
                    statusText = "Dead";
                        break;//Dead
                case 0:
                    g.setColor(Color.GRAY);
                    statusText = "null";
                        break;//Default
            }

            g.fillOval(this.getWidth()/2-25,5,50,50);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 10));
            g.setColor(Color.BLACK);
            g.drawString(statusText,55,65);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
            int cursor = (int) (BMI * 1.9);
            if(BMI != -1 && BMI < 41)g.drawString(BMI+"",this.getWidth()/2-10,35);
            else {
                g.drawString("0.0",this.getWidth()/2-13,35);
                cursor = 0;
            }

            g.fillPolygon(new int[]{45,55,45},new int[]{135-cursor+4,135-cursor+10,135-cursor+10},3);

        }

        private int findLeavelBMI(float bmi)
        {
            if(bmi >= 18.5 && bmi <= 25) return 1;
            else if(bmi > 25 && bmi <= 30) return 2;
            else if(bmi > 30 && bmi <= 40) return 3;
            else if(bmi > 40 || bmi < 18.5 && bmi > 0) return 5;
            else return 0;

            /*
                BMI - 1 = Normal
                BMI - 2 = Avarage
                BMI - 3 = Important
                BMI - 4 = Severe
                BMI - 5 = Dead
                BMI - 0 = IT's for default settings
             */
        }
    }

    private class myListener implements ActionListener
    {

        DecimalFormat twoDForm = new DecimalFormat("#.#");

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == btnCalculate) readAndCalculate();
            else if(e.getSource() == jmiAbout) JOptionPane.showMessageDialog(null,"Yurii Alieksieiev\nWSINF 2018");
            else if(e.getSource() == jmiHelp) JOptionPane.showMessageDialog(null,"If you want to figure out\nyour BMI, you need enter\nweight and heght, next press button\ncalculate!");
        }

        private void readAndCalculate()
        {
            float weight,//in kg
                height;//in sm

            float BMI;

            try
            {
                weight = Integer.parseInt(txtfWeight.getText());
                height = Integer.parseInt(txtfHeight.getText());
            }catch (Exception error)
            {
                error.printStackTrace();
                lBMIresualts.setText(TEXT_LABEL_RESUALT);
                lBMIresualts.setBackground(Color.RED);
                return;
            }

            height /= 100;
            BMI = (weight)/(height*height);

            lBMIresualts.setText("Your BMI is "+Float.valueOf(twoDForm.format(BMI)));
            lBMIresualts.setBackground(Color.GRAY);
            infPanel.setBMI(Float.valueOf(twoDForm.format(BMI)));

            System.out.println(BMI);
        }

    }
    public static void main(String[] args)
    {new Thread(new Main()).start();}
}
