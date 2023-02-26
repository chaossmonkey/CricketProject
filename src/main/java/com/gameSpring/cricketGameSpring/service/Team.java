package com.gameSpring.cricketGameSpring.service;

public class Team {
    public Player[] PlayersDetails=new Player[10];
    public int TotalNoOfWicketsLeftTeam =10;
    public int TotalNoOfRunsScoredByTeam=0;


    public void initializeTeamBowlerOrBatsmen() {
        for (int i = 0; i < 10; i++) {
            if (i < 5) {
                PlayersDetails[i] = new Player("batsmen", i + 1, 0, 24, 0);
            } else {
                PlayersDetails[i] = new Player("bowler", i + 1, 0, 24, 0);
            }
        }
    }
}
