package ru.netology;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {

//    List<Player> listOfPlayers = new ArrayList<>();
//
//    public void register(Player player) {
//        listOfPlayers.add(player);
//    }

    HashMap<String, Player> listOfPlayers = new HashMap<>();
    public void register(String name, Player player) {
        listOfPlayers.put(name, player);
    }

    public Player findInfo (String key) {
        return listOfPlayers.get(key);
    }



    public int round(String name1, String name2) {
        Player player1 = null;
        Player player2 = null;
        for (String key : listOfPlayers.keySet()) {
            if (listOfPlayers.get(key).equals(listOfPlayers.get(name1))) {
                player1 = listOfPlayers.get(key);
            }
            if (listOfPlayers.get(key).equals(listOfPlayers.get(name2))) {
                player2 = listOfPlayers.get(key);
            }
        }
        if (player1 == null) {
            throw new NotRegisteredException(name1);
        }
        if (player2 == null) {
            throw new NotRegisteredException(name2);
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1.getStrength() < player2.getStrength()) {
            return -1;
        }
        return 0;
    }
}
