package com.gameSpring.cricketGameSpring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Team1BatSecond {
    private int BallsLeft;
    private int BallsLeftInCurrentOver;
    private int BatsmenOnStrikeId;
    private int BatsmenOnNonStrikerId;
    private int PresentBowlerId;

    private final List<Player> player1_data = new ArrayList<>();

    Team1BatSecond() {
        BallsLeft = 18;
        BallsLeftInCurrentOver = 6;
        BatsmenOnStrikeId = 1;
        BatsmenOnNonStrikerId = 2;
        PresentBowlerId = 10;
    }

    public void Team1BattingSecond(Team team2, Team team1, RandomFunction randomFunction, List<List<Player>> data1) throws Exception {


        while (team1.TotalNoOfWicketsLeftTeam > 0 && BallsLeft > 0 && BallsLeftInCurrentOver > 0) {
            System.out.println("PLAYER" + " " + BatsmenOnStrikeId + "IS AT THE CREASE" + " " + "AND PLAYER " + " " + BatsmenOnNonStrikerId + "IS AT NON-STRIKER END");
            System.out.println("BOWLER of team2  " + " " + PresentBowlerId + " " + "IS ABOUT TO BALL");
            System.out.println("PLEASE PRESS ENTER TO START AGAIN");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();

            int randomForBatsmen;
            if (team1.PlayersDetails[BatsmenOnStrikeId - 1].BatsmenOrBowler.equals("batsmen")) {
                randomForBatsmen = randomFunction.generateRandomForBatsmen(1, 7);
                if (randomForBatsmen == 7) {
                    System.out.println("THIS IS WICKET FOR BOWLER " + " " + "->" + PresentBowlerId);
                    team2.PlayersDetails[PresentBowlerId - 1].NoOfWicketsTaken = team2.PlayersDetails[PresentBowlerId - 1].NoOfWicketsTaken + 1;
                    team2.PlayersDetails[PresentBowlerId - 1].NoOfBallsLeftToBowl = team2.PlayersDetails[PresentBowlerId - 1].NoOfBallsLeftToBowl - 1;
                    team1.TotalNoOfWicketsLeftTeam = team1.TotalNoOfWicketsLeftTeam - 1;
                    BallsLeftInCurrentOver = BallsLeftInCurrentOver - 1;
                    BatsmenOnStrikeId = Math.max(BatsmenOnStrikeId, BatsmenOnNonStrikerId) + 1;
                } else {
                    if (randomForBatsmen % 2 == 0) {
                        team1.PlayersDetails[BatsmenOnStrikeId - 1].RunsScored = team1.PlayersDetails[BatsmenOnStrikeId - 1].RunsScored + randomForBatsmen;
                        team1.TotalNoOfRunsScoredByTeam = team1.TotalNoOfRunsScoredByTeam + randomForBatsmen;
                    } else {
                        team1.PlayersDetails[BatsmenOnStrikeId - 1].RunsScored = team1.PlayersDetails[BatsmenOnStrikeId - 1].RunsScored + randomForBatsmen;
                        int VariableUsedForInterchange = BatsmenOnNonStrikerId;
                        BatsmenOnNonStrikerId = BatsmenOnStrikeId;
                        BatsmenOnStrikeId = VariableUsedForInterchange;
                        team1.TotalNoOfRunsScoredByTeam = team1.TotalNoOfRunsScoredByTeam + randomForBatsmen;
                    }

                    team2.PlayersDetails[PresentBowlerId - 1].NoOfBallsLeftToBowl = team2.PlayersDetails[PresentBowlerId - 1].NoOfBallsLeftToBowl - 1;
                    BallsLeftInCurrentOver = BallsLeftInCurrentOver - 1;
                }
            } else {
                randomForBatsmen = randomFunction.generateRandomForBowler(1, 7);
                if (randomForBatsmen == 7) {
                    System.out.println("THIS IS WICKET FOR BOWLER " + " " + "->" + PresentBowlerId);
                    team2.PlayersDetails[PresentBowlerId - 1].NoOfWicketsTaken = team2.PlayersDetails[PresentBowlerId - 1].NoOfWicketsTaken + 1;
                    team2.PlayersDetails[PresentBowlerId - 1].NoOfBallsLeftToBowl = team2.PlayersDetails[PresentBowlerId - 1].NoOfBallsLeftToBowl - 1;
                    team1.TotalNoOfWicketsLeftTeam = team1.TotalNoOfWicketsLeftTeam - 1;
                    BallsLeftInCurrentOver = BallsLeftInCurrentOver - 1;
                    BatsmenOnStrikeId = Math.max(BatsmenOnStrikeId, BatsmenOnNonStrikerId) + 1;

                } else {
                    if (randomForBatsmen % 2 == 0) {
                        team1.PlayersDetails[BatsmenOnStrikeId - 1].RunsScored = team1.PlayersDetails[BatsmenOnStrikeId - 1].RunsScored + randomForBatsmen;
                        team1.TotalNoOfRunsScoredByTeam = team1.TotalNoOfRunsScoredByTeam + randomForBatsmen;

                    } else {
                        team1.PlayersDetails[BatsmenOnStrikeId - 1].RunsScored = team1.PlayersDetails[BatsmenOnStrikeId - 1].RunsScored + randomForBatsmen;
                        int VariableUsedForInterchange = BatsmenOnNonStrikerId;
                        BatsmenOnNonStrikerId = BatsmenOnStrikeId;
                        BatsmenOnStrikeId = VariableUsedForInterchange;
                        team1.TotalNoOfRunsScoredByTeam = team1.TotalNoOfRunsScoredByTeam + randomForBatsmen;
                    }
                    team2.PlayersDetails[PresentBowlerId - 1].NoOfBallsLeftToBowl = team2.PlayersDetails[PresentBowlerId - 1].NoOfBallsLeftToBowl - 1;
                    BallsLeftInCurrentOver = BallsLeftInCurrentOver - 1;
                }
            }
            BallsLeft = BallsLeft - 1;
            if (BallsLeftInCurrentOver == 0) {
                NewBowlerGenerator newBowlerGenerator = new NewBowlerGenerator();
                if (BallsLeft != 0) {
                    int bowler = newBowlerGenerator.newBowlerOfTeam2Generator(PresentBowlerId, team2, team1);
                    if (bowler > 0) {
                        PresentBowlerId = bowler;
                    }
                    BallsLeftInCurrentOver = 6;
                }

            }

            if (BallsLeft == 0 || team1.TotalNoOfWicketsLeftTeam == 0 || team1.TotalNoOfRunsScoredByTeam > team2.TotalNoOfRunsScoredByTeam) {
                for (int i = 0; i < 10; i++) {
                    player1_data.add(team1.PlayersDetails[i]);
                    data1.add(player1_data);
                }
                if (BallsLeft == 0 || team1.TotalNoOfWicketsLeftTeam == 0 && team1.TotalNoOfRunsScoredByTeam < team2.TotalNoOfRunsScoredByTeam) {

                    System.out.println("TEAM1 HAS LOT THE MATCH AND TEAM 2 WON BY" + "  " + (team2.TotalNoOfRunsScoredByTeam - team1.TotalNoOfRunsScoredByTeam) + "runs");
                    System.out.println("team 1 batting has ended and here is the score board");
                    for (int i = 0; i < 10; i++) {
                        System.out.println(team1.PlayersDetails[i].PlayerNumber + " ->" + "who was a" + " " + team1.PlayersDetails[i].BatsmenOrBowler + " " + "score" + "->" + team1.PlayersDetails[i].RunsScored);
                    }
                    System.out.println(" ");
                    System.out.println("TEAM2 BOWLER PERFORMANCE IS :");
                    for (int i = 5; i < 10; i++) {
                        System.out.println(team2.PlayersDetails[i].NoOfWicketsTaken);
                    }
                } else {
                    System.out.println("TEAM 1 HAS WON THE MATCH by " + " " + team1.TotalNoOfWicketsLeftTeam + " " + " and has chased" + " " + team2.TotalNoOfRunsScoredByTeam);
                    break;
                }
            }
        }
    }
}

