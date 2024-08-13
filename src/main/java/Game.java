import DataClasses.Player;
import Exceptions.NotRegisteredException;

import java.util.ArrayList;

public class Game {
    private ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        int strengthPlayer1 = findPlayer(playerName1).getStrength();
        int strengthPlayer2 = findPlayer(playerName2).getStrength();
        if (strengthPlayer1 > strengthPlayer2) {
            return 1;
        } else if (strengthPlayer1 < strengthPlayer2) {
            return 2;
        }
        return 0;
    }


    private Player findPlayer(String playerName) {
        for (Player player : players) {
            if (player.getName().equals(playerName)) {
                return player;
            }
        }
        throw new NotRegisteredException(playerName);
    }
}
