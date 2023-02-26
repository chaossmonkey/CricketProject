package com.gameSpring.cricketGameSpring.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NewBowlerGenerator {
    public int newBowlerOfTeam2Generator(int PresentBowlerId, Team t2, Team t1) throws IOException {
        System.out.println("select the next bowler to bowl the new over apart from " + " " + PresentBowlerId);
        InputStreamReader IR = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(IR);
        int BowlerNoId = Integer.parseInt(br.readLine());
        if (BowlerNoId != PresentBowlerId && BowlerNoId > 5 && BowlerNoId <= 10) {
            if (t2.PlayersDetails[BowlerNoId - 1].NoOfBallsLeftToBowl > 0) {
                return BowlerNoId;
            } else {
                System.out.println("this bowler " + " " + PresentBowlerId + " " + "has already finished all his overs");
                System.out.println("pls enter a valid number btwn 6-10");
                System.out.println("select the next bowler to bowl the new over apart from " + " " + PresentBowlerId);
                InputStreamReader IRr = new InputStreamReader(System.in);
                BufferedReader brr = new BufferedReader(IRr);
                int BowlerNoId1 = Integer.parseInt(brr.readLine());
                if (BowlerNoId1 != PresentBowlerId && BowlerNoId1 > 5 && BowlerNoId1 <= 10) {
                    if (t2.PlayersDetails[BowlerNoId1 - 1].NoOfBallsLeftToBowl > 0) {
                        return BowlerNoId1;
                    } else {
                        System.out.println("the bowler " + " " + PresentBowlerId + "has finished all his over");
                    }
                }
            }
        } else {
            System.out.println("pls enter a valid number btwn 6-10");
            System.out.println("select the next bowler to bowl the new over apart from " + " " + PresentBowlerId);
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            int PresentBowler = Integer.parseInt(bufferedReader.readLine());
            if (PresentBowler != PresentBowlerId && PresentBowler > 5 && PresentBowler <= 10) {
                if (t2.PlayersDetails[PresentBowler - 1].NoOfBallsLeftToBowl > 0) {
                    return PresentBowler;
                } else {
                    System.out.println("the bowler " + " " + PresentBowlerId + "has finished all his over");
                }
            }
        }

        return 0;
    }

    public int newbowlerofteam1Generator(int k, Team t2, Team t1) throws Exception {
        System.out.println("select the next bowler to bowl the new over apart from " + " " + k);
        InputStreamReader IR = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(IR);
        int PresentBowler = Integer.parseInt(br.readLine());
        if (PresentBowler != k && PresentBowler > 5 && PresentBowler <= 10) {
            if (t1.PlayersDetails[PresentBowler - 1].NoOfBallsLeftToBowl > 0) {
                return PresentBowler;
            } else {
                System.out.println("this bowler " + " " + k + " " + "has already finished all his overs");
                System.out.println("pls enter a valid number btwn 6-10");
                System.out.println("select the next bowler to bowl the new over apart from " + " " + k);
                InputStreamReader IRr = new InputStreamReader(System.in);
                BufferedReader brr = new BufferedReader(IRr);
                int presentBowlera = Integer.parseInt(brr.readLine());
                if (presentBowlera != k && presentBowlera > 5 && presentBowlera <= 10) {
                    if (t1.PlayersDetails[presentBowlera - 1].NoOfBallsLeftToBowl > 0) {
                        return presentBowlera;
                    } else {
                        System.out.println("the bowler " + " " + k + "has finished all his over");
                    }
                }

            }
        } else {
            System.out.println("pls enter a valid number btwn 6-10");
            System.out.println("select the next bowler to bowl the new over apart from " + " " + k);
            InputStreamReader IRr = new InputStreamReader(System.in);
            BufferedReader brr = new BufferedReader(IRr);
            int ValidBowlerId = Integer.parseInt(brr.readLine());
            if (ValidBowlerId != k && ValidBowlerId > 5 && ValidBowlerId <= 10) {
                if (t1.PlayersDetails[ValidBowlerId - 1].NoOfBallsLeftToBowl > 0) {
                    return ValidBowlerId;
                } else {
                    System.out.println("the bowler " + " " + k + "has finished all his over");
                }
            }
        }
        return 0;
    }
}
