package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame
{

    private DefaultListModel<String> ArrayGoods = new DefaultListModel<>();
    private JList<String> Goods = new JList<>(ArrayGoods);

    private Main()
    {
        this.setTitle("Paragon 2.0");
        this.setSize(new Dimension(250,470));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);

        Goods.setBackground(Color.LIGHT_GRAY);

        myPanelList listPanel = new myPanelList();
        listPanel.setBounds(1,5,245,330);

        myPanelCounting contPanel = new myPanelCounting();
        contPanel.setBounds(1,340,245,100);

        this.add(listPanel);
        this.add(contPanel);

        this.setVisible(true);
    }

    private class myPanelList extends JPanel implements ActionListener
    {

        private JTextField TextFieldPrice = new JTextField(10);
        private JTextField TextFieldNameGood = new JTextField(10);
        private JTextField TextfieldNumberGood = new JTextField(10);

        private JLabel Text_nameGood = new JLabel("Name good:");
        private JLabel Text_price = new JLabel("Price:");
        private JLabel Text_number = new JLabel("Number:");

        private JButton addButton = new JButton("Add");
        private  JButton removeButton = new JButton("Remove");

           myPanelList()
           {
               this.setBorder(BorderFactory.createTitledBorder("List of goods"));
               this.setBackground(Color.GRAY);
               this.setLayout(null);

               JScrollPane scroll = new JScrollPane();

               scroll.setViewportView(Goods);
               scroll.setBounds(5,20,235,150);

               Text_nameGood.setBounds(scroll.getX(),scroll.getY()+scroll.getHeight()+5,70,20);
               TextFieldNameGood.setBounds(Text_nameGood.getX()+Text_nameGood.getWidth(),Text_nameGood.getY(),100,20);

               Text_price.setBounds(Text_nameGood.getX(),TextFieldNameGood.getY()+25,35,20);
               TextFieldPrice.setBounds(Text_price.getX()+Text_price.getWidth(),Text_price.getY(),135,20);

               Text_number.setBounds(Text_price.getX(),TextFieldPrice.getY()+25,50,20);
               TextfieldNumberGood.setBounds(Text_number.getX()+Text_number.getWidth(),Text_number.getY(),120,20);

               addButton.setBounds(70,TextfieldNumberGood.getY()+30,100,30);
               removeButton.setBounds(70,addButton.getY()+35,100,30);

               this.add(scroll);
               this.add(Text_nameGood);
               this.add(TextFieldNameGood);
               this.add(Text_price);
               this.add(TextFieldPrice);
               this.add(Text_number);
               this.add(TextfieldNumberGood);
               this.add(addButton);
               this.add(removeButton);

               addButton.addActionListener(this);
               removeButton.addActionListener(this);
           }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            String nameGood;
            int numGood;
            int priceGood;

            if(e.getSource() == addButton)
            {
                nameGood = TextFieldNameGood.getText();

                if(nameGood.equals(""))
                {
                    JOptionPane.showMessageDialog(null,"Enter name of good!");
                    return;
                }

                try
                {
                    priceGood = Integer.parseInt(TextFieldPrice.getText());

                }catch (Exception error)
                {
                    JOptionPane.showMessageDialog(null,"Enter price of good, only number!");
                    return;
                }

                if(priceGood < 0)
                {
                    JOptionPane.showMessageDialog(null,"Price can't be less zero!");
                    return;
                }

                try
                {
                    numGood = Integer.parseInt(TextfieldNumberGood.getText());

                }catch(Exception error)
                {
                    JOptionPane.showMessageDialog(null,"Enter number of goods, only number!");
                    return;
                }

                if(numGood < 0)
                {
                    JOptionPane.showMessageDialog(null,"Number of goods can't be less zero!");
                    return;
                }

                ArrayGoods.addElement(nameGood +"   "+ priceGood +" $" + "  " +numGood);

                TextFieldNameGood.setText("");
                TextfieldNumberGood.setText("");
                TextFieldPrice.setText("");
            }else if(e.getSource() == removeButton)
            {
                try {
                    ArrayGoods.remove(Goods.getSelectedIndex());
                }catch (Exception error)
                {
                    JOptionPane.showMessageDialog(null,"Choise element for removing!");
                }
            }
        }
    }

    private class myPanelCounting extends JPanel implements ActionListener
    {
        private JLabel Text_podatok = new JLabel("Podatok:");
        private JTextField TextFieldPodatok = new JTextField(10);

        private JButton CountButton = new JButton("Count");

        myPanelCounting()
        {
            this.setBorder(BorderFactory.createTitledBorder("Paragon"));
            this.setBackground(Color.GRAY);
            this.setLayout(null);

            Text_podatok.setBounds(10,20,60,20);
            TextFieldPodatok.setBounds(Text_podatok.getWidth() + Text_podatok.getX(), Text_podatok.getY(),140,20);

            CountButton.setBounds(70,TextFieldPodatok.getY()+TextFieldPodatok.getHeight()+10,100,20);

            this.add(Text_podatok);
            this.add(TextFieldPodatok);
            this.add(CountButton);

            CountButton.addActionListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            float podatok;
            int mainSumma = 0;
            if(e.getSource() ==CountButton)
            {
                StringBuilder mainText = new StringBuilder();
                mainText.append("ORDER   PRICE   NUMBER   ALL_PRICE  \n");
                try
                {
                    podatok = Float.parseFloat(TextFieldPodatok.getText());
                }catch (Exception error)
                {
                    JOptionPane.showMessageDialog(null,"Enter podatok, only numbers");
                    return;
                }
                    mainText.append("------------------------------------------------------\n");
                for(int i = 0; i < ArrayGoods.getSize(); i++)
                {
                    String[] array = ArrayGoods.getElementAt(i).split(" {2}");

                    int suuma = Integer.parseInt(array[1].replaceAll("\\D+","")) * Integer.parseInt(array[2]);

                    mainText.append("      ").append(array[0]).append("   ").append(array[1].replaceAll("\\D+", "")).append("   ").append(array[2]).append("   ").append(suuma).append("\n");

                    mainSumma += suuma;
                }

                mainText.append("------------------------------------------------------\n");
                mainText.append(" Yurii Alieksieiev ## SUMMA: ").append(mainSumma).append(" $\n");
                mainText.append("WITH PODATOK: ").append(String.format("%.2f", mainSumma * podatok / 100)).append(" $");
                JOptionPane.showMessageDialog(null, mainText.toString());
            }
        }
    }

    public static void main(String[] args)
    {
	    new Main();
    }
}
