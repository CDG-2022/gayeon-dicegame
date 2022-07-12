package com.dicegame.player;

import com.dicegame.dice.FraudDice;

public class FraudPlayer extends Player{
    private FraudDice fraudDice;
    private Player rival;

    public FraudPlayer(String name_, FraudDice fraudDice_, Player rival_) {
        super(name_, fraudDice_);
        this.fraudDice = fraudDice_;
        this.rival = rival_;
    }

    public void sneaky() {
        if (this.rival.getScore() - this.getScore() > 0) { // 지는중
            fraudDice.setMode(2); // to strong
        } else if (this.getScore() - this.rival.getScore() >= 6) { // 이기는중
            fraudDice.setMode(1); // to weak
        } else {
            fraudDice.setMode(0); // normal
        }
    }
}
