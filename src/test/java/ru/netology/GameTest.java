package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class GameTest {

    Player player1 = new Player(1, "player1", 10);
    Player player2 = new Player(2, "player2", 30);
    Player player3 = new Player(3, "player3", 50);
    Player player4 = new Player(4, "player4", 20);
    Player player5 = new Player(5, "player5", 50);
    Player player6 = new Player(6, "player6", 40);

    Game game = new Game();

    @Test
    public void findAPlayer() {
        game.register("player1", player1);
        game.register("player2", player2);
        game.register("player3", player3);
        game.register("player4", player4);
        game.register("player5", player5);
        game.register("player6", player6);

        Player expected = player1;
        Player actual = game.findInfo("player1");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void FirstPlayerWinBothPlayersRegistered() {
        game.register("player2", player2);
        game.register("player1", player1);

        int expected = 1;
        int actual = game.round("player2", "player1");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void SecondPlayerWinsBothPlayersRegistered() {
        game.register("player4", player4);
        game.register("player6", player6);

        int expected = -1;
        int actual = game.round("player4", "player6");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void drawBothPlayersRegistered() {
        game.register("player3", player3);
        game.register("player5", player5);

        int expected = 0;
        int actual = game.round("player3", "player5");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void firstPlayerNotRegistered() {
        game.register("player2", player2);

        Assertions.assertThrows(NotRegisteredException.class, ()-> {game.round("player1", "player2");});
    }

    @Test
    public void TheSecondPlayerNotRegistered() {
        game.register("player3", player3);

        Assertions.assertThrows(NotRegisteredException.class, ()-> {game.round("player3", "player4");});
    }

    @Test
    public void BothPlayersAreNotRegistered() {


        Assertions.assertThrows(NotRegisteredException.class, ()-> {game.round("player5", "player6");});
    }
}
