package com.dicegame.recorder;

import com.dicegame.dice.Dice;
import com.dicegame.dice.FraudDice;
import com.dicegame.player.FraudPlayer;
import com.dicegame.player.Player;

import java.util.List;

public class Recorder {
    public void recordScore(List<Player> players) {
        System.out.printf("[ ");
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i) instanceof FraudPlayer) getMode(players.get(i)); // i가 핵이라면 모드를 가져옴
            System.out.printf(players.get(i).getName() + ":" + players.get(i).getScore() + " ");
        }
        System.out.printf("]\n");
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

    public void recordWinner(String name) {
        System.out.println("승자를 기록합니다.");
        if (name == "") {
            System.out.println("무승부입니다!");
        } else {
            System.out.println(name + "의 승리입니다!");
        }
    }
}
