package com.gameSpring.cricketGameSpring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class EntityPlayerTeam1 {
    public EntityPlayerTeam1(int playerNumber, String batsmenOrBowler, int runsScored, int noOfBallsLeftToBowl, int noOfWicketsTaken) {
        PlayerNumber = playerNumber;
        BatsmenOrBowler = batsmenOrBowler;
        RunsScored = runsScored;
        NoOfBallsLeftToBowl = noOfBallsLeftToBowl;
        NoOfWicketsTaken = noOfWicketsTaken;
    }


    public EntityPlayerTeam1() {
    }
    public int getPlayerNumber() {
        return PlayerNumber;
    }
    public void setPlayerNumber(int playerNumber) {
        PlayerNumber = playerNumber;
    }
    public String getBatsmenOrBowler() {
        return BatsmenOrBowler;
    }
    public void setBatsmenOrBowler(String batsmenOrBowler) {
        BatsmenOrBowler = batsmenOrBowler;
    }
    public int getRunsScored() {
        return RunsScored;
    }
    public void setRunsScored(int runsScored) {
        RunsScored = runsScored;
    }
    public int getNoOfBallsLeftToBowl() {
        return NoOfBallsLeftToBowl;
    }
    public void setNoOfBallsLeftToBowl(int noOfBallsLeftToBowl) {
        NoOfBallsLeftToBowl = noOfBallsLeftToBowl;
    }
    public int getNoOfWicketsTaken() {
        return NoOfWicketsTaken;
    }
    public void setNoOfWicketsTaken(int noOfWicketsTaken) {
        NoOfWicketsTaken = noOfWicketsTaken;
    }
    @Id
    public int PlayerNumber;
    public String BatsmenOrBowler;
    public int RunsScored;
    public int NoOfBallsLeftToBowl;
    public int NoOfWicketsTaken;
}