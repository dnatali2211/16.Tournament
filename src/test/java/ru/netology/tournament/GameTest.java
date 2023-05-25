package ru.netology.tournament;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {
    Game game = new Game();
    Player player1 = new Player(1, "Belkin Ivan", 15);
    Player player2 = new Player(2, "Sharikov Alexey", 24);
    Player player3 = new Player(3, "Bobikov Sergey", 51);
    Player player4 = new Player(4, "Tuzikov Andrey", 51);

    @BeforeEach
    public void setup() {

        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);
        game.addPlayer(player4);
    }

    @Test
    public void shouldNotAddIfRegistered() {
        game.addPlayer(player1);
        Assertions.assertTrue(game.getPlayersList().containsValue(player1));
    }

    @Test
    public void shouldCheckIfRegistered() {

        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        Assertions.assertTrue(game.getPlayersList().containsValue(player1));
        Assertions.assertTrue(game.getPlayersList().containsValue(player2));
        Assertions.assertTrue(game.getPlayersList().containsValue(player3));
        Assertions.assertTrue(game.getPlayersList().containsValue(player4));
    }

    @Test
    public void shouldCheckIfNotRegistered() {

        Player player5 = new Player(5, "Kostochkin Vasilii", 29);

        game.register(player5);

        Assertions.assertFalse(game.getPlayersList().containsValue(player5));
    }

    @Test
    public void shouldThrowPlayer1() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Petrov Ivan", "Sharikov Alexey");
        });
    }

    @Test
    public void shouldThrowPlayer2() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Belkin Ivan", "Kostochkin Vasilii");
        });

    }

    @Test
    public void shouldThrowIfAllPlayersIsNotRegistered() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Petrov Ivan", "Bloshkin Innokentii");
        });
    }

    @Test
    public void testIfPlayer2Win() {

        Assertions.assertEquals(2, game.round("Belkin Ivan", "Sharikov Alexey"));
    }

    @Test
    public void testIfPlayer1Win() {

        Assertions.assertEquals(1, game.round("Bobikov Sergey", "Sharikov Alexey"));
    }

    @Test
    public void testIfPlayersHasSameStrenght() {

        Assertions.assertEquals(0, game.round("Bobikov Sergey", "Tuzikov Andrey"));
    }
}

