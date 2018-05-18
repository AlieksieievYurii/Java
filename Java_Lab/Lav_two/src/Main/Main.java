package Main;

import javax.swing.*;
//Aurhor Yurii Alieksieiev 30643

public class Main {

    public static void main(String[] args)
    {
        String text = "";
        for(int x = 1; x < 10; x++)
        {
            for(int y = 1; y < 10; y++)
            {
                text += y + " * " + x + " = "+y*x+(x*y > 9?"    ":"       ");//Here I check, if resualt has more then one symbol, I add only 5 space, else 7 space
            }
            text +="\n";
        }

      JOptionPane.showMessageDialog(null,text);
    }
}
