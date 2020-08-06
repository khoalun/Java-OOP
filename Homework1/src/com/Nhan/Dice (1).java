package com.Nhan;

import java.util.Random;

public class Dice {
    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    Random ran = new Random();

    public int randomDice() {
        return (int) (Math.random() * 6) + 1;
    }
}
