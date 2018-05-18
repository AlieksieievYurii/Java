package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class Main extends JFrame
{
	private JLabel l1,l2;
	private JTextField field1,field2;
	private JButton B1;

	private Main()
	{
		super("Test");
		this.setSize(100,150);
		this.setLocationRelativeTo(null);

		Container Lab = getContentPane();
		Lab.setLayout(new FlowLayout(FlowLayout.CENTER,20,10));

		l1 = new JLabel("A:");
		l2 = new JLabel("B:");
		field1 = new JTextField(5);
		field2 = new JTextField(5);
		B1 = new JButton("OK");

		Lab.add(l1);
		Lab.add(field1);
		Lab.add(l2);
		Lab.add(field2);
		Lab.add(B1);

		this.setVisible(true);

		Handler listener = new Handler();
		B1.addActionListener(listener);

	}

	class Handler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			int A,B,C;
			if(e.getSource() == B1)
			{
				try{
					A = Integer.parseInt(field1.getText());
					B = Integer.parseInt(field2.getText());
					C = A+B;
					JOptionPane.showMessageDialog(null,"Summa is "+ C);
				}catch(Exception error){JOptionPane.showMessageDialog(null,"Enter only numbers!");}
			}
		}
	}

    public static void main(String[] args)
    {
	  new Main();
    }
}
