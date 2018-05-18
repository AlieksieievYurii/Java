package Main;
//Yurii Alieksieiev 30643 2018>>>WSINF

import javax.swing.JOptionPane;

public class Main
{

    private static VAT paragon;

    public static void main(String[] args)
    {
       paragon = new VAT(
               getNetto(),
               getPodatok(),
               getNumbersGoods()
       );

       printParagon(paragon.getA(),paragon.getP(),paragon.getV(),paragon.getW(),paragon.getX());//function for print paragon on display
    }

    private static void printParagon(int a, float p, float v, int w, int x)
    {
        String paragon = "##########################################\n";
               paragon += "############### P A R A G O N ###############\n";
               paragon += "##########################################\n";
               paragon += "# [*] NETTO: " + a + "   #\n";
               paragon += "# [*] PODATOK: " + p + "   #\n";
               paragon += "# [*] ILOSC: " + x + " szt   #\n";
               paragon += "##########################################\n";
               paragon += "      [$] WART.PODATKU: " + v + "   #\n";
               paragon += "      [$] WART.NETTO: " + w + "   #\n";
               paragon += "##########################################\n";
               paragon += "@ AUTHOR: YURII ALIEKSIEIEV INDEX: 30643\n";
               paragon += "##########################################\n";

               JOptionPane.showMessageDialog(null,paragon);
    }

    private static int getNetto()//This method takes numbers as "netto" and check it on Integers!!
    {                            //I DONT KNOW WHAT IS NETTO........!
        int netto;
        String text;

        while(true)
        {
            text = JOptionPane.showInputDialog("Enter netto:");

            if(text == null) System.exit(0);

            try
            {
                netto = Integer.parseInt(text);
                break;
            }catch (Exception e)
            {
                JOptionPane.showMessageDialog(null,"Enter netto! Must be only numbers!");
            }
        }
        return netto;
    }

    private static float getPodatok()//This method takes float and check that is not less zero!
    {
        float podatok;
        String text;

        while(true)
        {
            text = JOptionPane.showInputDialog("Enter podatok:");

            if(text == null) System.exit(0);

            try
            {
                podatok = Float.parseFloat(text);
                if(podatok < 0)
                {
                    JOptionPane.showMessageDialog(null,"Podatok can not be less zero!");
                    continue;
                }
                break;
            }catch (Exception e)
            {
                JOptionPane.showMessageDialog(null,"Enter podatok!");
            }
        }

        return podatok;
    }

    private static int getNumbersGoods()
    {
        int num;
        String text;

        while(true)
        {
            text = JOptionPane.showInputDialog("Enter number of goods:");

            if(text == null) System.exit(0);

            try
            {
                num = Integer.parseInt(text);

                if(num < 0)
                {
                    JOptionPane.showMessageDialog(null,"Numbers of goods can not be less zero!");
                    continue;
                }

                break;
            }catch (Exception e)
            {
                JOptionPane.showMessageDialog(null,"Enter only Integer!");
            }
        }
        return num;
    }

}
