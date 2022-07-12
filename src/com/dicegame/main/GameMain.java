package com.dicegame.main;

import com.dicegame.dice.Dice;
import com.dicegame.dice.FraudDice;
import com.dicegame.judge.Judge;
import com.dicegame.player.FraudPlayer;
import com.dicegame.player.Player;
import com.dicegame.recorder.Recorder;

import java.util.Scanner;

public class GameMain {
    private final static int ROUND = 5;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("다이스 게임입니다. 당신은 핵과 겨룹니다.");
        System.out.println("당신의 이름을 입력헤주세요");
        System.out.printf(">> ");
        String name = scanner.next();
        Judge judge = new Judge(new Recorder());
        Player player = new Player(name, new Dice());
        FraudPlayer fraudPlayer = new FraudPlayer("핵", new FraudDice(), player);
        judge.registerPlayer(player);
        judge.registerPlayer(fraudPlayer);
        judge.gameStart(ROUND);
    }
}

// mode 에 따라서 다시 던지는게 아닌 그 숫자 이상만 나오게 할까말까