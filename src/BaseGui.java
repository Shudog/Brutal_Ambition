import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jasper on 3/21/2017.
 */
public class BaseGui extends JFrame {
    private JComboBox comboBox1;
    private JPanel rootPanel;
    private JPanel gamePanel;

    public BaseGui()
    {
        setContentPane(rootPanel);
        pack();

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox comboBox = (JComboBox) e.getSource();

                String selectedGame = (String) comboBox1.getItemAt(comboBox1.getSelectedIndex());
                changeGame(selectedGame);
            }
        });

        setVisible(true);
    }

    public void changeGame(String selectedGame)
    {
        if(selectedGame == "Dice")
        {
            Dice dice = new Dice();
            dice.setBoard();
            gamePanel = dice.getRootPanel();
        }
    }


}
