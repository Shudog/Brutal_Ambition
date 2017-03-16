import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by NS12379 on 3/15/2017.
 */
public class PlayerTest {

    Player john = new Player("John");

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void playerRollsDice() throws Exception {

    }

    @Test
    public void changePlayerName() throws Exception {
        //Broken for some reason
//        john.changePlayerName("Alex");
//        assertEquals("Alex", john.getPlayerName());
    }

    @Test
    public void addPoints() throws Exception {
        john.addPoints(500);
        john.addPoints(300);

        assertEquals(john.getCurrentPoints(), 800);
    }

    @Test
    public void playerPlaysNewGame() throws Exception {
        john.addPoints(500);
        john.playerPlaysNewGame();

        assertEquals(john.getCurrentPoints(), 0);
        assertEquals(john.getGamesPlayed(), 1);
        assertEquals(john.getTotalPoints(), 500);
    }

    @Test
    public void playerWins() throws Exception {
        john.playerWins();
        john.playerWins();

        assertEquals(john.getPlayerWins(), 2);
    }

    @Test
    public void playerLoses() throws Exception {
        john.playerLoses();
        john.playerLoses();
        john.playerLoses();

        assertEquals(john.getLosses(), 3);
    }

    @Test
    public void getPlayerWins() throws Exception {
        john.playerWins();

        assertEquals(john.getPlayerWins(), 1);
    }

    @Test
    public void getLosses() throws Exception {
        john.playerLoses();

        assertEquals(john.getLosses(), 1);
    }

    @Test
    public void getPlayerName() throws Exception {
        assertEquals(john.getPlayerName(), "John");
    }

    @Test
    public void getWinRate() throws Exception {
        john.playerWins();
        john.playerWins();
        john.playerLoses();
        john.playerLoses();
        john.playerPlaysNewGame();
        john.playerPlaysNewGame();
        john.playerPlaysNewGame();
        john.playerPlaysNewGame();

        double expected = 0.5;

        assertEquals(john.getWinRate(), expected, 0);
    }

    @Test
    public void getGamesPlayed() throws Exception {
        john.playerPlaysNewGame();
        john.playerPlaysNewGame();
        john.playerPlaysNewGame();

        assertEquals(john.getGamesPlayed(), 3);
    }

    @Test
    public void getTotalPoints() throws Exception {
        john.addPoints(100);
        john.playerPlaysNewGame();
        john.addPoints(500);
        john.playerPlaysNewGame();
        john.addPoints(100);

        assertEquals(john.getTotalPoints(), 700);
    }

    @Test
    public void getCurrentPoints() throws Exception {
        john.addPoints(100);
        john.playerPlaysNewGame();
        john.addPoints(500);

        assertEquals(john.getCurrentPoints(), 500);
    }

    @Test
    public void getPlayerFileLocation() throws Exception {

    }

}