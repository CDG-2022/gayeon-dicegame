package com.dicegame.judge;

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

        }
    }
}
