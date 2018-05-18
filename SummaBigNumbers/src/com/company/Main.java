package com.company;

import javax.swing.JOptionPane;
import java.awt.*;

public final class Main
{
    private static int[][] Numbers;

    public static void main(String[] args)
    {
        int N = 0;
        String nameFile = JOptionPane.showInputDialog("Enter name file on direcoty:");
        if(nameFile == null) System.exit(0);

        RWArray ActionArray = new RWArray(nameFile);

        if(ActionArray.checkFile() == 1)
        {
            JOptionPane.showMessageDialog(null,"Not found the file!");
            main(null);
        }

        Numbers = new int[ActionArray.SizeY][ActionArray.SizeX];
        Numbers = ActionArray.FullArrays();
        try {
            String input = JOptionPane.showInputDialog("Enter num digits:");
            if(input == null) System.exit(0);
            N = Integer.parseInt(input);
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"You entered not numbers!");
            System.exit(5);
        }

        RunTask runProgram = new RunTask(Numbers);
        JOptionPane.showMessageDialog(null,runProgram.run(N));
    }
}
