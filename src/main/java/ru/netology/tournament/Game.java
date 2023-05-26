package ru.netology.tournament;

import java.util.ArrayList;

public class Game {

    private ArrayList<Player> playersList = new ArrayList<>();

    public ArrayList<Player> getPlayersList() {
        return playersList;
    }

    public void addPlayer(Player player) {
        for (Player existingPlayer : playersList) {
            if (existingPlayer.getName().equals(player.getName())) {
                return;
            }
        }
        playersList.add(player);
    }

    public void register(Player player) {
        if (!playersList.contains(player)) return;
    }

    public Player findByName(String playerName) {
        for (Player player : playersList) {
            if (player.getName().equals(playerName)) {
                return player;
            }
        }
        return null;
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



