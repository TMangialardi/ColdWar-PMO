/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColdWar.models.missions;

import ColdWar.models.ApplicationInstance;
import ColdWar.models.player.IPlayer;
import ColdWar.models.player.Team;
import java.util.Random;

/**
 * Implementation of the TipMission interface.
 */
public class Tip implements TipMission{
    
    private final Random rnd;
    private IPlayer drawnPlayer;
    
    public Tip(){
        this.rnd = new Random();
        this.drawnPlayer = null;
    }
    
    /**
     * {@inheritDoc}
     */
    public String playMission(IPlayer player) {
        int randomIndex = ApplicationInstance.getInstance().getPlayers().get().indexOf(player);
        while(randomIndex == ApplicationInstance.getInstance().getPlayers().get().indexOf(player)){
            randomIndex = rnd.nextInt(ApplicationInstance.getInstance().getPlayers().get().size());
        }
        this.drawnPlayer = ApplicationInstance.getInstance().getPlayer(randomIndex).get();
        return this.drawnPlayer.getName();
    }    

    /**
     * {@inheritDoc}
     */
    public Team getDrawnPlayerTeam() {
        return this.drawnPlayer.getTeam();
    }

    /**
     * {@inheritDoc}
     */
    public MissionType getMissionType() {
        return MissionType.TIP;
    }
    
}
