package com.gameSpring.cricketGameSpring.service;

public class Player {

    public String BatsmenOrBowler;
    public int PlayerNumber;
    public int RunsScored;
    public int NoOfBallsLeftToBowl;
    public int NoOfWicketsTaken;

    Player(String BatsmenOrBowler, int PlayerNumber, int RunsScored, int NoOfBallsLeftToBowl, int NoOfWicketsTaken) {
        this.BatsmenOrBowler = BatsmenOrBowler;
        this.PlayerNumber = PlayerNumber;
        this.RunsScored = RunsScored;
        this.NoOfBallsLeftToBowl = NoOfBallsLeftToBowl;
        this.NoOfWicketsTaken = NoOfWicketsTaken;
    }

    @Override
    public String toString() {
        return "Player{" +
                "BatsmenOrBowler='" + BatsmenOrBowler + '\'' +
                ", PlayerNumber=" + PlayerNumber +
                ", RunsScored=" + RunsScored +
                ", NoOfBallsLeftToBowl=" + NoOfBallsLeftToBowl +
                ", NoOfWicketsTaken=" + NoOfWicketsTaken +
                '}';
    }
}
