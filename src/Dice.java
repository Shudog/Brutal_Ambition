import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
    private JLabel playerPoints;
    private JLabel pointsText;
    private JTextField pointsInput;
    private JButton addPointsButton;
    private JButton addPlayerButton;

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
                setCurrent();
            }
        });
        nextPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                players.set(playerIndex, currentPlayer);
                playerIndex++;
                if(playerIndex >= players.size())
                    playerIndex = 0;
                setCurrent();
            }
        });
        pointsInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                String ch = String.valueOf(e.getKeyChar());
                try {// if is number
                    Integer.parseInt(ch);
                } catch (NumberFormatException d) {
                    // else then do blah
                    e.consume();
                }
            }
        });
        pointsInput.addKeyListener(new KeyAdapter() {
        });
        pointsInput.addKeyListener(new KeyAdapter() {
        });
        pointsInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                addPoints(Integer.parseInt(pointsInput.getText()));
            }
        });
        addPointsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                addPoints(Integer.parseInt(pointsInput.getText()));
            }
        });
        addPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
//                http://stackoverflow.com/questions/7017063/passing-values-between-jframes

                if (dialog)

                NewPlayer playerForm = new NewPlayer();
                playerForm.setBoard();
//                rootPanel.setVisible(false);
                while(playerForm.getPlayer() == null)
                    break;
                Player newPlayer = playerForm.getPlayer();
                playerForm.close();
                players.add(newPlayer);
            }
        });
    }

    public void setCurrent() {
        currentPlayer = players.get(playerIndex);
        playerName.setText(currentPlayer.getPlayerName());

        playerPoints.setText(String.valueOf(currentPlayer.getCurrentPoints()));
    }

    public void addPlayers(ArrayList<Player> newPlayers) {
        players.clear();
        players.addAll(newPlayers);
        currentPlayer = players.get(0);
    }

    public void addPoints(Integer points) {
        currentPlayer.addPoints(points);
        playerPoints.setText(String.valueOf(currentPlayer.getCurrentPoints()));
    }

    public void setBoard() {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new Dice().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
