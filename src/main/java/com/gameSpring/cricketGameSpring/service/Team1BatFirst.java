package com.gameSpring.cricketGameSpring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Team1BatFirst {

    private int BallsLeft;
    private int BallsLeftInCurrentOver;
    private int BatsmenOnStrikeId;
    private int BatsmenOnNonStrikerId;
    private int PresentBowlerId;

    private final ArrayList<Player> playersData_team1 = new ArrayList<>();
    private final List<List<Player>> data1=new ArrayList<>();

    Team1BatFirst() {
        BallsLeft = 18;
        BallsLeftInCurrentOver = 6;
        BatsmenOnStrikeId = 1;
        BatsmenOnNonStrikerId = 2;
        PresentBowlerId = 10;
    }

    public List<List<Player>> team1BattingFirst(Team team1, Team team2, RandomFunction randomfunction) throws Exception {

        while (team1.TotalNoOfWicketsLeftTeam > 0 && BallsLeft > 0 && BallsLeftInCurrentOver > 0) {
            System.out.println("PLAYER" + " " + BatsmenOnStrikeId + "IS AT THE CREASE" + " " + "AND PLAYER " + " " + BatsmenOnNonStrikerId + "IS AT NON-STRIKER END");
            System.out.println("BOWLER of team2  " + " " + PresentBowlerId + " " + "IS ABOUT TO BALL");
            System.out.println("PLEASE PRESS ENTER TO START AGAIN");
            //enterService.promptEnterKey();
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();

            int random_for_Batsmen;
            if (team1.PlayersDetails[BatsmenOnStrikeId - 1].BatsmenOrBowler.equals("batsmen")) {
                random_for_Batsmen = randomfunction.generateRandomForBatsmen(1, 7);
                if (random_for_Batsmen == 7) {
                    System.out.println("THIS IS WICKET FOR BOWLER " + " " + "->" + PresentBowlerId);
                    team2.PlayersDetails[PresentBowlerId - 1].NoOfWicketsTaken = team2.PlayersDetails[PresentBowlerId - 1].NoOfWicketsTaken + 1;
                    team2.PlayersDetails[PresentBowlerId - 1].NoOfBallsLeftToBowl = team2.PlayersDetails[PresentBowlerId - 1].NoOfBallsLeftToBowl - 1;
                    team1.TotalNoOfWicketsLeftTeam = team1.TotalNoOfWicketsLeftTeam - 1;
                    BallsLeftInCurrentOver = BallsLeftInCurrentOver - 1;
                    BatsmenOnStrikeId = Math.max(BatsmenOnStrikeId, BatsmenOnNonStrikerId) + 1;
                } else {
                    if (random_for_Batsmen % 2 == 0) {
                        team1.PlayersDetails[BatsmenOnStrikeId - 1].RunsScored = team1.PlayersDetails[BatsmenOnStrikeId - 1].RunsScored + random_for_Batsmen;
                        team1.TotalNoOfRunsScoredByTeam = team1.TotalNoOfRunsScoredByTeam + random_for_Batsmen;
                    } else {
                        team1.PlayersDetails[BatsmenOnStrikeId - 1].RunsScored = team1.PlayersDetails[BatsmenOnStrikeId - 1].RunsScored + random_for_Batsmen;
                        int temp = BatsmenOnNonStrikerId;
                        BatsmenOnNonStrikerId = BatsmenOnStrikeId;
                        BatsmenOnStrikeId = temp;
                        team1.TotalNoOfRunsScoredByTeam = team1.TotalNoOfRunsScoredByTeam + random_for_Batsmen;
                    }
                    team2.PlayersDetails[PresentBowlerId - 1].NoOfBallsLeftToBowl = team2.PlayersDetails[PresentBowlerId - 1].NoOfBallsLeftToBowl - 1;
                    BallsLeftInCurrentOver = BallsLeftInCurrentOver - 1;
                }

            } else {
                random_for_Batsmen = randomfunction.generateRandomForBowler(1, 7);
                if (random_for_Batsmen == 7) {
                    System.out.println("THIS IS WICKET FOR BOWLER " + " " + "->" + PresentBowlerId);
                    team2.PlayersDetails[PresentBowlerId - 1].NoOfWicketsTaken = team2.PlayersDetails[PresentBowlerId - 1].NoOfWicketsTaken + 1;
                    team2.PlayersDetails[PresentBowlerId - 1].NoOfBallsLeftToBowl = team2.PlayersDetails[PresentBowlerId - 1].NoOfBallsLeftToBowl - 1;
                    team1.TotalNoOfWicketsLeftTeam = team1.TotalNoOfWicketsLeftTeam - 1;
                    BallsLeftInCurrentOver = BallsLeftInCurrentOver - 1;
                    BatsmenOnStrikeId = Math.max(BatsmenOnStrikeId, BatsmenOnNonStrikerId) + 1;

                } else {
                    if (random_for_Batsmen % 2 == 0) {
                        team1.PlayersDetails[BatsmenOnStrikeId - 1].RunsScored = team1.PlayersDetails[BatsmenOnStrikeId - 1].RunsScored + random_for_Batsmen;
                        team1.TotalNoOfRunsScoredByTeam = team1.TotalNoOfRunsScoredByTeam + random_for_Batsmen;

                    } else {
                        team1.PlayersDetails[BatsmenOnStrikeId - 1].RunsScored = team1.PlayersDetails[BatsmenOnStrikeId - 1].RunsScored + random_for_Batsmen;
                        int VariableUsedForInterchange = BatsmenOnNonStrikerId;
                        BatsmenOnNonStrikerId = BatsmenOnStrikeId;
                        BatsmenOnStrikeId = VariableUsedForInterchange;
                        team1.TotalNoOfRunsScoredByTeam = team1.TotalNoOfRunsScoredByTeam + random_for_Batsmen;
                    }
                    team2.PlayersDetails[PresentBowlerId - 1].NoOfBallsLeftToBowl = team2.PlayersDetails[PresentBowlerId - 1].NoOfBallsLeftToBowl - 1;
                    BallsLeftInCurrentOver = BallsLeftInCurrentOver - 1;
                }
            }
            BallsLeft = BallsLeft - 1;
            if (BallsLeftInCurrentOver == 0) {
                NewBowlerGenerator n1 = new NewBowlerGenerator();
                if (BallsLeft != 0) {
                    int temp = n1.newBowlerOfTeam2Generator(PresentBowlerId, team2, team1);
                    if (temp > 0) {
                        PresentBowlerId = temp;
                    }
                    BallsLeftInCurrentOver = 6;
                }

            }

            if (BallsLeft == 0 || team1.TotalNoOfWicketsLeftTeam == 0) {
                for (int i = 0; i < 10; i++) {
                    System.out.println("team 1 player performace  are"+"--->"+team1.PlayersDetails[i]);
                    playersData_team1.add(team1.PlayersDetails[i]);
                }
                data1.add(playersData_team1);
                System.out.println("------->"+data1.size());
                System.out.println("team 1 batting has ended and here is the score board");
                for (int i = 0; i < 10; i++) {
                    System.out.println(team1.PlayersDetails[i].PlayerNumber + " ->" + "who was a" + " " + team1.PlayersDetails[i].BatsmenOrBowler + " " + "score" + "->" + team1.PlayersDetails[i].RunsScored);
                }
                System.out.println(" ");
                System.out.println("TEAM2 BOWLER PERFORMANCE IS :");
                for (int i = 5; i < 10; i++) {
                    System.out.println(team2.PlayersDetails[i].NoOfWicketsTaken);
                }

                System.out.println("NOW ITS TIME FOR TEAM 2 TO BAT");
                Team2BatSecond team2_bat_second = new Team2BatSecond();
                team2_bat_second.Team2BattingSecond(team2, team1, randomfunction, data1);
            }
        }
         return data1;
    }

}
