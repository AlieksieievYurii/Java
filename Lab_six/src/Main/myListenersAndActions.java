package Main;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class myListenersAndActions implements ActionListener
{

    private File file;

    private JTextArea textAreaToFile;
    private JTextArea textAreaFromFile;
    private JButton buttonRead;
    private  JButton buttonWrite;
    private JTextField textFieldNumberLine;
    private JScrollBar scrollLine;
    private Main mainActivity;
    private String nameOutputFile;
    private String nameInputFile;

    myListenersAndActions( JTextArea textAreaFromFile,
                           JTextArea textAreaTofile,
                           JButton buttonRead,
                           JButton buttonWrite,
                           JTextField textFieldNumberLine,
                           JScrollBar scrollLine,
                           Main mainActivity)
    {
        this.mainActivity = mainActivity;
        this.textAreaToFile = textAreaTofile;
        this.textAreaFromFile = textAreaFromFile;
        this.scrollLine = scrollLine;

        this.buttonRead = buttonRead;
        this.buttonWrite = buttonWrite;

        this.textFieldNumberLine = textFieldNumberLine;

        textFieldNumberLine.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                fillTextAreaT0File();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });//Here calling method fillTextAreaTOFile

        textAreaFromFile.addMouseListener(new listenerMouse());
        scrollLine.addAdjustmentListener(new actionListenerScrollBar());
    }

    private void fillTextAreaT0File()//Methon whick calls by changing in textFieldNumberLine
    {                                //It works and calls in DocumentListener
        int index = Integer.parseInt(textFieldNumberLine.getText());
        String arrayText[] = textAreaFromFile.getText().split("\\n");

        textAreaToFile.setText(arrayText[index]);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == buttonRead) readFile();
        else if(e.getSource() == buttonWrite) writeFile();
    }

    private void readFile()
    {
        nameInputFile = mainActivity.getNameInputFile();
        file = new File(nameInputFile);
        Scanner scn;
        try {
            scn = new Scanner(file); //Here I check file is not NULL or File is finded!
        }catch (IOException e)
        {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Error of file, can not open of find!");
            return;
        }

        while(scn.hasNextLine())
        {
            textAreaFromFile.append(scn.nextLine()+"\n");// I writed text from file to TextArea
                                                            // First of all I checked that file has line. I read line and add \n, then append to textArea
        }
        scn.close();
    }

    private void writeFile()
    {
        nameOutputFile = mainActivity.getNameOutputFile();

        PrintWriter fileWriting;
        try
        {
           fileWriting = new PrintWriter(nameOutputFile);
        }catch (IOException e)
        {
            e.printStackTrace();
            return;
        }
        fileWriting.println(textAreaToFile.getText());
        fileWriting.close();
        JOptionPane.showMessageDialog(null,"File is saved");
    }

    class listenerMouse implements MouseListener
    {
        @Override
        public void mouseClicked(MouseEvent e){}

        @Override
        public void mousePressed(MouseEvent e){}

        @Override
        public void mouseReleased(MouseEvent e) {
            textAreaToFile.setText(textAreaFromFile.getSelectedText());//If mouse unPressed button on TextAreaFromFile
                                                                        //it will read select text on TextAreaFromFile and set as TextAreToFile
        }

        @Override
        public void mouseEntered(MouseEvent e){}

        @Override
        public void mouseExited(MouseEvent e){}
    }

    private class actionListenerScrollBar implements AdjustmentListener
    {

        @Override
        public void adjustmentValueChanged(AdjustmentEvent e) {
            if(e.getValue() < textAreaFromFile.getLineCount()-1) {
                String[] array = textAreaFromFile.getText().split("\\n");

                textFieldNumberLine.setText(Integer.toString(e.getValue()));
                textAreaToFile.setText(array[e.getValue()]);
            }
        }
    }
}


