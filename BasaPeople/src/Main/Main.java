package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame
{
    private String[] ArrayCountries = {
            "Ukraine",
            "USA",
            "Poland",
            "China"
    };

    private BasaControl DataBase = new BasaControl();

    private JLabel TextName = new JLabel("Name ");
    private JLabel TextSerName = new JLabel("Sername ");
    private JLabel IDtext = new JLabel("ID ");

    private JCheckBox Student = new JCheckBox("Student");
    private JComboBox Countries = new JComboBox(ArrayCountries);

    private JTextField Name = new JTextField(10);
    private JTextField SerName = new JTextField(10);
    private JTextField ID = new JTextField(10);

    private JButton B_write = new JButton("Write");
    private JButton B_Exit = new JButton("Exit");


    private Main()
    {
        super("Persons");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        JPanel panel = new  JPanel();
        panel.setLayout(new GridLayout(5,2));

        TextName.setHorizontalAlignment(SwingConstants.RIGHT);
        TextSerName.setHorizontalAlignment(SwingConstants.RIGHT);
        IDtext.setHorizontalAlignment(SwingConstants.RIGHT);
        Student.setHorizontalAlignment(SwingConstants.RIGHT);

        panel.add(TextName);
        panel.add(Name);
        panel.add(TextSerName);
        panel.add(SerName);
        panel.add(IDtext);
        panel.add(ID);
        panel.add(Student);
        panel.add(Countries);
        panel.add(B_write);
        panel.add(B_Exit);

        this.add(panel);
        this.pack();

        this.setVisible(true);

        ListenerButton listeneB = new ListenerButton();

        B_write.addActionListener(listeneB);
        B_Exit.addActionListener(listeneB);
    }

    private void WirteDataToBase()
    {
        Peson person = new Peson();
        String NameForm = Name.getText();
        String SerNameForm = SerName.getText();
        String IDForm = ID.getText();
        String CountryForm = ArrayCountries[Countries.getSelectedIndex()];
        Boolean StudentForm = Student.isSelected();

        if(!NameForm.equals(""))
        {
            if(!SerNameForm.equals(""))
            {
                try
                {
                    person.setName(NameForm);
                    person.setSerName(SerNameForm);
                    person.setStudent(StudentForm);
                    person.setCountry(CountryForm);
                    person.setID(Integer.parseInt(IDForm));
                    DataBase.WriteInformation(person);
                }catch(Exception e) {JOptionPane.showMessageDialog(null,"ID should only numbers!");}
            }else JOptionPane.showMessageDialog(null,"Enter surName!");
        }else JOptionPane.showMessageDialog(null,"Enter name!");
    }

    public static void main(String[] args)
    {
	    new Main();
    }

    public class ListenerButton implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == B_write)
               WirteDataToBase();
            if(e.getSource() == B_Exit)
                System.exit(0);
        }
    }

}
