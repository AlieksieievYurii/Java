package Main;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame
{

    private Main()
    {
        this.setTitle("Lab six");
        this.setSize(300,330);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);


        final JTextArea textAreaFromFile = new JTextArea();
        final JButton buttonReadFromFile = new JButton("Read from file");
        final JTextField textFieldNumberLine = new JTextField(10);
        final JLabel labelForTextFieldNumberLine = new JLabel("Line:");
        final JTextArea textAreaToFile = new JTextArea();
        final JButton buttonWriteToFile = new JButton("Write to file");

        final JScrollPane scrollBar = new JScrollPane(textAreaFromFile);
        final JScrollPane scrollPane =  new JScrollPane(textAreaToFile);
        final JScrollBar scrollLine = new JScrollBar();

        scrollBar.setBounds(1,1,this.getWidth(),100);
        buttonReadFromFile.setBounds(75,110,150,30);
        textFieldNumberLine.setBounds(150,150,100,20);
        labelForTextFieldNumberLine.setBounds(120,150,50,20);
        scrollLine.setBounds(249,150,30,20);
        scrollPane.setBounds(20,180,260,70);
        buttonWriteToFile.setBounds(75,260,150,30);

        this.add(buttonWriteToFile);
        this.add(scrollPane);
        this.add(scrollLine);
        this.add(labelForTextFieldNumberLine);
        this.add(textFieldNumberLine);
        this.add(buttonReadFromFile);
        this.add(scrollBar);

        myListenersAndActions listenerAndAction = new myListenersAndActions(textAreaFromFile,
                textAreaToFile,
                buttonReadFromFile,
                buttonWriteToFile,
                textFieldNumberLine,
                scrollLine,
                this);

        buttonReadFromFile.addActionListener(listenerAndAction);
        buttonWriteToFile.addActionListener(listenerAndAction);
        textFieldNumberLine.addActionListener(listenerAndAction);

        this.setVisible(true);
    }

    public String getNameInputFile()
    {
        FileDialog fd = new FileDialog(this,"Window of input file");

        fd.setVisible(true);
        String text = fd.getDirectory()+fd.getFile();

        return text;
    }

    public String getNameOutputFile()
    {
        FileDialog fd = new FileDialog(this,"Window of output file");
        fd.setVisible(true);
        String text = fd.getDirectory()+fd.getFile();

        return text;
    }


    public static void main(String[] args)
    {
	    new Thread(() -> new Main()).start();
    }

}
