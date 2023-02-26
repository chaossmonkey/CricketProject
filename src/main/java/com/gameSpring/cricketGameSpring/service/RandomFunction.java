package com.gameSpring.cricketGameSpring.service;

import java.util.Random;

public class RandomFunction {
    public int generateRandomForBowler(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }
    public int generalRandom(int min, int max)
    {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }
    //the lower probability function used to generate  wicket for less time, since it is the batsmen who is batting
    public int generateRandomForBatsmen(int min, int max) {
        Random random = new Random();
        int randomNumber = random.nextInt(100);
        if (randomNumber < 15) {
            return 7;
        } else {
            return random.nextInt(6) + 1;
        }
    }

}
