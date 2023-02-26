package com.gameSpring.cricketGameSpring.controller;

import com.gameSpring.cricketGameSpring.entity.EntityPlayerTeam1;
import com.gameSpring.cricketGameSpring.entity.EntityPlayerTeam2;
import com.gameSpring.cricketGameSpring.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GameController {
    @Autowired
    private RecordService recordService;

    @GetMapping("/start")
    public void startGame() throws Exception {
        recordService.addData();
    }

    @GetMapping("/team1Records")
    public List<EntityPlayerTeam1> getgetmeTeam1Records() throws Exception {
        return recordService.getmeTeam1Records();
    }

    @GetMapping("/team2Records")
    public List<EntityPlayerTeam2> getgetmeTeam2Records() throws Exception {
        return recordService.getmeTeam2Records();
    }

    @GetMapping("/getMatchWinner")
    public String getMatchWinner() throws Exception {
        List<EntityPlayerTeam1> team1PlayerList = getgetmeTeam1Records();
        List<EntityPlayerTeam2> team2PlayerList = getgetmeTeam2Records();

        int team1TotalRuns = 0;
        int team2TotalRuns = 0;
        for (EntityPlayerTeam1 player : team1PlayerList) {
            team1TotalRuns += player.getRunsScored();
        }
        for (EntityPlayerTeam2 player : team2PlayerList) {
            team2TotalRuns += player.getRunsScored();
        }
        if (team1TotalRuns > team2TotalRuns) {
            int diff = team1TotalRuns - team2TotalRuns;
            String result = "Team 1 won the match by " + diff+" "+"runs";
            return result;
        } else if (team2TotalRuns > team1TotalRuns) {
            int diff = team2TotalRuns - team1TotalRuns;
            String result = "Team 2 won the match by " + diff+" "+"runs";
            return result;
        } else {
            return "The match ended in a tie";
        }
    }

    @GetMapping("/scoreCard")
    public String getScoreCard() throws Exception {

        List<EntityPlayerTeam1> team1PlayerList = getgetmeTeam1Records();
        List<EntityPlayerTeam2> team2PlayerList = getgetmeTeam2Records();

        List<EntityPlayerTeam1> topThreeRunScorersTeam1 = team1PlayerList.stream().sorted(Comparator.comparingInt(EntityPlayerTeam1::getRunsScored).reversed()).limit(3).collect(Collectors.toList());
        List<EntityPlayerTeam2> topThreeRunScorersTeam2 = team2PlayerList.stream().sorted(Comparator.comparingInt(EntityPlayerTeam2::getRunsScored).reversed()).limit(3).collect(Collectors.toList());

        List<EntityPlayerTeam1> topThreeWicketsTakersTeam1 = team1PlayerList.stream().sorted(Comparator.comparingInt(EntityPlayerTeam1::getNoOfWicketsTaken).reversed()).limit(3).collect(Collectors.toList());
        List<EntityPlayerTeam2> topThreeWicketsTakersTeam2 = team2PlayerList.stream().sorted(Comparator.comparingInt(EntityPlayerTeam2::getNoOfWicketsTaken).reversed()).limit(3).collect(Collectors.toList());


        StringBuilder result = new StringBuilder();
        for (int i = 0; i < topThreeRunScorersTeam1.size(); i++) {
            EntityPlayerTeam1 team1Player = topThreeRunScorersTeam1.get(i);
            result.append(team1Player.getPlayerNumber()).append(" ").append("OF TEAM1 ").append(":").append(team1Player.getRunsScored()).append(" runs)").append("\n");
        }
        for (int i = 0; i < topThreeWicketsTakersTeam1.size(); i++) {
            EntityPlayerTeam1 team1Player = topThreeWicketsTakersTeam1.get(i);
            result.append(team1Player.getPlayerNumber()).append(" ").append("OF TEAM1 ").append(":").append(team1Player.getNoOfWicketsTaken()).append(" wickets )").append("\n");
        }
        result.append("--------------------------------").append("\n");

        for (int i = 0; i < topThreeRunScorersTeam2.size(); i++) {
            EntityPlayerTeam2 team2Player = topThreeRunScorersTeam2.get(i);
            result.append(team2Player.getPlayerNumber()).append(" ").append("OF TEAM2 ").append(":").append(team2Player.getRunsScored()).append(" runs)").append("\n");
        }
        for (int i = 0; i < topThreeWicketsTakersTeam2.size(); i++) {
            EntityPlayerTeam2 team2Player = topThreeWicketsTakersTeam2.get(i);
            result.append(team2Player.getPlayerNumber()).append(" ").append("OF TEAM2").append(":").append(team2Player.getNoOfWicketsTaken()).append(" wickets )").append("\n");
        }

        return result.toString();
    }
}
