package Main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public final class Main extends JFrame
{
    private final JLabel[] arrayLabel;
    private final JTextField[] arrayTextField;
    private final JButton ButtonStart;
    private final JLabel[] arrayAnswers;
    private JLabel ocean;
    private Container field;

    private int[] FirstNumbers;
    private int[] SecondNumbers;
    private int[] answers;

    public Main(int leavel, int MinNumbersRandom,int MaxNumbersRandom)
    {
        super("Tester");
        this.setSize(190,90+(25*leavel));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);

        arrayLabel = new JLabel[leavel];
        arrayTextField = new JTextField[leavel];
        arrayAnswers  = new JLabel[leavel];
        ButtonStart = new JButton("Check");

        FirstNumbers = new int[leavel];
        SecondNumbers = new int[leavel];
        SecondNumbers = new int[leavel];
        answers = new int[leavel];

        field = getContentPane();
        field.setLayout(new FlowLayout(FlowLayout.CENTER,5,7));
        FirstNumbers = FullRandomNumbers(FirstNumbers.length,MinNumbersRandom,MaxNumbersRandom);
        SecondNumbers = FullRandomNumbers(SecondNumbers.length,MinNumbersRandom,MaxNumbersRandom);

        for(int i = 0; i < leavel; i++)
        {
            arrayLabel[i] = new JLabel(FirstNumbers[i] + " * " + SecondNumbers[i] + " = ");
            arrayTextField[i] = new JTextField(10);
            field.add(arrayLabel[i]);
            field.add(arrayTextField[i]);
        }

        field.add(ButtonStart);
        this.setVisible(true);

        ButtonStart.addActionListener(new Handle());
    }

    public static void main(String[] args)
    {
        new Difficals();
    }

    private int[] FullRandomNumbers(int size,int MinNumbersRandom,int MaxNumbersRandom)
    {
        int[] Numbers = new int[size];
        Random rand = new Random();

        for(int i = 0; i < size; i++)
            Numbers[i] = rand.nextInt(MaxNumbersRandom) + MinNumbersRandom;
        return Numbers;
    }

    private void FunCheck()
    {
        int K = 0;
        for(int i = 0; i < answers.length; i++)
        {
            answers[i] = FirstNumbers[i]*SecondNumbers[i];
            String textNumber = arrayTextField[i].getText();
            try {
                if (answers[i] == Integer.parseInt(textNumber))
                {
                    arrayAnswers[i] = new JLabel((i+1)+". QA is correct ["+answers[i]+"];");
                    K++;
                }else arrayAnswers[i] = new JLabel((i+1)+". is uncorrect ["+answers[i]+"];");
            }catch (Exception e)
            {
                arrayAnswers[i] = new JLabel((i+1)+". is uncorrect ["+answers[i]+"];");
            }
        }
        printResualts(K);

    }

    private void printResualts(int k)
    {
        this.setSize(190,90+(49*arrayAnswers.length));
        for(JLabel label : arrayAnswers)
        {
            field.add(label);
        }
        ocean = new JLabel("You has "+k + "/"+arrayAnswers.length+" score");
        field.add(ocean);
        ButtonStart.setVisible(false);
        this.setVisible(true);
    }

    class Handle implements ActionListener
    {
        public void actionPerformed(ActionEvent action)
        {
            if(action.getSource() == ButtonStart)
            {
                FunCheck();
            }
        }
    }
}
