import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by NS12379 on 3/13/2017.
 */
public class DiceTest {
    Dice game = new Dice();

    @org.junit.Before
    public void setUp() throws Exception {
        game.removeAll();
        ArrayList<Player> players = new ArrayList<>();
        Player john = new Player("John");
        Player alex = new Player("Alex");
        Player balo = new Player("Balo");

        players.add(john);
        players.add(alex);
        players.add(balo);

        game.addPlayers(players);
    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    //testing both getcurrent Player/Index
    public void functionality() throws Exception {
        ArrayList<Player> actual = game.getPlayers();
        Integer currentIndex = game.getCurrentIndex();
        Player currentPlayer;

        game.nextPlayer();

        currentIndex++;
        currentPlayer = actual.get(currentIndex);

        assertEquals(currentPlayer, game.getCurrentPlayer());
        assertEquals(currentIndex, game.getCurrentIndex());
    }

    @org.junit.Test
    public void addPlayers() throws Exception {
        game.removeAll();
        ArrayList<Player> expected = new ArrayList<>();
        Player new1 = new Player("New1");
        Player new2 = new Player("New2");
        Player new3 = new Player("New3");

        expected.add(new1);
        expected.add(new2);
        expected.add(new3);
        game.addPlayers(expected);

        ArrayList<Player> actual = game.getPlayers();
        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void addPlayer() throws Exception {
        game.removeAll();
        Player expected = new Player("Noob");

        game.addPlayer(expected);

        assertEquals(expected, game.getPlayer(0));
    }

    @org.junit.Test
    public void addPoints() throws Exception {
        ArrayList<Player> expected = game.getPlayers();

        game.addPoints(500);
        expected.get(0).addPoints(500);
        game.nextPlayer();

        game.addPoints(-500);
        expected.get(1).addPoints(-500);
        game.nextPlayer();

        game.addPoints(0);
        expected.get(2).addPoints(0);
        game.nextPlayer();

        ArrayList<Player> actual = game.getPlayers();

        assertEquals(expected.get(0).getCurrentPoints(), actual.get(0).getCurrentPoints());
        assertEquals(expected.get(1).getCurrentPoints(), actual.get(1).getCurrentPoints());
        assertEquals(expected.get(2).getCurrentPoints(), actual.get(2).getCurrentPoints());
    }

    @org.junit.Test
    public void rollDice() throws Exception {
        game.rollDice();
        assertTrue(game.getCurrentPlayer().getCurrentPoints() > 1);
    }

    @org.junit.Test
    public void previousPlayer() throws Exception {
        ArrayList<Player> expected = game.getPlayers();
        game.previousPlayer();
        ArrayList<Player> actual = game.getPlayers();
        assertEquals(expected.get(expected.size() - 1), actual.get(expected.size() - 1));
    }

    @org.junit.Test
    public void nextPlayer() throws Exception {
        ArrayList<Player> expected = game.getPlayers();
        game.nextPlayer();
        ArrayList<Player> actual = game.getPlayers();
        assertEquals(expected.get(1), actual.get(1));
    }

}