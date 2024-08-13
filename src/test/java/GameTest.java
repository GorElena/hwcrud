import DataClasses.Player;
import Exceptions.NotRegisteredException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    public void toWinFirstPlayer() {
        Player Kolya = new Player(1, "Kolya", 78);
        Player Vasa = new Player(2, "Vasa", 47);
        Player Petya = new Player(3, "Petya", 62);
        Player Igor = new Player(4, "Igor", 100);
        Player Roman = new Player(5, "Roman", 62);

        Game game = new Game();

        game.register(Kolya);
        game.register(Vasa);
        game.register(Petya);
        game.register(Igor);
        game.register(Roman);

        int expected = 1;
        int actual = game.round("Petya", "Vasa");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void toWinSecondPlayer() {
        Player Kolya = new Player(1, "Kolya", 78);
        Player Vasa = new Player(2, "Vasa", 47);
        Player Petya = new Player(3, "Petya", 62);
        Player Igor = new Player(4, "Igor", 100);
        Player Roman = new Player(5, "Roman", 62);

        Game game = new Game();

        game.register(Kolya);
        game.register(Vasa);
        game.register(Petya);
        game.register(Igor);
        game.register(Roman);

        int expected = 2;
        int actual = game.round("Vasa", "Kolya");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void gameDraw() {
        Player Kolya = new Player(1, "Kolya", 78);
        Player Vasa = new Player(2, "Vasa", 47);
        Player Petya = new Player(3, "Petya", 62);
        Player Igor = new Player(4, "Igor", 100);
        Player Roman = new Player(5, "Roman", 62);

        Game game = new Game();

        game.register(Kolya);
        game.register(Vasa);
        game.register(Petya);
        game.register(Igor);
        game.register(Roman);


        int expected = 0;
        int actual = game.round("Petya", "Roman");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void throwException() {
        Player Kolya = new Player(1, "Kolya", 78);
        Player Vasa = new Player(2, "Vasa", 47);
        Player Petya = new Player(3, "Petya", 62);
        Player Igor = new Player(4, "Igor", 100);
        Player Roman = new Player(5, "Roman", 62);
        Game game = new Game();

        game.register(Kolya);
        game.register(Vasa);
        game.register(Petya);
        game.register(Igor);
        game.register(Roman);


        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Igor", "Mihail");
        });
    }
}