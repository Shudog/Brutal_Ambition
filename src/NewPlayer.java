import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;

/**
 * Created by NS12379 on 3/13/2017.
 */
public class NewPlayer {
    private Player newPlayer;

    private JPanel rootPanel;
    private JTextField inputName;
    private JButton enterNewPlayerButton;


    public NewPlayer() {
        newPlayer = null;

        enterNewPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!inputName.getText().equals(""))
                    newPlayer = new Player();
            }
        });
    }

    public Player getPlayer() {
        return newPlayer;
    }

    public void close() {
//        rootPanel.dispatchEvent(new WindowEvent(rootPanel, WindowEvent.WINDOW_CLOSING));
        try {
            dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setBoard() {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new NewPlayer().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
