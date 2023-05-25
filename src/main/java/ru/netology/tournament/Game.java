package ru.netology.tournament;

import java.util.HashMap;

public class Game {

    private HashMap<String, Player> playersList = new HashMap();

    public HashMap getPlayersList() {
        return playersList;
    }

    public void addPlayer(Player player) {
            if (!playersList.containsKey(player.getName())) {
                playersList.put(player.getName(), player);
            }
    }

    public void register(Player player) {
        if (!playersList.containsValue(player)) return;
    }

    public Player findByName(String playerName) {
        return playersList.get(playerName);
    }

    public int round(String playerName1, String playerName2) {

        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);

        if (player1 == null && player2 == null) {
            throw new NotRegisteredException("Both players " + playerName1 +", " + playerName2 + " are not registered.");
        }
        if (player1 == null) {
            throw new NotRegisteredException("Player " + playerName1 + " is not registered.");
        }
        if (player2 == null) {
            throw new NotRegisteredException("Player " + playerName2 + " is not registered.");
        }

        if (player1.getStrenght() > player2.getStrenght()) {
            return 1;
        }
        else if (player1.getStrenght() < player2.getStrenght()) {
            return 2;
        }
        else {
            return 0;
        }
    }
}



