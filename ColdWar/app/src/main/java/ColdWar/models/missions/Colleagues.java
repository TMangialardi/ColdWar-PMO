/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColdWar.models.missions;

import ColdWar.models.ApplicationInstance;
import ColdWar.models.player.IPlayer;
import java.util.Random;

/**
 * Implementation of the ColleaguesMission interface.
 */
public class Colleagues implements ColleaguesMission{

    private IPlayer firstPlayer;
    private IPlayer secondPlayer;
    private final Random rnd;
    
    public Colleagues(){
        this.firstPlayer = null;
        this.secondPlayer = null;
        this.rnd = new Random();
    }
    
    /**
     * {@inheritDoc}
     */
    public void playMission() {
        int randomIndex = rnd.nextInt(ApplicationInstance.getInstance().getPlayers().get().size());
        this.firstPlayer = ApplicationInstance.getInstance().getPlayer(randomIndex).get();
        while(randomIndex == ApplicationInstance.getInstance().getPlayers().get().indexOf(firstPlayer) ||
                this.firstPlayer.getTeam() != ApplicationInstance.getInstance().getPlayer(randomIndex).get().getTeam()){
            randomIndex = rnd.nextInt(ApplicationInstance.getInstance().getPlayers().get().size());
        }
        this.secondPlayer = ApplicationInstance.getInstance().getPlayer(randomIndex).get();
    }

    /**
     * {@inheritDoc}
     */
    public String getDrawnPlayerName(int num) {
        
        switch (num) {
            case 1:
                return this.firstPlayer.getName();
            case 2:
                return this.secondPlayer.getName();
            default:
                return "";
        }
    }

    /**
     * {@inheritDoc}
     */
    public MissionType getMissionType() {
        return MissionType.COLLEAGUES;
    }
    
}
