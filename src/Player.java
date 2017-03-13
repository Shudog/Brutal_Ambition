import java.io.File;

/**
 * Created by Jasper on 2/7/2017.
 */
public class Player {
    private String name;
    private File statsFile;
    private int winRate;
    private int wins;
    private int losses;
    private int gamesPlayed;
    private int totalPoints;
    private int currentPoints;

    public Player() {
        this.name = "";
        this.statsFile = null;
        this.winRate = 0;
        this.gamesPlayed = 0;
        this.totalPoints = 0;
        this.currentPoints = 0;
    }

    public Player(String name) {
        this.name = name;
        //Place holder for file declaration;
        this.winRate = 0;
        this.gamesPlayed = 0;
        this.totalPoints = 0;
        this.currentPoints = 0;
    }


    //Getters and Setters
    public void changePlayerName(String newName) {
        this.name = newName;
        File tempFile = new File(newName);
        this.statsFile.renameTo(tempFile);
        tempFile.delete();
    }

    public void playerRollsDice(int roll) {
        this.currentPoints = this.currentPoints + roll;
        this.totalPoints = totalPoints + roll;
    }

    public void addPoints(int roll) {
        this.currentPoints += roll;
        this.totalPoints += roll;
    }

    public void playerPlaysNewGame() {
        this.currentPoints = 0;
        this.gamesPlayed = this.gamesPlayed + 1;
        this.winRate = this.getPlayerWins() / this.getGamesPlayed();

    }

    public void playerWins() {
        this.wins++;
    }

    public void playerLoses() {
        this.losses++;
    }

    public int getPlayerWins() {
        return this.wins;
    }

    public int getLosses() {
        return this.losses;
    }

    public String getPlayerName() {
        return this.name;
    }

    public int getWinRate() {
        return this.winRate;
    }

    public int getGamesPlayed() {
        return this.gamesPlayed;
    }

    public int getTotalPoints() {
        return this.totalPoints;
    }

    public int getCurrentPoints() {
        return this.currentPoints;
    }

    public String getPlayerFileLocation() {
        return this.statsFile.getAbsolutePath();
    }
}
