package com.dicegame;

public class FraudPlayer extends Player{
    private FraudDice fraudDice;
    private int rivalScore;

    public FraudPlayer(String name_, FraudDice fraudDice_, int rivalScore_) {
        super(name_, fraudDice_);
        this.fraudDice = fraudDice_;
        this.rivalScore = rivalScore_;
    }

    public void setRivalScore(int rivalScore_) {
        this.rivalScore = rivalScore_;
    }

    public void sneaky() {
        if (rivalScore - this.getScore() > 0) { // 지는중
            fraudDice.setMode(2); // to strong
        } else if (this.getScore() - rivalScore >= 6) { // 이기는중
            fraudDice.setMode(1); // to weak
        } else {
            fraudDice.setMode(0); // normal
        }
    }
}
