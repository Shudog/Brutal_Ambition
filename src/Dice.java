import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by NS12379 on 3/13/2017.
 */
public class Dice {
    private ArrayList<Player> players;
    private Player currentPlayer;
    private Integer playerIndex;

    private JPanel rootPanel;
    private JButton previousPlayerButton;
    private JButton nextPlayerButton;
    private JButton setPlayersButton;
    private JLabel playerName;

    public static void main(String[] args) {
        Dice game = new Dice();
        game.setBoard();
    }


    public Dice() {
        players = new ArrayList<>();
        playerIndex = 0;

        setPlayersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ArrayList<Player> newPlayers = new ArrayList<>();
                Player john = new Player("John");
                Player alex = new Player("Alex");
                Player balo = new Player("Balo");
                newPlayers.add(john);
                newPlayers.add(alex);
                newPlayers.add(balo);

                addPlayers(newPlayers);
            }
        });
        previousPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                players.set(playerIndex, currentPlayer);
                playerIndex--;
                if(playerIndex < 0)
                    playerIndex = players.size() - 1;
                currentPlayer = players.get(playerIndex);
                playerName.setText(currentPlayer.getPlayerName());
            }
        });
        nextPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                players.set(playerIndex, currentPlayer);
                playerIndex++;
                if(playerIndex >= players.size())
                    playerIndex = 0;
                currentPlayer = players.get(playerIndex);
                playerName.setText(currentPlayer.getPlayerName());
            }
        });
    }

    public void addPlayers(ArrayList<Player> newPlayers) {
        players.clear();
        players.addAll(newPlayers);
        currentPlayer = players.get(0);
    }

    public void setBoard() {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new Dice().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
