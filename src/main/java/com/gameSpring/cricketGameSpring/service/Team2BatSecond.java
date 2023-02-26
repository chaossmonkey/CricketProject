package com.gameSpring.cricketGameSpring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Team2BatSecond {
    private int BallsLeft;
    private int BallsLeftInCurrentOver;
    private int BatsmenOnStrikeId;
    private int BatsmenOnNonStrikerId;
    private int PresentBowlerId;
    private final List<Player> team2Batsecond = new ArrayList<>();

    Team2BatSecond() {
        BallsLeft = 18;
        BallsLeftInCurrentOver = 6;
        BatsmenOnStrikeId = 1;
        BatsmenOnNonStrikerId = 2;
        PresentBowlerId = 10;
    }

    public void Team2BattingSecond(Team team2, Team team1, RandomFunction randomFunction, List<List<Player>> data1) throws Exception {
        while (team2.TotalNoOfWicketsLeftTeam > 0 && BallsLeft > 0 && BallsLeftInCurrentOver > 0) {
            System.out.println("PLAYER" + " " + BatsmenOnStrikeId + "IS AT THE CREASE" + " " + "AND PLAYER " + " " + BatsmenOnNonStrikerId + "IS AT NON-STRIKER END");
            System.out.println("BOWLER of team1  " + " " + PresentBowlerId + " " + "IS ABOUT TO BALL");
            System.out.println("PLEASE PRESS ENTER TO START AGAIN");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
            int random_for_Batsmen;
            if (team2.PlayersDetails[BatsmenOnStrikeId - 1].BatsmenOrBowler.equals("batsmen")) {
                random_for_Batsmen = randomFunction.generateRandomForBatsmen(1, 7);
                if (random_for_Batsmen == 7) {
                    System.out.println("THIS IS WICKET FOR BOWLER " + " " + "->" + PresentBowlerId);
                    team1.PlayersDetails[PresentBowlerId - 1].NoOfWicketsTaken = team1.PlayersDetails[PresentBowlerId - 1].NoOfWicketsTaken + 1;
                    team1.PlayersDetails[PresentBowlerId - 1].NoOfBallsLeftToBowl = team1.PlayersDetails[PresentBowlerId - 1].NoOfBallsLeftToBowl - 1;
                    team2.TotalNoOfWicketsLeftTeam = team2.TotalNoOfWicketsLeftTeam - 1;
                    BallsLeftInCurrentOver = BallsLeftInCurrentOver - 1;
                    BatsmenOnStrikeId = Math.max(BatsmenOnStrikeId, BatsmenOnNonStrikerId) + 1;
                } else {
                    if (random_for_Batsmen % 2 == 0) {
                        team2.PlayersDetails[BatsmenOnStrikeId - 1].RunsScored = team2.PlayersDetails[BatsmenOnStrikeId - 1].RunsScored + random_for_Batsmen;
                        team2.TotalNoOfRunsScoredByTeam = team2.TotalNoOfRunsScoredByTeam + random_for_Batsmen;
                    } else {
                        team2.PlayersDetails[BatsmenOnStrikeId - 1].RunsScored = team2.PlayersDetails[BatsmenOnStrikeId - 1].RunsScored + random_for_Batsmen;
                        int VariableForInterchange = BatsmenOnNonStrikerId;
                        BatsmenOnNonStrikerId = BatsmenOnStrikeId;
                        BatsmenOnStrikeId = VariableForInterchange;
                        team2.TotalNoOfRunsScoredByTeam = team2.TotalNoOfRunsScoredByTeam + random_for_Batsmen;
                    }
                    team1.PlayersDetails[PresentBowlerId - 1].NoOfBallsLeftToBowl = team1.PlayersDetails[PresentBowlerId - 1].NoOfBallsLeftToBowl - 1;
                    BallsLeftInCurrentOver = BallsLeftInCurrentOver - 1;
                }
            } else {
                random_for_Batsmen = randomFunction.generateRandomForBowler(1, 7);
                if (random_for_Batsmen == 7) {
                    System.out.println("THIS IS WICKET FOR BOWLER " + " " + "->" + PresentBowlerId);
                    team1.PlayersDetails[PresentBowlerId - 1].NoOfWicketsTaken = team1.PlayersDetails[PresentBowlerId - 1].NoOfWicketsTaken + 1;
                    team1.PlayersDetails[PresentBowlerId - 1].NoOfBallsLeftToBowl = team1.PlayersDetails[PresentBowlerId - 1].NoOfBallsLeftToBowl - 1;
                    team2.TotalNoOfWicketsLeftTeam = team2.TotalNoOfWicketsLeftTeam - 1;
                    BallsLeftInCurrentOver = BallsLeftInCurrentOver - 1;
                    BatsmenOnStrikeId = Math.max(BatsmenOnStrikeId, BatsmenOnNonStrikerId) + 1;
                } else {
                    if (random_for_Batsmen % 2 == 0) {
                        team2.PlayersDetails[BatsmenOnStrikeId - 1].RunsScored = team2.PlayersDetails[BatsmenOnStrikeId - 1].RunsScored + random_for_Batsmen;
                        team2.TotalNoOfRunsScoredByTeam = team2.TotalNoOfRunsScoredByTeam + random_for_Batsmen;
                    } else {
                        team2.PlayersDetails[BatsmenOnStrikeId - 1].RunsScored = team2.PlayersDetails[BatsmenOnStrikeId - 1].RunsScored + random_for_Batsmen;
                        int ThirdExtraVariableForInterchange = BatsmenOnNonStrikerId;
                        BatsmenOnNonStrikerId = BatsmenOnStrikeId;
                        BatsmenOnStrikeId = ThirdExtraVariableForInterchange;
                        team2.TotalNoOfRunsScoredByTeam = team2.TotalNoOfRunsScoredByTeam + random_for_Batsmen;
                    }

                    team1.PlayersDetails[PresentBowlerId - 1].NoOfBallsLeftToBowl = team1.PlayersDetails[PresentBowlerId - 1].NoOfBallsLeftToBowl - 1;
                    BallsLeftInCurrentOver = BallsLeftInCurrentOver - 1;

                }
            }
            BallsLeft = BallsLeft - 1;
            if (BallsLeftInCurrentOver == 0) {
                NewBowlerGenerator n1 = new NewBowlerGenerator();
                if (BallsLeft != 0) {
                    int temp = n1.newbowlerofteam1Generator(PresentBowlerId, team2, team1);
                    if (temp > 0) {
                        PresentBowlerId = temp;
                    }
                    BallsLeftInCurrentOver = 6;
                }

            }
            if (BallsLeft == 0 || team2.TotalNoOfWicketsLeftTeam == 0 || team2.TotalNoOfRunsScoredByTeam > team1.TotalNoOfRunsScoredByTeam) {
                for (int i = 0; i < 10; i++) {
                    team2Batsecond.add(team2.PlayersDetails[i]);
                }
                data1.add(team2Batsecond);
                if (BallsLeft == 0 || team2.TotalNoOfWicketsLeftTeam == 0 && team2.TotalNoOfRunsScoredByTeam < team1.TotalNoOfRunsScoredByTeam) {

                    System.out.println("TEAM2 HAS LOT THE MATCH AND TEAM 1 WON BY" + "  " + (team1.TotalNoOfRunsScoredByTeam - team2.TotalNoOfRunsScoredByTeam) + "runs");
                    System.out.println("team 2 batting has ended and here is the score board");
                    for (int i = 0; i < 10; i++) {

                        System.out.println(team2.PlayersDetails[i].PlayerNumber + " ->" + "who was a" + " " + team1.PlayersDetails[i].BatsmenOrBowler + " " + "score" + "->" + team2.PlayersDetails[i].RunsScored);
                    }
                    System.out.println(" ");
                    System.out.println("TEAM1 BOWLER PERFORMANCE IS :");
                    for (int i = 6; i < 10; i++) {
                        System.out.println(team1.PlayersDetails[i].NoOfWicketsTaken);
                    }
                } else {
                    System.out.println("TEAM 2 HAS WON THE MATCH by " + " " + team2.TotalNoOfWicketsLeftTeam + " " + " and has chased" + " " + team1.TotalNoOfRunsScoredByTeam);
                    System.out.println("team 2 batting has ended and here is the score board");
                    System.out.println("--->this where error might be happening");
                    break;
                }
            }
        }
    }
}

