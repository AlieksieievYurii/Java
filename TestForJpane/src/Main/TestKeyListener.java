package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TestKeyListener extends JFrame
{
    public TestKeyListener()
    {
        super("KeyListener");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);

        JPanel panel = new JPanel();

        panel.setLayout(new BorderLayout());
        panel.setFocusable(true);

        JLabel text = new JLabel("TEST");
        text.setFont(new Font("italica",Font.BOLD,20));
        text.setHorizontalAlignment(JLabel.CENTER);
        panel.add(text);

        this.setPreferredSize(new Dimension(200,200));
        this.add(panel,BorderLayout.CENTER);
        this.pack();

        this.setVisible(true);

        panel.addKeyListener(new KeyAdapter()
        {
            @Override
            public void keyReleased(KeyEvent e)
            {
                System.out.println("TEST");
               text.setText(e.getKeyText(e.getKeyCode()));
            }
        });

    }
}
