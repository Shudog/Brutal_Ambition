import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jasper on 4/23/2017.
 */
public class GameMain {
    private JLabel appName;
    private JButton playdiceButton;
    private JButton playDnDButton;
    private JPanel rootPanel;


    //initializer for Menu Frame
    //Add's buttons to Frame
    public GameMain()
    {
        playdiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dice diceGame = new Dice();
                diceGame.setBoard();
            }
        });

        playDnDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DnD dndGame = new DnD();
                dndGame.setBoard();
            }
        });
    }

    //Sets up the Frame to be visible
    public void setBoard()
    {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new GameMain().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    //Runs Application
    public static void main(String[] args)
    {
        GameMain main = new GameMain();
        main.setBoard();

    }

}
