package com.gameSpring.cricketGameSpring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class EntityPlayerTeam2 {
    public EntityPlayerTeam2() {
    }

    public EntityPlayerTeam2(int playerNumber, String batsmenOrBowler, int runsScored, int noOfBallsLeftToBowl, int noOfWicketsTaken) {
        PlayerNumber = playerNumber;
        BatsmenOrBowler = batsmenOrBowler;
        RunsScored = runsScored;
        NoOfBallsLeftToBowl = noOfBallsLeftToBowl;
        NoOfWicketsTaken = noOfWicketsTaken;
    }

    @Id
    public int PlayerNumber;
    public String BatsmenOrBowler;
    public int RunsScored;
    public int NoOfBallsLeftToBowl;
    public int NoOfWicketsTaken;

    public void setPlayerNumber(int playerNumber) {
        PlayerNumber = playerNumber;
    }

    public void setBatsmenOrBowler(String batsmenOrBowler) {
        BatsmenOrBowler = batsmenOrBowler;
    }

    public void setRunsScored(int runsScored) {
        RunsScored = runsScored;
    }

    public void setNoOfBallsLeftToBowl(int noOfBallsLeftToBowl) {
        NoOfBallsLeftToBowl = noOfBallsLeftToBowl;
    }

    public void setNoOfWicketsTaken(int noOfWicketsTaken) {
        NoOfWicketsTaken = noOfWicketsTaken;
    }

    public int getPlayerNumber() {
        return PlayerNumber;
    }

    public String getBatsmenOrBowler() {
        return BatsmenOrBowler;
    }

    public int getRunsScored() {
        return RunsScored;
    }

    public int getNoOfBallsLeftToBowl() {
        return NoOfBallsLeftToBowl;
    }

    public int getNoOfWicketsTaken() {
        return NoOfWicketsTaken;
    }
}