package com.dicegame.judge;

import com.dicegame.player.FraudPlayer;
import com.dicegame.player.Player;
import com.dicegame.recorder.Recorder;

import java.util.ArrayList;
import java.util.List;

public class Judge {
    private List<Player> playerList = new ArrayList<Player>();
    private Recorder recorder;

    public Judge(Recorder recorder_) {
        this.recorder = recorder_;
    }

    public void registerPlayer(Player player_) {
        playerList.add(player_);
    }

    public void gameStart(int round) {
        for (int i = 0; i < round; i++) {
            oneRound();
            recorder.recordScore(playerList);
        }
        recorder.recordWinner(whoWinner());
    }

    private void oneRound() {
        for (Player player : playerList) {
            if (player instanceof FraudPlayer) ((FraudPlayer) player).sneaky();
            player.play();
        }
    }

    private String whoWinner() {
        int max = 0;
        for (Player player : playerList) {
            if (player.getScore() > max) {
                max = player.getScore();
            }
        }
        return winnerName(max);
    }

    private String winnerName(int max) {
        int winnerCount = 0; // 무승부일 수도 있으니까
        String winnerName = "";
        for (Player player : playerList) {
            if (player.getScore() == max) {
                winnerCount++;
                winnerName += player.getName();
            }
        }
        if (winnerCount == 1) return winnerName;
        else return "";
    }
}
