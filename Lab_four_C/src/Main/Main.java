package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame{

    private String[] names = new String[]{
            "Ura",
            "Ania",
            "Artyr",
            "Nazar",
            "Andrej",
            "Pidar",
            "Denys",
            "Vlad"
    };

    private DefaultListModel<String> modelList = new DefaultListModel<>();
    private DefaultListModel<String> modelForCombo = new DefaultListModel<>();

    private JList<String> list = new JList<>(modelList);
    private JComboBox<String> combo = new JComboBox<String>();
    private JButton ButtonAdd = new JButton("Add");
    private JButton ButtonRewrite = new JButton("Rewrite");
    private JTextField textField = new JTextField(10);

    private Main()
    {
        this.setTitle("Lab four C");
        this.setSize(250,220);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        for(String s : names)
        {
            modelList.addElement(s);
        }

        JScrollPane scrol = new JScrollPane();
        scrol.setViewportView(list);
        this.add(scrol);
        scrol.setBounds(5,5,120,100);

        this.add(textField);
        textField.setBounds(10,110,110,20);

        this.add(ButtonAdd);
        ButtonAdd.setBounds(15,135,100,30);

        this.add(combo);
        combo.setBounds(130,5,100,20);

        this.add(ButtonRewrite);
        ButtonRewrite.setBounds(130,40,100,20);

        Listener l = new Listener();
        ButtonAdd.addActionListener(l);
        ButtonRewrite.addActionListener(l);


        JLabel author = new JLabel("Yurii Alieksieiev 30643 WSINF 2018");
        author.setFont(new Font("TimesRoman", Font.PLAIN, 9));
        author.setBounds(10,this.getHeight()-40,170,10);
        this.add(author);

        this.setVisible(true);
    }

    public static void main(String[] args) {
	// write your code here
        new Main();
    }

    private class Listener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
           if(e.getSource() == ButtonAdd)
           {
               String text = textField.getText();
               if(text.equals(""))
               {
                   JOptionPane.showMessageDialog(null,"Plese, enter name!");
               }else
               {
                   modelList.addElement(text);
                   textField.setText("");
               }
           }else if(e.getSource() == ButtonRewrite)
           {
               String textCombo = list.getSelectedValue();
               if(textCombo == null)
               {
                   JOptionPane.showMessageDialog(null,"Choise item!");
               }else
               {
                   combo.addItem(textCombo);
               }
           }
        }
    }
}
