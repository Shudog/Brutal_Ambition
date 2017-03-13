import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by NS12379 on 3/11/2017.
 */
public class App {
    private ArrayList<Player> gamePlayers;
    private Player currentPlayer;
    private Integer indexPlayer;

    private JPanel mainPanel;
    private JList players;
    private JTextField textField1;
    private JButton addPointsButton;
    private JButton previousPlayerButton;
    private JButton nextPlayerButton;
    private JLabel playerName;
    private JButton helloButton;

    public static void main (String args[]) {
        //pre stuff
        Player john = new Player("John");
        Player alex = new Player("Alex");

        ArrayList<Player> mainPlayers = new ArrayList<>();
        mainPlayers.add(john);
        mainPlayers.add(alex);

        Vector<String> names = new Vector<>();
        for(Player i : mainPlayers) names.addElement(i.getPlayerName());
        //end pre stuff

        App form = new App();
//        form.setNames(names);
        form.setBoard();
        form.setPlayers(mainPlayers);
    }

    public App() {
        gamePlayers = new ArrayList<>();
        currentPlayer = new Player();
        indexPlayer = 0;

        addPointsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setNames();
            }
        });
        previousPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                gamePlayers.set(indexPlayer, currentPlayer);
                indexPlayer--;
                if(indexPlayer <= 0)
                    indexPlayer = gamePlayers.size() - 1;
                currentPlayer = gamePlayers.get(indexPlayer);
                playerName.setText(currentPlayer.getPlayerName());
            }
        });
        nextPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                gamePlayers.set(indexPlayer, currentPlayer);

                if(indexPlayer >= gamePlayers.size())
                    indexPlayer = 0;
                currentPlayer = gamePlayers.get(indexPlayer);
                playerName.setText(currentPlayer.getPlayerName());
            }
        });
    }

    public void setPlayers(ArrayList<Player> newPlayers) {
        gamePlayers.clear();
        for(Player i : newPlayers)
            gamePlayers.add(i);
        setNames();
        System.out.print("Players: ");
        for(Player i : gamePlayers)
            System.out.print(i.getPlayerName() + " ");
        System.out.println("");
        currentPlayer = gamePlayers.get(0);

    }

    public void setNames() {
    }


    public void setBoard() {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new App().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
