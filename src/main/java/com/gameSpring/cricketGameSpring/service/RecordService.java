package com.gameSpring.cricketGameSpring.service;

import com.gameSpring.cricketGameSpring.entity.EntityPlayerTeam1;
import com.gameSpring.cricketGameSpring.entity.EntityPlayerTeam2;
import com.gameSpring.cricketGameSpring.repository.Player1Repo;
import com.gameSpring.cricketGameSpring.repository.Player2Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class RecordService {
    @Autowired
    private Player1Repo player1Repo;
    @Autowired
    private Player2Repo player2Repo;

    public void addData() throws Exception {
        Game game = new Game();
        List<List<Player>> data = game.gameInitializer();
        for (int i = 0; i < data.size(); i++) {
            List<Player> team = data.get(i);
            for (int j = 0; j < team.size(); j++) {
                if (i == 0) {
                    Player player = team.get(j);
                    EntityPlayerTeam1 entity = new EntityPlayerTeam1();
                    System.out.println(team.get(j));
                    entity.BatsmenOrBowler = player.BatsmenOrBowler;
                    entity.NoOfWicketsTaken = player.NoOfWicketsTaken;
                    entity.PlayerNumber = player.PlayerNumber;
                    entity.RunsScored = player.RunsScored;
                    entity.NoOfBallsLeftToBowl = player.NoOfBallsLeftToBowl;
                    player1Repo.save(entity);
                }
                if (i == 1) {
                    Player player = team.get(j);
                    EntityPlayerTeam2 entity = new EntityPlayerTeam2();
                    System.out.println(team.get(j));
                    entity.BatsmenOrBowler = player.BatsmenOrBowler;
                    entity.NoOfWicketsTaken = player.NoOfWicketsTaken;
                    entity.PlayerNumber = player.PlayerNumber;
                    entity.RunsScored = player.RunsScored;
                    entity.NoOfBallsLeftToBowl = player.NoOfBallsLeftToBowl;
                    player2Repo.save(entity);
                }
            }
        }
    }

    public List<EntityPlayerTeam1> getmeTeam1Records() {
        return player1Repo.findAll();
    }

    public List<EntityPlayerTeam2> getmeTeam2Records() {
        return player2Repo.findAll();
    }

}
