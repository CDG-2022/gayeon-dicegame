package com.dicegame;

import java.util.Random;

public class Dice {
    Random random = new Random();
    public int randNum() {
        return random.nextInt(6) + 1;
    }
}
