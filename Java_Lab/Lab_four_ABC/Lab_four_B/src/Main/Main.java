package Main;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame{

   private JRadioButton checkMale = new JRadioButton("Man");
   private JRadioButton checkWomale = new JRadioButton("Woman");

   private JCheckBox check_sport = new JCheckBox("Sport");
   private JCheckBox check_sounds = new JCheckBox("Sounds");
   private JCheckBox check_cooking = new JCheckBox("Cooking");

   private JButton run = new JButton("START");

    private Main()
    {
        this.setTitle("Lab four B");
        this.setSize(115,300);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        JPanel p = new JPanel();
        Dimension sizeP = new Dimension(110,80);
        p.setPreferredSize(sizeP);
        p.setBorder(BorderFactory.createTitledBorder("Coise sex"));
        ButtonGroup group = new ButtonGroup();
        group.add(checkWomale);
        group.add(checkMale);
        p.setLayout(new FlowLayout(FlowLayout.LEFT));
        p.add(checkWomale);
        p.add(checkMale);
        checkWomale.setSelected(true);
        p.setBounds(5,5,sizeP.width,sizeP.height);

        JPanel interests = new JPanel();
        Dimension sizeInterests = new Dimension(110,110);
        interests.setPreferredSize(sizeInterests);
        interests.setLayout(new FlowLayout(FlowLayout.LEFT));

        interests.add(check_sport);
        interests.add(check_sounds);
        interests.add(check_cooking);
        interests.setBorder(BorderFactory.createTitledBorder("Choise hobby"));
        interests.setBounds(5,100,sizeInterests.width,sizeInterests.height);

        run.setBounds(20,220,80,20);
        run.addActionListener(new Listener());

        this.add(run);
        this.add(interests);
        this.add(p);

        JLabel author = new JLabel("Yurii Alieksieiev WSINF 2018");
        author.setFont(new Font("TimesRoman", Font.PLAIN, 8));
        author.setBounds(5,260,110,10);
        this.add(author);

        this.setVisible(true);
    }


    public static void main(String[] args) {
        new Main();
    }

    private class Listener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            String sex = checkMale.isSelected()?"man":"woman";
            String hobby = "";

            if(check_sport.isSelected()) hobby += " sport";
            if(check_cooking.isSelected()) hobby += " cooking";
            if(check_sounds.isSelected()) hobby += " sounds";

            if(hobby.equals(""))
            {
                JOptionPane.showMessageDialog(null,"You are "+sex+" and you have not hobbys:)");
            }else JOptionPane.showMessageDialog(null,"You are "+sex+", you have hobby:"+hobby);
        }
    }
}
