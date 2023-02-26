package com.gameSpring.cricketGameSpring.service;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Game {

    public List<List<Player>> gameInitializer() throws Exception {
        List<List<Player>> data = new ArrayList<>();
        Team team1 = new Team();
        Team team2 = new Team();
        RandomFunction randomFunction = new RandomFunction();
        InputStreamReader IRR = new InputStreamReader(System.in);
        BufferedReader BRR = new BufferedReader(IRR);


        team1.initializeTeamBowlerOrBatsmen();
        team2.initializeTeamBowlerOrBatsmen();

        int toss = randomFunction.generalRandom(1, 2);

        if (toss == 1) {
            System.out.println("TEAM 1 HAS WON THE TOSS ..BALL OR BAT FIRST???...");
            String reaction = BRR.readLine();

            if (reaction.equals("BALL")) {
                Team2BatFirst team2BatFirst = new Team2BatFirst();
                return team2BatFirst.team2BattingFirst(team1, team2, randomFunction);
            } else {
                Team1BatFirst team1battingFirst = new Team1BatFirst();
                return team1battingFirst.team1BattingFirst(team1, team2, randomFunction);
            }
        } else {
            System.out.println("TEAM 2 HAS WON THE TOSS ..BALL OR BAT FIRST???...");
            String reaction = BRR.readLine();

            if (reaction.equals("BALL")) {
                Team1BatFirst team1battingFirst = new Team1BatFirst();
                return team1battingFirst.team1BattingFirst(team1, team2, randomFunction);
            } else {
                Team2BatFirst team2BatFirst = new Team2BatFirst();
                return team2BatFirst.team2BattingFirst(team1, team2, randomFunction);
            }
        }
    }

}