/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColdWar.models.turn;

import ColdWar.models.ApplicationInstance;
import ColdWar.models.missions.MissionType;
import ColdWar.models.player.IPlayer;
import java.util.Random;

/**
 * First turn.
 * Extends the Turn abstract class.
 */
public class FirstTurn extends Turn{
    
    Random rnd;
    
    public FirstTurn(){
        rnd = new Random();
    }
    

    /**
     * {@inheritDoc}
     */
    public IPlayer selectPlayer(){
        int chosenPlayer = rnd.nextInt(ApplicationInstance.getInstance().getPlayers().get().size());
        while(ApplicationInstance.getInstance().getPlayer(chosenPlayer).get().hasPlayedThisTurn(1)){
            chosenPlayer = rnd.nextInt(ApplicationInstance.getInstance().getPlayers().get().size());
        }
        ApplicationInstance.getInstance().getPlayer(chosenPlayer).get().playTurn(1);
        return ApplicationInstance.getInstance().getPlayer(chosenPlayer).get();
    }

    /**
     * {@inheritDoc} 
     */
    public MissionType selectMission(IPlayer player) {
        return MissionType.values()[rnd.nextInt(Turn.POSSIBLE_MISSIONS_WITH_EXTRA)];
    }
}