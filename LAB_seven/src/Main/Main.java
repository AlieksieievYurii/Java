package Main;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements Runnable
{
    private JCheckBoxMenuItem chbmiBackround;
    private JMenu menuOne,menuTwo,menuThree,menuItemForMenuThree;
    private JMenuBar menuBar;
    private JMenuItem itemItemOne,itemItemTwo,itemItemThree,itemItemFour;

    private JButton btn;
    private JTextField txf;
    private JLabel lb;

    private ButtonGroup bgForRadioButtons;
    private JRadioButton rdbOne;
    private JRadioButton rdbTwo;

    private JCheckBox chb;

    private JPanel panelInf;

    private JLabel lInfButton;
    private JLabel lInfCheckBox;
    private JLabel lInfRadioButton;
    private JLabel lInfTextField;
    private JLabel lInfBLabel;
    private JLabel lInfItem,lInfItemBackground, lInfJList;

    private JList<String> list;

    private int
            countButton = 0,
            countRadioButton = 0,
            countCheckBox = 0,
            countTextField = 0,
            countLabel = 0,
            countMenuItem = 0,
            countMenuCheckBox = 0,
            countJList = 0;

    private Main()
    {
        this.setTitle("Lab 7");
        this.setSize(new Dimension(250,260));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);

        menuOne = new JMenu("Left");
        menuBar = new JMenuBar();
        menuOne.add(itemItemOne = new JMenuItem("Item One"));
        menuOne.add(itemItemTwo = new JMenuItem("Item Two"));

        menuTwo = new JMenu("Center");
        menuTwo.add(chbmiBackround = new JCheckBoxMenuItem("Background"));

        menuThree = new JMenu("Right");
        menuItemForMenuThree = new JMenu("More...");
        menuItemForMenuThree.add(itemItemThree = new JMenuItem("Item Three"));
        menuItemForMenuThree.add(itemItemFour = new JMenuItem("Item Four"));
        menuThree.add(menuItemForMenuThree);

        menuBar.add(menuOne);
        menuBar.add(menuTwo);
        menuBar.add(menuThree);

        this.setJMenuBar(menuBar);

        panelInf = new JPanel();
        TitledBorder titledBorder = BorderFactory.createTitledBorder("Information");
        panelInf.setBorder(titledBorder);

        list = new JList<>(new String[]{"Test one","Test two","Test three","Test four","Test five","Test six"});
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setVisibleRowCount(-1);

        JScrollPane listscroll = new JScrollPane(list);
        listscroll.setBounds(110,150,120,40);

        btn = new JButton("Click");
        txf = new JTextField("Click");
        lb = new JLabel("Click");
        bgForRadioButtons = new ButtonGroup();
        rdbOne = new JRadioButton("Click A");
        rdbTwo = new JRadioButton("Click B");
        bgForRadioButtons.add(rdbOne);
        bgForRadioButtons.add(rdbTwo);
        chb = new JCheckBox("Click");

        lInfButton = new JLabel("Button: 0");
        lInfBLabel = new JLabel("Label: 0");
        lInfCheckBox = new JLabel("CheckBox: 0");
        lInfRadioButton = new JLabel("RadioButton: 0");
        lInfTextField = new JLabel("TextField: 0");

        lInfItem = new JLabel("Items: 0");
        lInfItemBackground = new JLabel("Item background: 0");
        lInfJList = new JLabel("List: 0");

        panelInf.setLayout(null);

        Font fontDefault = new Font("Serif", Font.PLAIN, 10);

        lInfButton.setFont(fontDefault);
        lInfTextField.setFont(fontDefault);
        lInfRadioButton.setFont(fontDefault);
        lInfCheckBox.setFont(fontDefault);
        lInfBLabel.setFont(fontDefault);
        lInfItem.setFont(fontDefault);
        lInfItemBackground.setFont(fontDefault);
        lInfJList.setFont(fontDefault);

        lInfButton.setBounds(5,10,100,20);
        lInfTextField.setBounds(5,25,100,20);
        lInfBLabel.setBounds(5,40,100,20);
        lInfRadioButton.setBounds(5,55,100,20);
        lInfCheckBox.setBounds(5,70,100,20);
        lInfItem.setBounds(5,85,100,20);
        lInfItemBackground.setBounds(5,100,115,20);
        lInfJList.setBounds(5,115,100,20);

        panelInf.add(lInfButton);
        panelInf.add(lInfTextField);
        panelInf.add(lInfBLabel);
        panelInf.add(lInfRadioButton);
        panelInf.add(lInfCheckBox);
        panelInf.add(lInfItem);
        panelInf.add(lInfItemBackground);
        panelInf.add(lInfJList);

        btn.setBounds(10,10,100,20);
        txf.setBounds(10,40,100,20);
        lb.setBounds(10,70,100,20);
        lb.setOpaque(true);
        lb.setBackground(Color.YELLOW);
        rdbOne.setBounds(10,100,100,20);
        rdbTwo.setBounds(10,130,100,20);
        chb.setBounds(10,160,100,20);
        panelInf.setBounds(130,3,100,140);


        this.add(btn);
        this.add(txf);
        this.add(lb);
        this.add(rdbOne);
        this.add(rdbTwo);
        this.add(chb);
        this.add(panelInf);
        this.add(listscroll);

        myListener l = new myListener();

        btn.addMouseListener(l);
        rdbOne.addMouseListener(l);
        rdbTwo.addMouseListener(l);
        chb.addMouseListener(l);
        txf.addMouseListener(l);
        lb.addMouseListener(l);
        itemItemOne.addActionListener(l);
        itemItemTwo.addActionListener(l);
        itemItemThree.addActionListener(l);
        itemItemFour.addActionListener(l);
        chbmiBackround.addActionListener(l);
        list.addMouseListener(l);

        JLabel about = new JLabel("Yurii Alieksieiev WSINF 2018");
        about.setBounds(10,190,200,20);
        this.add(about);

        this.setVisible(true);
    }

    private void upDateInf()
    {
        lInfButton.setText(String.format("Button: %d",countButton));
        lInfRadioButton.setText(String.format("RadioButton: %d",countRadioButton));
        lInfCheckBox.setText(String.format("CheckBox: %d",countCheckBox));
        lInfTextField.setText(String.format("TextField: %d",countTextField));
        lInfBLabel.setText(String.format("Label: %d",countLabel));
        lInfItem.setText(String.format("Items: %d",countMenuItem));
        lInfItemBackground.setText(String.format("Item background: %d",countMenuCheckBox));
        lInfJList.setText(String.format("List: %d",countJList));
    }


    public static void main(String[] args)
    {
	// write your code here
        new Thread(new Main()).start();
    }

    @Override
    public void run(){}

    private class myListener extends MouseAdapter implements ActionListener
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            if(e.getSource() instanceof JButton) countButton++;
            else if(e.getSource() instanceof JTextField) countTextField++;
            else if(e.getSource() instanceof JRadioButton) countRadioButton++;
            else if(e.getSource() instanceof JCheckBox) countCheckBox++;
            else if(e.getSource() instanceof  JLabel) countLabel++;
            else if(e.getSource() instanceof  JMenuItem) countMenuItem++;
            else if(e.getSource() instanceof JList) countJList++;

            upDateInf();
        }

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == chbmiBackround)
            {
                countMenuCheckBox++;
                if(((JCheckBoxMenuItem)e.getSource()).getState()) Main.this.getContentPane().setBackground(Color.YELLOW);
                else Main.this.getContentPane().setBackground(Color.WHITE);
            }
            if(e.getSource() instanceof JMenuItem) countMenuItem++;

            upDateInf();
        }
    }
}
