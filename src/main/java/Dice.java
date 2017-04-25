import com.sun.codemodel.internal.JOp;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by NS12379 on 3/13/2017.
 */
public class Dice extends JPanel{
    private static ArrayList<Player> players = new ArrayList<>();
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
    private JButton loadButton;
    private JButton saveToFileButton;

    private static XSSFWorkbook workBook;
    private static Sheet workSheet;

    public Dice() {
        playerIndex = 0;

        setPlayersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                runStats();
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
        loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadFile("gamedata.xlsx");
                players = loadPlayers(workSheet);
                setCurrent();
            }
        });
        saveToFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveFile();
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
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        playerName.setText(currentPlayer.getPlayerName());
        playerPoints.setText(String.valueOf(currentPlayer.getCurrentPoints()));
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

    public static void saveFile()
    {
        File data = null;
            try {
                data = new File("gamedata.xlsx");
            if(data.exists()) {
                FileInputStream inputStream = new FileInputStream(data);

                workBook = new XSSFWorkbook(inputStream);
                workSheet = workBook.getSheetAt(0);
                JOptionPane.showMessageDialog(null, "File loaded");
            }
            else
                JOptionPane.showMessageDialog(null, "File cannot be found");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < players.size(); i++)
        {
            workSheet.getRow(0).getCell(i+1).setCellValue(players.get(i).getPlayerName());
            workSheet.getRow(1).getCell(i+1).setCellValue(players.get(i).getTotalPoints());
            workSheet.getRow(2).getCell(i+1).setCellValue(players.get(i).getGamesPlayed());
            workSheet.getRow(3).getCell(i+1).setCellValue(players.get(i).getPlayerWins());
            workSheet.getRow(4).getCell(i+1).setCellValue(players.get(i).getLosses());
            String rolls = "";
            for(int j: players.get(i).getRolls())
            {
                rolls += Integer.toString(j) + "/";
            }
            workSheet.getRow(5).getCell(i+1).setCellValue(rolls);
        }
        try {
            FileOutputStream out = new FileOutputStream(data);
            workBook.write(out);
            workBook.close();
        }
        catch (IOException e)
        {

        }

    }
    public static void loadFile(String path)
    {
        try {
            File data = new File(path);
            if(data.exists()) {
                FileInputStream inputStream = new FileInputStream(data);

                workBook = new XSSFWorkbook(inputStream);
                workSheet = workBook.getSheetAt(0);
                JOptionPane.showMessageDialog(null, "File loaded");
            }
            else
                JOptionPane.showMessageDialog(null, "File cannot be found");
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
            String[] s = sheet.getRow(5).getCell(i).toString().split("/");
            ArrayList<Integer> z = new ArrayList<>();
            for(String x : s)
            {
                z.add(Integer.parseInt(x));
            }
            p.setRolls(z);
            myplayers.add(p);
        }
        currentPlayer = myplayers.get(0);
        return myplayers;
    }

    public void runStats()
    {
        if (!players.isEmpty()) {
            StatRunner s = new StatRunner(players);
            JOptionPane.showMessageDialog(null, s.runEm());
        }
        else
        {
            JOptionPane.showMessageDialog(null, "No data to do stats on.");
        }
    }
}