package com.dicegame;

public class FraudDice extends Dice{
    private int mode = 0; // 0: normal, 1: weak, 2: strong
    private boolean flag = true; // mode 에 따른 눈금을 만족하는지 검사

    public void setMode(int mode_) {
        this.mode = mode_;
    }

    public int getMode() {
        return mode;
    }

    @Override
    public int randNum() {
        int diceNum = super.randNum();
        while (flag) {
            if ((mode == 1 && diceNum <= 5) || (mode == 2 && diceNum >= 2)) {
                diceNum = super.randNum();
            }
            else flag = false;
        }
        return diceNum;
    }
}
