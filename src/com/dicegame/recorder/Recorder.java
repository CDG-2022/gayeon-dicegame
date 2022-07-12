package com.dicegame.recorder;

import com.dicegame.dice.Dice;
import com.dicegame.dice.FraudDice;
import com.dicegame.player.Player;

import java.util.List;

public class Recorder {
    public void recordScore(List<Player> players) {
        System.out.printf("[ ");
        for (int i = 0; i < players.size(); i++) {
            if (i % 2 != 0) getMode(players.get(i)); // i가 홀수일때 핵임
            System.out.printf(players.get(i).getName() + ":" + players.get(i).getScore() + " ");
        }
        System.out.printf(" ]\n");
    }

    private String getMode(Player player) {
        FraudDice fraudDice = (FraudDice) player.getDice();
        switch (fraudDice.getMode()) {
            case 0:
                return "[NORMAL] ";
            case 1:
                return "[WEAK] ";
            case 2:
                return "[STRONG] ";
            default: return "";
        }
    }
}
