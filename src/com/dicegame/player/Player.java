package com.dicegame.player;

import com.dicegame.dice.Dice;

public class Player {
    private String name;
    private Dice dice;
    private int score = 0;

    public Player(String name_, Dice dice_) {
        this.name = name_;
        this.dice = dice_;
    }

    public String getName() {
        return this.name;
    }

    public Dice getDice() {
        return this.dice;
    }

    public int getScore() {
        return this.score;
    }

    public void play() {
        score += dice.randNum();
    }
}
