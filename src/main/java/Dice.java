import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;



/**
 * Created by NS12379 on 3/13/2017.
 */
public class Dice extends JPanel{
    private static ArrayList<Player> players = new ArrayList<Player>();
    private static Player currentPlayer;
    private Integer playerIndex;

    private JDialog dialog;
    private newPlayerForm dialogPanel = new newPlayerForm();

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
    private JButton rollDiceButton;
    private JLabel rollPoints;

    private static XSSFWorkbook workBook;
    private static Sheet workSheet;

    public static void main(String[] args) throws IOException {
        loadFile("gamedata.xlsx");
        players = loadPlayers(workSheet);
        Dice game = new Dice();
        game.setBoard();
    }


    public Dice() {
        playerIndex = 0;

        setPlayersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ArrayList<Player> newPlayers = new ArrayList<Player>();
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
                previousPlayer();
            }
        });
        nextPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                nextPlayer();
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
                openTableAction();
            }
        });
        rollDiceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                rollDice();
            }
        });
    }

    public void setCurrent() {
        currentPlayer = players.get(playerIndex);
        playerName.setText(currentPlayer.getPlayerName());

        playerPoints.setText(String.valueOf(currentPlayer.getCurrentPoints()));
    }

    public void removeAll() {
        currentPlayer = null;
        players.clear();
        playerName.setText("None");
        playerPoints.setText("None");
    }

    public void addPlayers(ArrayList<Player> newPlayers) {
        players.clear();
        players.addAll(newPlayers);
        currentPlayer = players.get(0);
        setCurrent();
    }

    public void addPlayer(Player newPlayer) {
        players.add(newPlayer);
        playerIndex = players.size() - 1;
        setCurrent();
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Player getPlayer(int i) {
        return players.get(i);
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Integer getCurrentIndex() {
        return playerIndex;
    }

    public void nextPlayer() {
        players.set(playerIndex, currentPlayer);
        playerIndex++;
        if(playerIndex >= players.size())
            playerIndex = 0;
        setCurrent();
    }

    public void previousPlayer() {
        players.set(playerIndex, currentPlayer);
        playerIndex--;
        if(playerIndex < 0)
            playerIndex = players.size() - 1;
        setCurrent();
    }

    public void addPoints(Integer points) {
        currentPlayer.addPoints(points);
        playerPoints.setText(String.valueOf(currentPlayer.getCurrentPoints()));
    }

    public void rollDice() {
        int diceTotal = 0;
        for(int i = 0; i < 5; i++)
            diceTotal += ThreadLocalRandom.current().nextInt(1, 6 + 1);
        addPoints(diceTotal);
        rollPoints.setText(String.valueOf(diceTotal));
    }

    public void setBoard() {

        JFrame frame = new JFrame("App");
        frame.setContentPane(new Dice().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        setCurrent();
    }

    public void openTableAction() {
        rootPanel.setVisible(false);
        if (dialog == null) {
            Window win = SwingUtilities.getWindowAncestor(this);
            if (win == null) {
                dialog = new JDialog(win, "My Dialog",
                        Dialog.ModalityType.APPLICATION_MODAL);
                dialog.getContentPane().add(dialogPanel);
                dialog.pack();
                dialog.setLocationRelativeTo(null);
            }
        }
        dialog.setVisible(true); // here the modal dialog takes over
        playerPoints.setText(dialogPanel.getFieldText());
        Player newPlayer = new Player(dialogPanel.getFieldText());
        addPlayer(newPlayer);
        rootPanel.setVisible(true);
    }

    public static void loadFile(String path)
    {
        try {
            FileInputStream inputStream = new FileInputStream(new File(path));
            workBook = new XSSFWorkbook(inputStream);
            workSheet = workBook.getSheetAt(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Player> loadPlayers(Sheet sheet) {
        Row playerRow = sheet.getRow(0);
        ArrayList<Player> myplayers = new ArrayList<Player>();
        for (int i = 1; i < playerRow.getLastCellNum(); i++)
        {
            Player p = new Player(playerRow.getCell(i).getStringCellValue());
            p.setTotalPoints((int) sheet.getRow(1 ).getCell(i).getNumericCellValue());
            p.setGamesPlayed((int) sheet.getRow(2).getCell(i).getNumericCellValue());
            p.setWins((int) sheet.getRow(3).getCell(i).getNumericCellValue());
            p.setLosses((int) sheet.getRow(4).getCell(i).getNumericCellValue());
            myplayers.add(p);
        }
        currentPlayer = myplayers.get(0);
        return myplayers;
    }
}
