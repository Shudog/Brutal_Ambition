import java.io.File;

/**
 * Created by Jasper on 2/7/2017.
 */
public class Player {
    private String name;
    private File statsFile;
    private double winRate;
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

    public Player(String n) {
        name = n;
        //Place holder for file declaration;
        this.winRate = 0;
        this.gamesPlayed = 0;
        this.totalPoints = 0;
        this.currentPoints = 0;
    }


    //Getters and Setters
    public void changePlayerName(String newName) {
        System.out.println("Coming in: " + newName);
        this.name = newName;
        System.out.println("Result: " + this.name);
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
        double wins = this.getPlayerWins();
        double games = this.getGamesPlayed();
        this.winRate = (wins/games);

    }

    public void setWins(int w) {
        wins = w;
    }

    public void setLosses(int l) {
        losses = l;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
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

    public double getWinRate() {
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
